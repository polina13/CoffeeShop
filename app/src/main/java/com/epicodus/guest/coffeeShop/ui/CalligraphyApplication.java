package com.epicodus.guest.coffeeShop.ui;

import android.app.Application;

import com.epicodus.guest.coffeeShop.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by alexnenchev on 6/24/16.
 */
public class CalligraphyApplication  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // initalize Calligraphy
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lune-Bold.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}


