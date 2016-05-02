package com.example.guest.cofeshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.findShopsButton) Button mFindShopsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindShopsButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, CoffeeShopsActivity.class);
        startActivity(intent);
    }
}


