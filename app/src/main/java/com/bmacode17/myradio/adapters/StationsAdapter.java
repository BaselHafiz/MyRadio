package com.bmacode17.myradio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bmacode17.myradio.Model.Station;
import com.bmacode17.myradio.R;
import com.bmacode17.myradio.activities.MainActivity;
import com.bmacode17.myradio.holders.StationsViewHolder;

import java.util.ArrayList;

/**
 * Created by User on 18-Mar-18.
 */

public class StationsAdapter  extends RecyclerView.Adapter<StationsViewHolder>{

    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public StationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View stationLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_station,parent,false);

        StationsViewHolder viewHolder = new StationsViewHolder(stationLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StationsViewHolder holder, int position) {

        final Station station = stations.get(position);
        holder.updateUI(station);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.getMainActivity().loadDetailsFragment(station);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
