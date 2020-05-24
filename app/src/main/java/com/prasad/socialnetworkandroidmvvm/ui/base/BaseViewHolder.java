package com.prasad.socialnetworkandroidmvvm.ui.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created By Prasad on 2020-05-23.
 */


public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
