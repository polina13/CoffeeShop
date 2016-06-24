package com.epicodus.guest.coffeeShop.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.epicodus.guest.coffeeShop.models.Coffee;
import com.epicodus.guest.coffeeShop.Constants;
import com.epicodus.guest.coffeeShop.R;
import com.epicodus.guest.coffeeShop.adapters.FirebaseCoffeeShopListAdapter;
import com.epicodus.guest.coffeeShop.util.OnStartDragListener;
import com.epicodus.guest.coffeeShop.util.SimpleItemTouchHelperCallback;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedCoffeeShopsListActivity extends AppCompatActivity implements OnStartDragListener{
    private Query mQuery;
    private Firebase mFirebaseCoffeeShopsRef;
    private FirebaseCoffeeShopListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private ItemTouchHelper mItemTouchHelper;
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
        mQuery = new Firebase(location).orderByChild("index");
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseCoffeeShopListAdapter(mQuery,Coffee.class, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
    @Override
    protected void onPause() {
        super.onPause();
        String uid = mSharedPreferences.getString(Constants.KEY_UID, null);
        for (Coffee coffee : mAdapter.getItems()) {
            String pushID = coffee.getPushId();
            coffee.setIndex(Integer.toString(mAdapter.getItems().indexOf(coffee)));
            mFirebaseCoffeeShopsRef.child(uid).child(pushID).setValue(coffee);
        }
    }
}

