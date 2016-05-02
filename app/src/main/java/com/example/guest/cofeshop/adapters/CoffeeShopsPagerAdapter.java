package com.example.guest.cofeshop.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.cofeshop.Coffee;
import com.example.guest.cofeshop.CoffeeShopDetailFragment;

import java.util.ArrayList;

public class CoffeeShopsPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Coffee> mCoffeeShops;

    public CoffeeShopsPagerAdapter(FragmentManager fm, ArrayList<Coffee> coffeeShops) {
        super(fm);
        mCoffeeShops = coffeeShops;
    }

    @Override
    public Fragment getItem(int position) {
        return CoffeeShopDetailFragment.newInstance(mCoffeeShops.get(position));
    }

    @Override
    public int getCount() {
        return mCoffeeShops.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCoffeeShops.get(position).getName();
    }
}

