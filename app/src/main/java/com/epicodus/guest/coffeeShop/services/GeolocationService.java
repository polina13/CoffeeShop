package com.epicodus.guest.coffeeShop.services;

import android.content.Context;

import com.epicodus.guest.coffeeShop.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by alexnenchev on 5/2/16.
 */
public class GeolocationService {
    private static final String TAG = GeolocationService.class.getSimpleName();
    private Context mContext;
    private String currentCity;

    public GeolocationService(Context context) {
        this.mContext = context;
    }

    public void getCurrentAddress(String latLng, Callback callback) {
        final String API_KEY = Constants.GOOGLE_MAPS_KEY;
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latLng).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void processResults(Response response) {
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject geolocationJSON = new JSONObject(jsonData);
                JSONArray results = geolocationJSON.getJSONArray("results");
                JSONObject resultsObject = results.getJSONObject(0);
                JSONObject components = results.getJSONObject(1);
                JSONArray addressComponents = components.getJSONArray("address_components");
                for (int i=0; i<addressComponents.length(); i++) {
                    JSONObject addressComponent = addressComponents.getJSONObject(i);
                    JSONArray types = addressComponent.getJSONArray("types");
                    for (int j=0; j<types.length(); j++) {
                        if (types.getString(j).equals("locality")) {
                            currentCity = addressComponent.getString("short_name");
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
    }

    public String getCurrentCity() {
        return currentCity;
    }

}