package com.example.collapsingprofilescreen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;

    int colorOfFet = 0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bangladesh");
        setActionBar(toolbar);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                colorOfFet = -(i);
                if (colorOfFet > 255)
                    colorOfFet = 255;


                //Hide toolbar
                toolbar.getBackground().setAlpha(colorOfFet);
                toolbar.setAlpha(colorOfFet / 256f);
            }
        });
    }
}