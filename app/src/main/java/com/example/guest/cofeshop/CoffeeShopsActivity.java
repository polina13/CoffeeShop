package com.example.guest.cofeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoffeeShopsActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    public static final String TAG = CoffeeShopsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shops);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String location = mLocationEditText.getText().toString();
        Intent intent = new Intent(CoffeeShopsActivity.this, DisplayActivity.class);
        startActivity(intent);
    }

}




