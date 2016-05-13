package com.example.guest.coffeeShop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.coffeeShop.R;
import com.example.guest.coffeeShop.models.Coffee;

import java.util.ArrayList;

public class CoffeeShopsListAdapter extends RecyclerView.Adapter<CoffeeShopViewHolder> {
    private ArrayList<Coffee> mCoffeeShops = new ArrayList<>();
    private Context mContext;

    public CoffeeShopsListAdapter(Context context, ArrayList<Coffee> coffeeShops) {
        mContext = context;
        mCoffeeShops = coffeeShops;
    }

    @Override
    public CoffeeShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_list_display, parent, false);
        CoffeeShopViewHolder viewHolder = new CoffeeShopViewHolder(view, mCoffeeShops);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CoffeeShopViewHolder holder, int position) {
        holder.bindCoffeeShop(mCoffeeShops.get(position));
    }

    @Override
    public int getItemCount() {
        return mCoffeeShops.size();
    }
}


