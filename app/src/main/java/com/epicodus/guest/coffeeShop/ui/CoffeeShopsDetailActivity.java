package com.epicodus.guest.coffeeShop.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.epicodus.guest.coffeeShop.models.Coffee;
import com.epicodus.guest.coffeeShop.R;
import com.epicodus.guest.coffeeShop.adapters.CoffeeShopsPagerAdapter;
import com.epicodus.guest.coffeeShop.util.ScaleAndFadePageTransformer;

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
        mCoffeeViewPager.setAdapter(adapterViewPager);
        mCoffeeViewPager.setCurrentItem(startingPosition);
        mCoffeeViewPager.setPageTransformer(true, new ScaleAndFadePageTransformer());
    }
}



