package com.example.guest.cofeshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeShopDetailFragment extends Fragment {
        @Bind(R.id.coffeeShopsImageView) ImageView mImageLabel;
        @Bind(R.id.coffeeTextView) TextView mNameLabel;
        @Bind(R.id.ratingTextView) TextView mRatingLabel;
        @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
        @Bind(R.id.phoneTextView) TextView mPhoneLabel;
        @Bind(R.id.addressTextView) TextView mAddressLabel;
        @Bind(R.id.saveCoffeeShopButton) TextView mSaveCoffeeShopButton;

    private Coffee mCoffeeShop;

    public static CoffeeShopDetailFragment newInstance(Coffee coffeeShop) {
        CoffeeShopDetailFragment coffeeShopDetailFragment = new CoffeeShopDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("coffeeShop", Parcels.wrap(coffeeShop));
        coffeeShopDetailFragment.setArguments(args);
        return coffeeShopDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCoffeeShop = Parcels.unwrap(getArguments().getParcelable("coffeeShop"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffee_shop_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mCoffeeShop.getImage()).into(mImageLabel);
        mNameLabel.setText(mCoffeeShop.getName());
        mRatingLabel.setText("Rating: " + Double.toString(mCoffeeShop.getRating()) + "/5");
        mPhoneLabel.setText(mCoffeeShop.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mCoffeeShop.getAddress()));
        return view;
    }
}
