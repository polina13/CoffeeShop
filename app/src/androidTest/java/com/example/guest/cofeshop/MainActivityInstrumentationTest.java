package com.example.guest.cofeshop;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by polinanenchev on 4/25/16.
 */

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<CoffeeShopsActivity> activityTestRule = new ActivityTestRule<>(CoffeeShopsActivity.class);
    @Test
    public void validateEditText() {
        onView(withId(R.id.coffeePlacesEditText)).perform(typeText("Beaverton")).check(matches(withText("Beaverton")));
    }



//    @Test
//    public void locationIsSent() {
//         String location = "Beaverton";
//         onView(withId(R.id.coffeePlacesEditText)).perform(typeText(location));
//         onView(withId(R.id.searchButton)).perform(click());
//         onView(withId(R.id.coffeeNamesTextView)).check(matches(withText("Popular Coffee Places: " + location)));
//    }

}