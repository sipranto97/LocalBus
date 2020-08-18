package com.example.localbus;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UserLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(23.763885, 90.406803);
        LatLng farmgate = new LatLng(23.764071, 90.401996);
        LatLng energypack = new LatLng(23.765590, 90.404394);
        LatLng bus3 = new LatLng(23.760666, 90.400870);
        LatLng bus4 = new LatLng(23.762254, 90.408691);


        mMap.addMarker(new MarkerOptions().position(sydney).title("Aust"));
        mMap.addMarker(new MarkerOptions().position(farmgate).title("Farmgate").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus1)).title("Bus1"));
        mMap.addMarker(new MarkerOptions().position(energypack).title("EnergyPack").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus1)).title("Bus2"));
        mMap.addMarker(new MarkerOptions().position(bus3).title("Butex").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus1)).title("Bus3"));
        mMap.addMarker(new MarkerOptions().position(bus4).title("Aust").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus1)).title("Bus4"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setMinZoomPreference(15);
    }
}
