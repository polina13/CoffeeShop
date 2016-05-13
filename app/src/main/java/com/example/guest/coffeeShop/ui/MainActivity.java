package com.example.guest.coffeeShop.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.guest.coffeeShop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    private Firebase mFirebaseRef;
    public static final String TAG = MainActivity.class.getSimpleName();
   @Bind(R.id.findShopsButton) Button mFindShopsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
        ButterKnife.bind(this);


        mFindShopsButton.setOnClickListener(this);

   }
    @Override
    public void onClick(View view) {
       Intent intent = new Intent(MainActivity.this, CoffeeShopsActivity.class);
      startActivity(intent);
   }
}



//import android.widget.Toast;
//
//import GeolocationService;
//
//import java.io.IOException;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.Response;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
//    private static final String TAG = MainActivity.class.getSimpleName();
//    @Bind(R.id.shakeButton) Button shakeButton;
//    @Bind(R.id.locationTextView) TextView locationLabel;
//    @Bind(R.id.backgroundImageView) ImageView backgroundImageView;
//    @Bind(R.id.jumbotron) RelativeLayout jumbotron;
//    @Bind(R.id.titleTextView) TextView mTitleTextView;
//    @Bind(R.id.poweredByYelpButton) ImageView mPoweredByYelpButton;
//    public static ProgressDialog loadingDialog;
//    public static GoogleApiClient mGoogleApiClient;
//    public static Location mLastLocation;
//    public static String mCurrentLocation;
//    private static final int ACCESS_FINE_LOCATION_PERMISSION_REQUEST = 411;
//    private SharedPreferences mSharedPreferences;
//    private String mFormattedAddress;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        initializeProgressDialog();
//        backgroundImageView.setAlpha(1.0f);
//        initializeUnsplashBackground();
//
//
//        if (mGoogleApiClient == null) {
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this)
//                    .addApi(LocationServices.API)
//                    .build();
//        }
//
//        Typeface journal = Typeface.createFromAsset(getAssets(), "fonts/journal.ttf");
//        mTitleTextView.setTypeface(journal);
//
//        shakeButton.setOnClickListener(this);
//        mPoweredByYelpButton.setOnClickListener(this);
//
//        locationLabel.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (s.length() == 0) {
//                    shakeButton.setText(R.string.search_button_blank);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (s.length() != 0) {
//                    shakeButton.setText(R.string.search_button_input);
//                }
//            }
//        });
//
//
//    }
//
//    private void getDrinkPlaces(final String location) {
//        getData(location);
//    }
//
//    public void getData (final String location) {
//        final YelpService yelpService = new YelpService(this);
//
//        yelpService.getYelpData(location, YelpService.DRINK, YelpService.NORMAL_MODE, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (yelpService.processResults(response, YelpService.DRINK)) {
//                    if (Business.getDrinkList().size() < 3) {
//                        getDataExpanded(location);
//                    } else {
//                        MainActivity.this.runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent intent = new Intent(MainActivity.this, ChooserActivity.class);
//                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                    ActivityOptionsCompat options = ActivityOptionsCompat
//                                            .makeSceneTransitionAnimation(MainActivity.this, mTitleTextView, "shakeText");
//                                    startActivity(intent, options.toBundle());
//                                } else {
//                                    startActivity(intent);
//                                }
//                            }
//                        });
//                    }
//                } else {
//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(MainActivity.this, "Oops, that address doesn't work!", Toast.LENGTH_LONG).show();
//                            locationLabel.setText("");
//                            locationLabel.setHint("Please try again!");
//                        }
//                    });
//                }
//            }
//        });
//    }
//
//    public void getDataExpanded (final String location) {
//        final YelpService yelpService = new YelpService(this);
//
//        yelpService.getYelpData(location, YelpService.DRINK, YelpService.EXPANDED_MODE, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (yelpService.processResults(response, YelpService.DRINK)) {
//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            Intent intent = new Intent(MainActivity.this, ChooserActivity.class);
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                ActivityOptionsCompat options = ActivityOptionsCompat
//                                        .makeSceneTransitionAnimation(MainActivity.this, mTitleTextView, "shakeText");
//                                startActivity(intent, options.toBundle());
//                            } else {
//                                startActivity(intent);
//                            }
//                        }
//                    });
//                } else {
//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(MainActivity.this, "Oops, that address doesn't work!", Toast.LENGTH_LONG).show();
//                            locationLabel.setText("");
//                            locationLabel.setHint("Please try again!");
//                        }
//                    });
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mGoogleApiClient.disconnect();
//    }
//
//
//    private void getCoffeeForCurrentLocation() {
//        final GeolocationService geolocationService = new GeolocationService(this);
//
//        geolocationService.getCurrentAddress(mCurrentLocation, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                geolocationService.processResults(response);
//
////                mFormattedAddress = mSharedPreferences.getString("location", null);
//                getDrinkPlaces(mFormattedAddress);
//            }
//        });
//    }
//
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
//        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//            if (mLastLocation != null) {
//                mCurrentLocation = (mLastLocation.getLatitude() + "," + mLastLocation.getLongitude());
//            }
//        } else {
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                    ACCESS_FINE_LOCATION_PERMISSION_REQUEST);
//        }
//    }
//
//
//        }
//
//
//
//
//
//
//
//
//
//
