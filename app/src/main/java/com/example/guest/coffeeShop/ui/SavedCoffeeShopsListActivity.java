package com.example.guest.coffeeShop.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.coffeeShop.Coffee;
import com.example.guest.coffeeShop.Constants;
import com.example.guest.coffeeShop.R;
import com.example.guest.coffeeShop.adapters.FirebaseCoffeeShopListAdapter;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedCoffeeShopsListActivity extends AppCompatActivity{
    private Query mQuery;
    private Firebase mFirebaseCoffeeShopsRef;
    private FirebaseCoffeeShopListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mFirebaseCoffeeShopsRef = new Firebase(Constants.FIREBASE_URL_COFFEESHOPS);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
        String location = mFirebaseCoffeeShopsRef.child(userUid).toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseCoffeeShopListAdapter(mQuery,Coffee.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}

