package com.example.localbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class search extends AppCompatActivity {
    private AutoCompleteTextView from,to;
    private String[] routename;
    //private Button findbus;
    private Button findbus;
    private static final  int Request_code_location_permission = 1;
    private TextView textLatLong;
    private ProgressBar progressBar;
    public double latitude ;
    public double longitude ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        from=findViewById(R.id.From);
        to=findViewById(R.id.To);
        routename=getResources().getStringArray(R.array.Route);
        ArrayAdapter<String> adapter= new  ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,routename);
        from.setThreshold(1);
        from.setAdapter(adapter);
        to.setThreshold(1);
        to.setAdapter(adapter);

        // innitialization
        findbus=(Button) findViewById(R.id.button_search);
        //set action on find bus button
        findbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all_bus();
            }
        });

    }
    public void all_bus_location(View v)
    {
        if(ContextCompat.checkSelfPermission(
                getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    search.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    Request_code_location_permission
            );
        }else {
            getCurrentLocation();
        }
        Intent mapIntent = new Intent(this,UserLocation.class);
        startActivity(mapIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == Request_code_location_permission && grantResults.length>0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getCurrentLocation();
            }else {
                Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getCurrentLocation(){
        if(ContextCompat.checkSelfPermission(
                getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED) {
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.setInterval(10000);
            locationRequest.setFastestInterval(3000);
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();

            LocationServices.getFusedLocationProviderClient(search.this)
                    .requestLocationUpdates(locationRequest, new LocationCallback() {
                        @Override
                        public void onLocationResult(LocationResult locationResult) {
                            super.onLocationResult(locationResult);

                            LocationServices.getFusedLocationProviderClient(search.this)
                                    .removeLocationUpdates(this);

                            if (locationResult != null && locationResult.getLocations().size() > 0) {
                                int latestLocationIndex = locationResult.getLocations().size() - 1;
                                latitude =
                                        locationResult.getLocations().get(latestLocationIndex).getLatitude();
                                longitude =
                                        locationResult.getLocations().get(latestLocationIndex).getLongitude();


                            }
                        }
                    }, Looper.getMainLooper());
        }
        else {
            ActivityCompat.requestPermissions(
                    search.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    Request_code_location_permission
            );
        }
    }
    public void all_bus()
    {
        Intent intent= new Intent(search.this, BusRootActivity.class);
        startActivity(intent);
    }





}