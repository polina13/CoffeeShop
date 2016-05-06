package com.example.guest.cofeshop;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeShopDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.coffeeShopsImageView) ImageView mImageLabel;
    @Bind(R.id.coffeeTextView) TextView mNameLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.menuTextView) TextView mMenuLabel;
    @Bind(R.id.saveCoffeeShopButton) TextView mSaveCoffeeShopButton;
    @Bind(R.id.snippetTextView) TextView mSnippetTextView;

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
        mSaveCoffeeShopButton.setOnClickListener(this);

        Picasso.with(view.getContext()).load(mCoffeeShop.getImage()).into(mImageLabel);
        mNameLabel.setText(mCoffeeShop.getName());
        mRatingLabel.setText("Rating: " + Double.toString(mCoffeeShop.getRating()) + "/5");
        mPhoneLabel.setText(mCoffeeShop.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mCoffeeShop.getAddress()));
        mMenuLabel.setText("Menu Provider: " + mCoffeeShop.getMenu());
//        mSnippetTextView.setText(mCoffeeShop.getSnippetText());

        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);
//        mSnippetTextView.setOnClickListener(this);
        mWebsiteLabel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mCoffeeShop.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent addressIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mCoffeeShop.getLatitude()
                            + "," + mCoffeeShop.getLongitude()
                            + "?q=(" + mCoffeeShop.getName() + ")"));
            startActivity(addressIntent);
        }
//        if (v == mSnippetTextView) {
//            Intent snippetTextIntent = new Intent(Intent.ACTION_VIEW,
//                    Uri.parse(mCoffeeShop.getSnippetText()));
//            startActivity(snippetTextIntent);
//        }
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mCoffeeShop.getWebsite()));
            startActivity(webIntent);
        }

        if (v == mSaveCoffeeShopButton) {
            Firebase ref = new Firebase(Constants.FIREBASE_URL_COFFEESHOPS);
            ref.push().setValue(mCoffeeShop);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}

