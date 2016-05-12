package com.example.guest.coffeeShop.util;

/**
 * Created by alexnenchev on 5/12/16.
 */
public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}

