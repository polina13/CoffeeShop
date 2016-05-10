package com.example.guest.coffeeShop.models;

/**
 * Created by alexnenchev on 5/6/16.
 */
public class Profile {
    private String name;
    private String email;
    private String coffeePreference;

    public Profile(String name, String email, String coffeePreference) {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCoffeePreference() {
        return coffeePreference;
    }
}
