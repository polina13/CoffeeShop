package com.example.guest.cofeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CoffeeShopsActivity extends AppCompatActivity {
    private EditText mLocationEditText;
    private Button mFindShopsButton;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shops);
        mFindShopsButton = (Button) findViewById(R.id.findShopsButton);
        mFindShopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                Log.d(TAG, location);
            }
        });
    };
}