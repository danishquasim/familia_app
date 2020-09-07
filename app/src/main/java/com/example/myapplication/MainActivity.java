package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    View first,second,third;
    TextView tagline ;
    //animation
    Animation topAnimation,bottomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        first = findViewById(R.id.imageView2);
        tagline = findViewById(R.id.textView);
        //combine of animation to screen elements
        first.setAnimation(topAnimation);
        tagline.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MainActivity12.class);
               // startActivity(intent);
               // finish();
                Pair[] pairs =new Pair[2];
                pairs[0] = new Pair<View, String>(first, "logo_image");
                pairs[1] = new Pair<View, String>(tagline, "tag_line");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( MainActivity.this,pairs);
                startActivity(intent,options.toBundle());
                finish();

            }
        },SPLASH_TIME_OUT);

    }
}