package com.ben.memorableplaces;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Locations {
    private List<LatLng> locations = new ArrayList<>();

    public List<LatLng> getLocations() {
        return locations;
    }

    public void setLocations(List<LatLng> locations) {
        this.locations = locations;
    }

}
