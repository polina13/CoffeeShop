package com.example.guest.cofeshop;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;


public class YelpService {
    public static void findCoffeeShops(String location, Callback callback) {
        String CONSUMER_KEY = Constants.YELP_CONSUMER_KEY;
        String CONSUMER_SECRET = Constants.YELP_CONSUMER_SECRET;
        String TOKEN = Constants.YELP_TOKEN;
        String TOKEN_SECRET = Constants.YELP_TOKEN_SECRET;
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(TOKEN, TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Coffee> processResults(Response response){
        ArrayList<Coffee> coffeesShops = new ArrayList<>();

        try {
            String jsonYelpData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject yelpSearchJSON = new JSONObject(jsonYelpData);
                JSONArray businessesJSON = yelpSearchJSON.getJSONArray("businesses");
                for (int i = 0; i < businessesJSON.length(); i++) {
                    JSONObject coffeeShopJSON = businessesJSON.getJSONObject(i);
                    String name = coffeeShopJSON.getString("name");
                    String phone = coffeeShopJSON.optString("display_phone", "Sorry, phone not available");
                    String website = coffeeShopJSON.getString("url");
                    String image = coffeeShopJSON.getString("image_url");
                    double rating = coffeeShopJSON.getDouble("rating");
                    ArrayList<String> address = new ArrayList<>();
                    JSONArray addressJSON = coffeeShopJSON.getJSONObject("location").getJSONArray("display_address");
                    for (int y = 0; y < addressJSON.length(); y++) {
                        address.add(addressJSON.get(y).toString());
                    }
                    double latitude = coffeeShopJSON.getJSONObject("location")
                            .getJSONObject("coordinate").getDouble("latitude");
                    double longitude = coffeeShopJSON.getJSONObject("location")
                            .getJSONObject("coordinate").getDouble("longitude");
                    ArrayList<String> categories = new ArrayList<>();
                    JSONArray categoriesJSON = coffeeShopJSON.getJSONArray("categories");

                    for (int y = 0; y < categoriesJSON.length(); y++) {
                        categories.add(categoriesJSON.getJSONArray(y).get(0).toString());
                    }


                    String snippetText = coffeeShopJSON.getString("snippet_text");
                    String menu = coffeeShopJSON.optString("menu_provider", "Menu provider not included");
                    int reviewCount = coffeeShopJSON.getInt("review_count");
                    Log.d("json", yelpSearchJSON.toString());
                    Coffee coffee = new Coffee(name, phone, website, image, rating, address, latitude, longitude, categories, menu, reviewCount, snippetText);
                    coffeesShops.add(coffee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return coffeesShops;
    }
}


