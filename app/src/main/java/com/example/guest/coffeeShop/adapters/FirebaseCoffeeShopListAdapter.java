package com.example.guest.coffeeShop.adapters;

/**
 * Created by alexnenchev on 5/6/16.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.coffeeShop.Coffee;
import com.example.guest.coffeeShop.R;
import com.example.guest.coffeeShop.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

public class FirebaseCoffeeShopListAdapter extends FirebaseRecyclerAdapter<CoffeeShopViewHolder,Coffee> {
    public FirebaseCoffeeShopListAdapter(Query query, Class<Coffee> itemClass) {
        super(query, itemClass);
    }

    @Override
    public CoffeeShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coffee_list_display, parent, false);
        return new CoffeeShopViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(CoffeeShopViewHolder holder, int position) {
        holder.bindCoffeeShop(getItem(position));
    }

    @Override
    protected void itemAdded(Coffee item, String key, int position) {

    }

    @Override
    protected void itemChanged(Coffee oldItem, Coffee newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Coffee item, String key, int position) {

    }

    @Override
    protected void itemMoved(Coffee item, String key, int oldPosition, int newPosition) {

    }
}