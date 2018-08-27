package com.bmacode17.myradio.activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bmacode17.myradio.Model.Station;
import com.bmacode17.myradio.R;
import com.bmacode17.myradio.fragments.DetailsFragment;
import com.bmacode17.myradio.fragments.MainFragment;
import com.bmacode17.myradio.fragments.StationsFragment;

public class MainActivity extends AppCompatActivity
        implements MainFragment.MainFragmentInteractionListener  , StationsFragment.StationsFragmentInteractionListener{

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.fragmentContainer);

        if(mainFragment == null){
            mainFragment = MainFragment.newInstance("Blah","Blah");
            fragmentManager.beginTransaction().add(R.id.fragmentContainer,mainFragment).commit();
        }
    }

    public void loadDetailsFragment(Station selectedStation){

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onStationsFragmentInteraction(Uri uri) {

    }

}
