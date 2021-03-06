package com.epicodus.guest.coffeeShop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epicodus.guest.coffeeShop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoffeeShopsActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.searchCoffeeButton) Button mSearchButton;
    @Bind(R.id.savedCoffeeButton) Button mSavedCoffeeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shops);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(this);
        mSavedCoffeeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mSearchButton) {
            Intent intent = new Intent(CoffeeShopsActivity.this, DisplayListActivity.class);
            startActivity(intent);
        }
        if (view == mSavedCoffeeButton) {
            Intent intent = new Intent(CoffeeShopsActivity.this, SavedCoffeeShopsListActivity.class);
            startActivity(intent);
        }
    }
}







