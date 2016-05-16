package com.example.guest.coffeeShop.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.coffeeShop.Constants;
import com.example.guest.coffeeShop.R;
import com.example.guest.coffeeShop.models.Coffee;
import com.example.guest.coffeeShop.ui.CoffeeShopDetailFragment;
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
    private int mOrientation;
    private Integer mPosition;

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
        mOrientation = itemView.getResources().getConfiguration().orientation;

        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE){
            createDetailFragment(0);
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPosition = getLayoutPosition();

                if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                    createDetailFragment(mPosition);
                } else {

                    Intent intent = new Intent(mContext, CoffeeShopsDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition.toString());
                    intent.putExtra(Constants.EXTRA_KEY_COFFEESHOPS, Parcels.wrap(mCoffeeShops));
                    mContext.startActivity(intent);
                }
            }
        });
    }

    private void createDetailFragment(int position) {
        CoffeeShopDetailFragment detailFragment = CoffeeShopDetailFragment.newInstance(mCoffeeShops, position);
        FragmentTransaction ft = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.coffeeDetailContainer, detailFragment);
        ft.commit();
    }


    public void bindCoffeeShop(Coffee coffee) {

        Picasso.with(mContext).load(coffee.getImage()).resize(MAX_WIDTH, MAX_HEIGHT).centerCrop().into(mCoffeShopsImageView);
        mCoffeeTextView.setText(coffee.getName());
        mRatingTextView.setText("Rating: " + coffee.getRating() + "/5");
        mReviewCountTextView.setText("Review Count: " + coffee.getReviewCount());
    }

    @Override
    public void onItemSelected() {
        itemView.animate().alpha(0.6f).scaleX(0.7f).scaleY(0.7f).setDuration(400);
    }

    @Override
    public void onItemClear() {
        itemView.animate().alpha(1f).scaleX(1f).scaleY(1f);
    }
}
