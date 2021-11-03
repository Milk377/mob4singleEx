package com.cookandroid.relativerayoutex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleHolder>{
    private List<RecycleItem> mItemList;

    public RecycleAdapter(List<RecycleItem> a_list)
    {
        mItemList = a_list;
    }

    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_position) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.recycleitem, a_viewGroup, false);
        return new RecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder a_viewHolder, int a_position) {
        final RecycleItem item = mItemList.get(a_position);


        a_viewHolder.ivIcon.setImageResource(item.getImageResId());
        a_viewHolder.tv_text.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


}
