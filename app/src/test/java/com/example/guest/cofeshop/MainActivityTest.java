package com.example.guest.cofeshop;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import com.example.guest.coffeeShop.BuildConfig;
import com.example.guest.coffeeShop.CoffeeShopsActivity;
import com.example.guest.coffeeShop.MainActivity;
import com.example.guest.coffeeShop.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

/**
 * Created by polinaNenchev on 4/22/16.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity shop;

    @Before
    public void setup() {
        shop = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateCoffeePlaceTextView() {
        TextView titleTextView = (TextView) shop.findViewById(R.id.titleTextView);
        assertTrue("Coffee Shops".equals(titleTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted() {
        shop.findViewById(R.id.findShopsButton).performClick();
        Intent expectedIntent = new Intent(shop,CoffeeShopsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(shop);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
