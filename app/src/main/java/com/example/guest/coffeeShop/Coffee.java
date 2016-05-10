package com.example.guest.coffeeShop;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Coffee {
    String name;
    String phone;
    String website;
    String image;
    double rating;
    List<String> address = new ArrayList<>();
    double latitude;
    double longitude;
    List<String> categories = new ArrayList<>();
    String menu;
    int reviewCount;
    String snippetText;
    String pushID;

    public Coffee() {}

    public Coffee(String name, String phone, String website, String image, double rating, ArrayList<String> address, double latitude, double longitude, ArrayList<String> categories, String menu, int reviewCount, String snippetText) {

        this.name = name;
        this.phone = phone;
        this.website = website;
        this.image = getLargeImage(image);
        this.rating = rating;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categories = categories;
        this.snippetText = snippetText;
        this.menu = menu;
        this.reviewCount = reviewCount;

    }

    String getLargeImage(String image) {
        String largeImage = image.substring(0, image.length() - 6).concat("o.jpg");
        return largeImage;
    }

    public String getName () {
            return name;
    }

    public String getPhone() {
        return phone;
    }


    public String getWebsite() {
        return website;
    }

    public String getImage() {
        return image;
    }

    public double getRating() {
        return rating;
    }


    public List<String> getAddress() {
        return address;
    }

    public double getLatitude() { return  latitude; }

    public double getLongitude() { return  longitude; }

    public List<String> getCategories() {
        return categories;
    }

    public String getSnippetText() {
        return snippetText;
    }

    public String getMenu() {
        return menu;
    }

    public int getReviewCount() {
        return reviewCount;
    }

}
