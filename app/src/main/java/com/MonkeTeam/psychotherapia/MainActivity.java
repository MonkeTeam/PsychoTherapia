package com.MonkeTeam.psychotherapia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.MonkeTeam.psychotherapia.auth.LoginActivity;
import com.MonkeTeam.psychotherapia.auth.SignupActivity;
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

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClicked();
            }
        });
        signup_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                signupClicked();
            }
        });
    }

    public void hideLoadingFragment()
    {
        Fragment loading_overlay_fragment = getSupportFragmentManager().findFragmentById(R.id.overlay_frame_container_view);
        Log.e("ASD", "attempting to remove fragment");

        if(loading_overlay_fragment != null)
        {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(0, R.anim.fade_out)
                    .remove(loading_overlay_fragment)
                    .commit();

            (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("ASD", "Removing from view - " + android.R.integer.config_shortAnimTime);
                    View fragment_container = findViewById(R.id.overlay_frame_container_view);
                    ((ViewGroup) fragment_container.getParent()).removeView(fragment_container);
                }
            }, 200);
        }

    }

    private void loginClicked()
    {
        Intent login_intent = new Intent(this, LoginActivity.class);

        startActivity(login_intent);
    }

    private void signupClicked()
    {
        Intent signup_intent = new Intent(this, SignupActivity.class);

        startActivity(signup_intent);
    }
}