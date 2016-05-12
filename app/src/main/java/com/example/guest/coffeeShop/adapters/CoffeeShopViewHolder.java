package com.example.guest.coffeeShop.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.coffeeShop.Coffee;
import com.example.guest.coffeeShop.R;
import com.example.guest.coffeeShop.ui.CoffeeShopsDetailActivity;
import com.example.guest.coffeeShop.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoffeeShopViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    private static final int MAX_WIDTH = 100;
    private static final int MAX_HEIGHT = 100;

    @Bind(R.id.coffeeShopsImageView) ImageView mCoffeShopsImageView;
    @Bind(R.id.coffeeTextView) TextView mCoffeeTextView;
    @Bind(R.id.ratingTextView) TextView mRatingTextView;
    @Bind(R.id.reviewCountTextView) TextView mReviewCountTextView;

    private Context mContext;
    private ArrayList<Coffee> mCoffeeShops = new ArrayList<>();

    public CoffeeShopViewHolder(View itemView, ArrayList<Coffee> coffeeShops) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mCoffeeShops = coffeeShops;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, CoffeeShopsDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("coffeeShops", Parcels.wrap(mCoffeeShops));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindCoffeeShop(Coffee coffee) {

        Picasso.with(mContext).load(coffee.getImage()).resize(MAX_WIDTH, MAX_HEIGHT).centerCrop().into(mCoffeShopsImageView);
        mCoffeeTextView.setText(coffee.getName());
        mRatingTextView.setText("Rating: " + coffee.getRating() + "/5");
        mReviewCountTextView.setText("Review Count: " + coffee.getReviewCount());
    }

    @Override
    public void onItemSelected() {

    }

    @Override
    public void onItemClear() {

    }
}
