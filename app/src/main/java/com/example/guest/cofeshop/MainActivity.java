package com.example.guest.cofeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.guest.cofeshop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.findCoffeeShopsButton)
    Button mFindShopsButton;

//    private Button mFindShopsButton;
//    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mFindShopsButton = (Button) findViewById(R.id.findShopsButton);
        mFindShopsButton.setOnClickListener(new View.OnClickListener() {
            ;

            @Override
            public void onClick(View v) {
//                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, CoffeeShopsActivity.class);
                startActivity(intent);
            }
        });
    }
}