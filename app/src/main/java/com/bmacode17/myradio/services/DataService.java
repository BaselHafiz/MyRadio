package com.bmacode17.myradio.services;

import com.bmacode17.myradio.Model.Station;

import java.util.ArrayList;

/**
 * Created by User on 23-Mar-18.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStations(){

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan(Tunes for Travel)","flightplanmusic"));
        list.add(new Station("Two Wheelin'   (Biking Playlist)","bicyclemusic"));
        list.add(new Station("Kids Jams(Music for Children)","kidsmusic"));
        return list;
    }

    public ArrayList<Station> getRecentStations(){

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan(Tunes for Travel)","flightplanmusic"));
        list.add(new Station("Two Wheelin'   (Biking Playlist)","bicyclemusic"));
        list.add(new Station("Kids Jams(Music for Children)","kidsmusic"));
        return list;
    }

    public ArrayList<Station> getPartyStations(){

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan(Tunes for Travel)","flightplanmusic"));
        list.add(new Station("Two Wheelin'   (Biking Playlist)","bicyclemusic"));
        list.add(new Station("Kids Jams(Music for Children)","kidsmusic"));
        return list;
    }
}
