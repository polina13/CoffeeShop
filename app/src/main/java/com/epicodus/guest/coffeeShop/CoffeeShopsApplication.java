package com.epicodus.guest.coffeeShop;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by alexnenchev on 5/6/16.
 */
public class CoffeeShopsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
