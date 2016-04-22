//package com.example.guest.cofeshop;
//
//import android.content.Intent;
//import android.os.Build;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.robolectric.RobolectricGradleTestRunner;
//import org.robolectric.annotation.Config;
//import org.robolectric.shadows.ShadowActivity;
//
//import static junit.framework.Assert.assertTrue;
//
///**
// * Created by polinanenchev on 4/22/16.
// */
//
//@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
//@RunWith(RobolectricGradleTestRunner.class)
//
//public class CoffeeShopsTest {
//    private CoffeeShopsActivity searchShops;
//
//    @Test
//    public void secondActivityStarted() {
//        searchShops.findViewById(R.id.findShopsButton).performClick();
//        Intent expectedIntent = new Intent(searchShops,CoffeeShopsActivity.class);
//        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(searchShops);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        assertTrue(actualIntent.filterEquals(expectedIntent));
//    }
//}

