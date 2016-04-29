package com.example.guest.cofeshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DisplayActivity extends AppCompatActivity {
//    private TextView mCoffeeNamesTextView;
    public static final String TAG = CoffeeShopsActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private CoffeeShopsListAdapter mAdapter;
    public ArrayList<Coffee> mCoffeeShops = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shops);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getCoffeeShops(location);
    }

    private void getCoffeeShops(String location) {
        final YelpService service = new YelpService();
        service.findCoffeeShops(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mCoffeeShops = service.processResults(response);

                DisplayActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new CoffeeShopsListAdapter(getApplicationContext(), mCoffeeShops);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(DisplayActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}

//            @Override
//            public void onResponse(Call call, Response response) {
//                try {
//                    String jsonYelpData = response.body().string();
//                    if (response.isSuccessful()) {
//                        Log.v("JSON DATA", jsonYelpData);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
// }
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
