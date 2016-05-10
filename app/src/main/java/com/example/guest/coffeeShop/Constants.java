package com.example.guest.coffeeShop;


public class Constants {
    public static final String GOOGLE_MAPS_KEY = BuildConfig.GOOGLE_MAPS_KEY;
    public static final String YELP_CONSUMER_KEY = BuildConfig.YELP_CONSUMER_KEY;
    public static final String YELP_CONSUMER_SECRET = BuildConfig.YELP_CONSUMER_SECRET;
    public static final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
    public static final String YELP_TOKEN_SECRET = BuildConfig.YELP_TOKEN_SECRET;

    public static final String YELP_BASE_URL = "https://api.yelp.com/v2/search?term=coffee";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";
    public static final String PREFERENCES_LOCATION_KEY = "location";

    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;

    public static final String FIREBASE_LOCATION_SEARCHED_LOCATION = "searchedLocation";
    public static final String FIREBASE_URL_SEARCHED_LOCATION = FIREBASE_URL + "/" + FIREBASE_LOCATION_SEARCHED_LOCATION;

    public static final String FIREBASE_LOCATION_COFFEESHOPS = "coffeeShops";
    public static final String FIREBASE_URL_COFFEESHOPS = FIREBASE_URL + "/" + FIREBASE_LOCATION_COFFEESHOPS;

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;

    public static final String KEY_UID = "UID";
    public static final String KEY_USER_EMAIL = "email";

}