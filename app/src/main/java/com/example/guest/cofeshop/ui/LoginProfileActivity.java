package com.example.guest.cofeshop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.guest.cofeshop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginProfileActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.registerTextView) TextView mRegisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_profile);
        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mRegisterTextView) {
        Intent intent = new Intent(LoginProfileActivity.this, CreateProfileActivity.class);
        startActivity(intent);
        finish();
        }
    }
}