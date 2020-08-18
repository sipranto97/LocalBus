package com.example.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void userLocation(View v)
    {
        Intent mapIntent = new Intent(MainActivity.this,UserLocation.class);
        startActivity(mapIntent);

    }
}
