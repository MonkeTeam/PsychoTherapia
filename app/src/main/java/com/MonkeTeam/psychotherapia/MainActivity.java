package com.MonkeTeam.psychotherapia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.overlay_frame_container_view, LoadingOverlay.class, null)
                    .commit();
        }

        (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadingFragment();
            }
        }, 2000);
    }

    public void hideLoadingFragment()
    {
        Fragment loading_overlay_fragment = getSupportFragmentManager().findFragmentById(R.id.overlay_frame_container_view);

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(0, R.anim.fade_out)
                .hide(loading_overlay_fragment)
                .commit();

    }
}