package com.bmacode17.myradio.Model;

/**
 * Created by User on 22-Mar-18.
 */

public class Station {

    private String stationTitle;
    private String imageUri;
    final String DRAWABLE = "drawable/";

    public Station(String stationTitle, String imageUri) {
        this.stationTitle = stationTitle;
        this.imageUri = imageUri;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public String getImageUri() {
        return DRAWABLE + imageUri;
    }
}
