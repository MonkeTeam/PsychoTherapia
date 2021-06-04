package com.MonkeTeam.psychotherapia.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.MonkeTeam.psychotherapia.R;
import com.MonkeTeam.psychotherapia.utils.ui.ButtonUI;
import com.MonkeTeam.psychotherapia.utils.ui.FontUI;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prepareStyles();
        prepareActions();
    }

    private void prepareStyles()
    {
        TextView login_title = findViewById(R.id.login_title);
        EditText login_et = findViewById(R.id.login_username_et);
        EditText password_et = findViewById(R.id.login_password_et);
        Button login_btn = findViewById(R.id.login_login_btn);
        TextView go_back_tv = findViewById(R.id.login_go_back);

        FontUI.makePacifio(this, login_title);
        FontUI.makePacifio(this, go_back_tv);
        ButtonUI.makePrimary(this, login_btn, ButtonUI.PACIFICO, false);
    }

    private void prepareActions()
    {
        TextView go_back_tv = findViewById(R.id.login_go_back);

        go_back_tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}