//package com.example.guest.cofeshop.ui;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//
//import DisplayListActivity;
//import com.example.guest.cofeshop.R;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
//public class CoffeeShopsReviewActivity extends AppCompatActivity implements View.OnClickListener {
//    @Bind(R.id.reviewButton) Button mReviewButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_coffee_shops_review);
//        ButterKnife.bind(this);
//        mReviewButton.setOnClickListener(this);
//    }
//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(CoffeeShopsReviewActivity.this, DisplayListActivity.class);
//        startActivity(intent);
//    }
//}