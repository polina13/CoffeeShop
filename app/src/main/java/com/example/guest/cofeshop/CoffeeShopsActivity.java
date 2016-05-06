package com.example.guest.cofeshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.guest.cofeshop.ui.SavedCoffeeShopsListActivity;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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







