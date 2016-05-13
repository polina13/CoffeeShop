//package com.example.guest.coffeeShop.ui;
//
//
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.view.MenuItemCompat;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.SearchView;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.guest.coffeeShop.Constants;
//import com.example.guest.coffeeShop.R;
//import com.example.guest.coffeeShop.adapters.CoffeeShopsListAdapter;
//import com.example.guest.coffeeShop.models.Coffee;
//import com.example.guest.coffeeShop.services.YelpService;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.Response;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class DisplayCoffeeListFragment extends Fragment {
//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
//    private CoffeeShopsListAdapter mAdapter;
//    public ArrayList<Coffee> mCoffeeShops = new ArrayList<>();
//    private SharedPreferences mSharedPreferences;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_display_coffee_list, container, false);
//        ButterKnife.bind(this, view);
//
//        String location = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
//        if (location != null) {
//            getCoffeeShops(location);
//        }
//        return view;
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.menu_search, menu);
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                addToSharedPreferences(query);
//               getCoffeeShops(query);
//               return false;
//          }
//
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_logout:
//                logout();
//                return true;
//            case R.id.action_search:
//                return true;
//            default:
//                break;
//        }
//
//        return false;
//    }
//
//    private void getCoffeeShops(String location) {
//        final YelpService yelpService = new YelpService();
//
//        yelpService.findCoffeeShops(location, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                mCoffeeShops = yelpService.processResults(response);
//
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mAdapter = new CoffeeShopsListAdapter(getActivity(), mCoffeeShops);
//                        mRecyclerView.setAdapter(mAdapter);
//                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                        mRecyclerView.setLayoutManager(layoutManager);
//                        mRecyclerView.setHasFixedSize(true);
//                    }
//                });
//            }
//        });
//    }
//}
//
//
