package com.example.guest.cofeshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CoffeeShopsListAdapter extends RecyclerView.Adapter<CoffeeShopsListAdapter.CoffeeViewHolder> {
    private ArrayList<Coffee> mCoffeeShops = new ArrayList<>();
    private Context mContext;

    public CoffeeShopsListAdapter(Context context, ArrayList<Coffee> coffeeShops) {
        mContext = context;
        mCoffeeShops = coffeeShops;
    }

    @Override
    public CoffeeShopsListAdapter.CoffeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_list_display, parent, false);
        CoffeeViewHolder viewHolder = new CoffeeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CoffeeShopsListAdapter.CoffeeViewHolder holder, int position) {
        holder.bindCoffeeShop(mCoffeeShops.get(position));
    }

    @Override
    public int getItemCount() {
        return mCoffeeShops.size();
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.coffeShopsImageView) ImageView mCoffeShopsImageView;
        @Bind(R.id.coffeeTextView) TextView mCoffeeTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;
        @Bind(R.id.reviewCountTextView) TextView mReviewCountTextView;
        private Context mContext;


        public CoffeeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCoffeeShop(Coffee coffeeshops) {
            Picasso.with(mContext).load(coffeeshops.getImage()).into(mCoffeShopsImageView);
            mCoffeeTextView.setText(coffeeshops.getName());
            mRatingTextView.setText("Rating: " + coffeeshops.getRating() + "/5");
            mReviewCountTextView.setText("Review Count: " + coffeeshops.getReviewCount());
            
        }
    }
}

