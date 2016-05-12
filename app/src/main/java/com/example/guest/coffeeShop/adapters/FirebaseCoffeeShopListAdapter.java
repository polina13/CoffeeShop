package com.example.guest.coffeeShop.adapters;

/**
 * Created by alexnenchev on 5/6/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.coffeeShop.Coffee;
import com.example.guest.coffeeShop.R;
import com.example.guest.coffeeShop.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

public class FirebaseCoffeeShopListAdapter extends FirebaseRecyclerAdapter<CoffeeShopViewHolder,Coffee> {
    private Context mContext;

    public FirebaseCoffeeShopListAdapter(Query query, Class<Coffee> itemClass) {
        super(query, itemClass);
//        mDragStartListener = dragStartListener;
    }

    @Override
    public CoffeeShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.coffee_list_display, parent, false);
        return new CoffeeShopViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(CoffeeShopViewHolder holder, int position) {
        holder.bindCoffeeShop(getItem(position));
//        holder.mCoffeShopsImageView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
////                    mDragStartListener.onStartDrag(holder);
//                }
//                return false;
//            }
//        });
    }

//    @Override
//    public boolean onItemMove(int fromPosition, int toPosition) {
//        Collections.swap(getItems(), fromPosition, toPosition);
//        notifyItemMoved(fromPosition, toPosition);
//        return true;
//    }
//
//    @Override
//    public void onItemDismiss(int position) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
//        String uid = sharedPreferences.getString(Constants.KEY_UID, null);
//        Firebase ref = new Firebase(Constants.FIREBASE_URL_COFFEESHOPS).child(uid);
//        String coffeeShopKey = getItem(position).getPushId();
//        ref.child(coffeeShopKey).removeValue();
//    }
//
//    @Override
//    public int getItemCount() {
//        return getItems().size();
//    }
//


    @Override
    protected void itemAdded(Coffee item, String key, int position) {

    }

    @Override
    protected void itemChanged(Coffee oldItem, Coffee newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Coffee item, String key, int position) {

    }

    @Override
    protected void itemMoved(Coffee item, String key, int oldPosition, int newPosition) {

    }
}