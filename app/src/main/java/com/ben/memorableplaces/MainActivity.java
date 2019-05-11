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

    public static List<String> placeList = new ArrayList<>();
    public static List<LatLng> locationList = new ArrayList<>();
    public static ArrayAdapter placesAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView placesListView = findViewById(R.id.placesView);

        placeList.add("Add New location ..");
        locationList.add(new LatLng(0,0));
        placesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , placeList);

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
