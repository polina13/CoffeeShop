package com.epicodus.guest.coffeeShop.models;

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
