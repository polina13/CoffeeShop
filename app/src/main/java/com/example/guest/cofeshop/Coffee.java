package com.example.guest.cofeshop;

import java.util.ArrayList;

public class Coffee {
    private String mName;
    private String mPhone;
    private String mWebsite;
    private String mImage;
    private double mRating;
//    private String mComments;
    private ArrayList<String> mAddress = new ArrayList<>();
    private ArrayList<String> mCategories = new ArrayList<>();
    private String mMenu;
//    private String mBrand; //check JSON FILE as well
    private int mReviewCount;

    public Coffee() {}

    public Coffee(String name, String phone, String website, String image, double rating, ArrayList<String> address, ArrayList<String> categories, String menu, int reviewCount ) {

        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        mImage = getLargeImage(image);
        this.mRating = rating;
        this.mAddress = address;
        this.mCategories = categories;
        this.mMenu = menu;
        this.mReviewCount = reviewCount;
    }

    private String getLargeImage(String image) {
        return mImage;
    }

    public String getName () {
            return mName;
    }

    public String getPhone() {
        return mPhone;
    }


    public String getWebsite() {
        return mWebsite;
    }

    public String getImage() {
        return mImage;
    }

    public double getRating() {
        return mRating;
    }


    public ArrayList<String> getAddress() {
        return mAddress;
    }

    public ArrayList<String> getCategories(String categories) {
        if (categories == "coffeeroasteries") {
        }
        return mCategories;
    }

    public String getMenu() {
        return mMenu;
    }

    public int getReviewCount() {
        return mReviewCount;
    }
}


//NOTES TO DO
//LOOK UP FOR REVIEWS/COMMENTS AND PRICES
