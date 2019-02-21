package com.example.supermvp.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<T> datas;
    private int layoutId;

    public BaseAdapter(List<T> datas, int layoutId) {
        this.layoutId = layoutId;
        this.datas = datas;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BaseViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        bindHolder(baseViewHolder, datas.get(i), i);
    }

    protected abstract void bindHolder(BaseViewHolder baseViewHolder, T t, int i);

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void updateData(List<T> data) {
        if (data != null) {
            datas.addAll(data);
            notifyDataSetChanged();
        }
    }
}
