package com.ben.memorableplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {


    public static ArrayAdapter placesAdapter ;
    public static Places places;
    private SharedPreferenceUtil sharedPreferenceUtil = new SharedPreferenceUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView placesListView = findViewById(R.id.placesView);

        Locations locations = sharedPreferenceUtil.get(this, "locationList", Locations.class);
        places = sharedPreferenceUtil.get(this, "placeList", Places.class);
        places.getPlaces().add(0, "Add New location ..");
        locations.getLocations().add(new LatLng(0,0));
        placesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , places.getPlaces());

        placesListView.setAdapter(placesAdapter);

        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });


    }
}
