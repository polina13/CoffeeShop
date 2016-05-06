//package com.example.guest.cofeshop.ui;
//
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.guest.cofeshop.Coffee;
//import com.example.guest.cofeshop.R;
//
//import org.parceler.Parcels;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class CoffeeShopsReviewFragment extends Fragment implements View.OnClickListener {
//    @Bind(R.id.coffeeTextView) TextView mNameLabel;
//    @Bind(R.id.snippetTextView) TextView mSnippetTextLabel;
//
//    private Coffee mCoffeeShop;
//
//    public static CoffeeShopsReviewFragment newInstance(Coffee coffeeShop) {
//        CoffeeShopsReviewFragment coffeeShopsReviewFragment = new CoffeeShopsReviewFragment();
//        Bundle args = new Bundle();
//        args.putParcelable("coffeeShop", Parcels.wrap(coffeeShop));
//        coffeeShopsReviewFragment.setArguments(args);
//        return coffeeShopsReviewFragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mCoffeeShop = Parcels.unwrap(getArguments().getParcelable("coffeeShop"));
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_coffee_shops_review, container, false);
//        ButterKnife.bind(this, view);
//
//        mNameLabel.setText(mCoffeeShop.getName());
//        mSnippetTextLabel.setText(mCoffeeShop.getSnippetText());
//
//        mNameLabel.setOnClickListener(this);
//        mSnippetTextLabel.setOnClickListener(this);
//        return view;
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v == mSnippetTextLabel) {
//            Intent textIntent = new Intent(Intent.ACTION_VIEW,
//                    Uri.parse(mCoffeeShop.getSnippetText()));
//            startActivity(textIntent);
//        }
//    }
//}