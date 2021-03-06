package com.bmacode17.myradio.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bmacode17.myradio.R;
import com.bmacode17.myradio.adapters.StationsAdapter;
import com.bmacode17.myradio.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StationsFragment.StationsFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

//import android.app.Fragment;
import android.support.v4.app.Fragment;
public class StationsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    private static final String ARG_STATION_TYPE = "station_type";
    private int stationType;

    private StationsFragmentInteractionListener mListener;

    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType The Radio Stations Type

     * @return A new instance of fragment StationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_stations, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerStations);
        recyclerView.setHasFixedSize(true);

        StationsAdapter adapter;

        if(stationType == STATION_TYPE_FEATURED){

            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        }else if(stationType == STATION_TYPE_RECENT){

            adapter = new StationsAdapter(DataService.getInstance().getRecentStations());
        }else{
            adapter = new StationsAdapter(DataService.getInstance().getPartyStations());
        }

        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(10));
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onStationsFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StationsFragmentInteractionListener) {
            mListener = (StationsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStationsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface StationsFragmentInteractionListener {
        // TODO: Update argument type and name
        void onStationsFragmentInteraction(Uri uri);
    }
}


 class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {

    private final int spacer;

     public HorizontalSpaceItemDecorator(int spacer) {
         this.spacer = spacer;
     }

     @Override
     public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
         super.getItemOffsets(outRect, view, parent, state);
         outRect.right = spacer;
     }
 }