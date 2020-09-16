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
import com.google.firebase.database.FirebaseDatabase;

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
    public String myLoc = "User1";

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

        Intent mapIntent = new Intent(this,UserLocation.class);
        startActivity(mapIntent);
    }




    public void all_bus()
    {
        Intent intent= new Intent(search.this, BusRootActivity.class);
        startActivity(intent);
    }





}