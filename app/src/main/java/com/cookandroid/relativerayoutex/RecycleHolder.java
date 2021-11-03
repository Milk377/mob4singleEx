package com.cookandroid.relativerayoutex;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecycleHolder extends RecyclerView.ViewHolder {
    TextView tv_text;
    ImageView ivIcon;

    public RecycleHolder (View itemView){
        super(itemView);

        tv_text = itemView.findViewById(R.id.text1);
        ivIcon = itemView.findViewById(R.id.iv_icon);
    }
}
