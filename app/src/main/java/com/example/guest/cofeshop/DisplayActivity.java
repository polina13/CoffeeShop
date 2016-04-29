package com.example.guest.cofeshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DisplayActivity extends AppCompatActivity {
    private TextView mCoffeeNamesTextView;
    public static final String TAG = CoffeeShopsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shops);

        mCoffeeNamesTextView = (TextView) findViewById(R.id.coffeeNamesTextView);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getCoffeeShops(location);
    }

    private void getCoffeeShops(String location) {
        YelpService.findCoffeeShops(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonYelpData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v("JSON DATA", jsonYelpData);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

 }
//    private ListView mListView;
//    private String[] shops = new String[] {"Ava Roasteria", "Peet's Coffee",
//            "Coffeehouse Northwest", "Umbria Caffe", "Spella Caffe", "Stump Town",
//            "Barista", "The Dragonfly Coffee House", "Public Domain", "World Cup Coffee",
//            "Portland City Caffe", "Seattle's Best", "Starbucks"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display);
//
//        mListView = (ListView) findViewById(R.id.listView);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shops);
//        mListView.setAdapter(adapter);
//
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            String coffeeShop = ((TextView)view).getText().toString();
//            Toast.makeText(DisplayActivity.this, coffeeShop, Toast.LENGTH_LONG).show();
//            }
//        });
//
//        mCoffeeNamesTextView = (TextView) findViewById(R.id.coffeeNamesTextView);
//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");
//        mCoffeeNamesTextView.setText("Popular Coffee Places: " + location);
//    }
