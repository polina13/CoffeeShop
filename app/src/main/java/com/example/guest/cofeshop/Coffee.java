package com.example.guest.cofeshop;
import org.parceler.Parcel;
import java.util.ArrayList;


@Parcel
public class Coffee {
    private String mName;
    private String mPhone;
    private String mWebsite;
    private String mImage;
    private double mRating;
    private ArrayList<String> mAddress = new ArrayList<>();
    private double mLatitude;
    private double mLongitude;
    private ArrayList<String> mCategories = new ArrayList<>();
    private String mMenu;
//    private String mBrand; //check JSON FILE as well
    private int mReviewCount;
    private String snippetText;

    public Coffee() {}

    public Coffee(String name, String phone, String website, String image, double rating, ArrayList<String> address, double latitude, double longitude, ArrayList<String> categories, String menu, int reviewCount, String snippetText ) {

        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        mImage = getLargeImage(image);
        this.mRating = rating;
        this.mAddress = address;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mCategories = categories;
        this.snippetText = snippetText;
        this.mMenu = menu;
        this.mReviewCount = reviewCount;

    }

    private String getLargeImage(String image) {
        String largeImage = image.substring(0, image.length() - 6).concat("o.jpg");
        return largeImage;
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

    public double getLatitude() { return  mLatitude; }

    public double getLongitude() { return  mLongitude; }

    public ArrayList<String> getCategories(String categories) {
        return mCategories;
    }

    public String getSnippetText() {
        return snippetText;
    }

    public String getMenu() {
        return mMenu;
    }

    public int getReviewCount() {
        return mReviewCount;
    }

}
