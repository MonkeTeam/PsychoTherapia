package com.MonkeTeam.psychotherapia.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;

import com.MonkeTeam.psychotherapia.R;
import com.MonkeTeam.psychotherapia.auth.signup_steps.SignupStep;
import com.MonkeTeam.psychotherapia.auth.signup_steps.SignupStep1;
import com.MonkeTeam.psychotherapia.auth.signup_steps.SignupStepsManager;

public class SignupActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setUpView();
    }

    private void setUpView()
    {
//        Fragment signup_step_1 = new SignupStep1();
//        FragmentContainerView fragment_container = findViewById();

        SignupStepsManager manager = new SignupStepsManager(this, R.id.signup_frame_container);

        manager.render(SignupStepsManager.SIGNUP_STEP1);
        
    }
}