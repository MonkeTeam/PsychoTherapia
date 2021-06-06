package com.MonkeTeam.psychotherapia.auth.signup_steps;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import com.MonkeTeam.psychotherapia.R;

import java.util.ArrayList;

public class SignupStepsManager
{
    private ArrayList<SignupStep> signup_steps;
    private AppCompatActivity context;
    private int container_ref;

    public static final int SIGNUP_STEP1 = 0;
    
    public SignupStepsManager(AppCompatActivity c, int container)
    {
        context = c;
        container_ref = container;
    }
    
    public void render(int step)
    {
        if(SIGNUP_STEP1 == step)
        {
            renderStep1();
        }
    }
    
    private void renderStep1()
    {
        context.getSupportFragmentManager().beginTransaction()
                .add(container_ref, SignupStep1.class, null)
                .commit();
    }
}
