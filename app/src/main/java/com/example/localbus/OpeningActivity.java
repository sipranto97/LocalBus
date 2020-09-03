package com.example.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class OpeningActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;


    //variable
    Animation topAnim, bottomAnim;
    GifImageView gif;
    TextView title1, slogan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_opening);

        //Animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Initilize the variables
        gif= findViewById(R.id.app_gif);
        title1= findViewById(R.id.app_title);
        slogan1= findViewById(R.id.slogan);

        //set Animation
        gif.setAnimation(topAnim);
        title1.setAnimation(bottomAnim);
        slogan1.setAnimation(bottomAnim);

        //Splash Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(OpeningActivity.this, search.class);
                Pair[] pairs= new Pair[2];
                pairs[0]= new Pair<View,String>(gif,"logo_image");
                pairs[1]= new Pair<View,String>(gif,"logo_text");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions option=  ActivityOptions.makeSceneTransitionAnimation(OpeningActivity.this,pairs);
                    startActivity(intent,option.toBundle());
                }
                finish();

            }
        },SPLASH_SCREEN);
    }
}