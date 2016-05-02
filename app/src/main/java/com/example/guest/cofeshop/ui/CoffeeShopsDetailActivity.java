package com.example.guest.cofeshop.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.guest.cofeshop.Coffee;
import com.example.guest.cofeshop.R;
import com.example.guest.cofeshop.adapters.CoffeeShopsPagerAdapter;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoffeeShopsDetailActivity extends AppCompatActivity {
    @Bind(R.id.coffeeViewPager) ViewPager mCoffeeViewPager;
    private CoffeeShopsPagerAdapter adapterViewPager;
    ArrayList<Coffee> mCoffeeShops = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shops_detail);
        ButterKnife.bind(this);
        mCoffeeShops = Parcels.unwrap(getIntent().getParcelableExtra("coffeeShops"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new CoffeeShopsPagerAdapter(getSupportFragmentManager(), mCoffeeShops);
        mCoffeeViewPager.setAdapter(adapterViewPager);
        mCoffeeViewPager.setCurrentItem(startingPosition);

    }
}



