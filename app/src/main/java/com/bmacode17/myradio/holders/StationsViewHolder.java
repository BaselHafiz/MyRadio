package com.bmacode17.myradio.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bmacode17.myradio.Model.Station;
import com.bmacode17.myradio.R;

/**
 * Created by User on 18-Mar-18.
 */

public class StationsViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    public ImageView imageView;

    public StationsViewHolder(View itemView) {

        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }

    public void updateUI(Station station){

        String uri = station.getImageUri();
        int resource = imageView.getResources().getIdentifier(uri,null,imageView.getContext().getPackageName());
        imageView.setImageResource(resource);

        textView.setText(station.getStationTitle());

    }
}
