package com.MonkeTeam.psychotherapia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import com.MonkeTeam.psychotherapia.utils.ui.ButtonUI;
import com.MonkeTeam.psychotherapia.utils.ui.FontUI;

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

        Button login_button = findViewById(R.id.main_login_button);
        Button signup_button = findViewById(R.id.main_signup_button);
        TextView title = findViewById(R.id.main_title);

        ButtonUI.makePrimary(this, login_button, ButtonUI.PACIFICO, false);
        ButtonUI.makeSecondary(this, signup_button, ButtonUI.PACIFICO, false);

        FontUI.makePacifio(this, title);
    }

    public void hideLoadingFragment()
    {
        Fragment loading_overlay_fragment = getSupportFragmentManager().findFragmentById(R.id.overlay_frame_container_view);

        if(loading_overlay_fragment != null)
        {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(0, R.anim.fade_out)
                    .hide(loading_overlay_fragment)
                    .commit();
        }

    }
}