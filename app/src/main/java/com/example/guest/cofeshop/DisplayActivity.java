package com.example.guest.cofeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;
    private String[] shops = new String[] {"Ava Roasteria", "Peet's Coffee",
            "Coffeehouse Northwest", "Umbria Caffe", "Spella Caffe", "Stump Town",
            "Barista", "The Dragonfly Coffee House", "Public Domain", "World Cup Coffee",
            "Portland City Caffe", "Seattle's Best", "Starbucks"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shops);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String coffeeShop = ((TextView)view).getText().toString();
            Toast.makeText(DisplayActivity.this, coffeeShop, Toast.LENGTH_LONG).show();
            }
        });

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Popular Coffee Places: " + location);
    }
}
