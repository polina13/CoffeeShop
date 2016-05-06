package com.example.guest.cofeshop.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.cofeshop.Coffee;
import com.example.guest.cofeshop.Constants;
import com.example.guest.cofeshop.R;
import com.example.guest.cofeshop.adapters.FirebaseCoffeeShopListAdapter;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedCoffeeShopsListActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseCoffeeShopsRef;
    private FirebaseCoffeeShopListAdapter mAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ButterKnife.bind(this);

        mFirebaseCoffeeShopsRef = new Firebase(Constants.FIREBASE_URL_COFFEESHOPS);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String location = mFirebaseCoffeeShopsRef.toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseCoffeeShopListAdapter(mQuery, Coffee.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
