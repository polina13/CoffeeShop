package com.example.guest.cofeshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.cofeshop.ui.SavedCoffeeShopsListActivity;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoffeeShopsActivity extends AppCompatActivity implements View.OnClickListener{
    private Firebase mSearchedLocationRef;
    private ValueEventListener mSearchedLocationRefListener;
    
    @Bind(R.id.searchCoffeeButton) Button mSearchButton;
    @Bind(R.id.coffeePlacesEditText) EditText mCoffeePlacesEditText;
    @Bind(R.id.savedCoffeeButton) Button mSavedCoffeeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shops);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(this);
        mSavedCoffeeButton.setOnClickListener(this);

        mSearchedLocationRef = new Firebase(Constants.FIREBASE_URL_SEARCHED_LOCATION);

        mSearchedLocationRefListener = mSearchedLocationRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String locations = dataSnapshot.getValue().toString();
//                Log.d("Location updated", locations);
//            }

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mSearchedLocationRef.removeEventListener(mSearchedLocationRefListener);
    }


    @Override
    public void onClick(View view) {
        if (view == mSearchButton) {
            String location = mCoffeePlacesEditText.getText().toString();
            saveLocationToFirebase(location);
            Intent intent = new Intent(CoffeeShopsActivity.this, DisplayListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
        if (view == mSavedCoffeeButton) {
            Intent intent = new Intent(CoffeeShopsActivity.this, SavedCoffeeShopsListActivity.class);
            startActivity(intent);
        }
    }


    public void saveLocationToFirebase(String location) {
        Firebase searchedLocationRef = new Firebase(Constants.FIREBASE_URL_SEARCHED_LOCATION);
        searchedLocationRef.push().setValue(location);
    }
}







