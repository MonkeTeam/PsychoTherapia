package com.MonkeTeam.psychotherapia.auth.signup_steps;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.MonkeTeam.psychotherapia.R;
import com.MonkeTeam.psychotherapia.auth.SignupActivity;
import com.MonkeTeam.psychotherapia.utils.ui.ButtonUI;
import com.MonkeTeam.psychotherapia.utils.ui.FontUI;

public class SignupStep1 extends Fragment implements SignupStep
{

    public SignupStep1()
    {
        super(R.layout.fragment_signup_step_1);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        build(view);
    }

    @Override
    public void build(View view)
    {
        TextView title = view.findViewById(R.id.signup_step_1_title);
        Button help_seeker_btn = view.findViewById(R.id.signup_step_1_help_seeker_btn);
        Button therapist_btn = view.findViewById(R.id.signup_step_1_therapist_btn);

        FontUI.makePacifio(view.getContext(), title);

        ButtonUI.makePrimary(view.getContext(), help_seeker_btn, ButtonUI.NORMAL, false);
        ButtonUI.makeSecondary(view.getContext(), therapist_btn, ButtonUI.NORMAL, false);
        Log.e("ASD", "step 1 created");


    }
}