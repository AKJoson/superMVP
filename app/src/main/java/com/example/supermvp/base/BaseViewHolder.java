package com.example.supermvp.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private View itemView;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public View getItemView() {
        if (itemView == null)
            throw new RuntimeException("itemView is null, wa~~~~bad process");
        return itemView;
    }
}
