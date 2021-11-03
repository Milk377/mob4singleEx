package com.cookandroid.relativerayoutex;

public class RecycleItem {
    private int imageResId;
    private String strName;

    public RecycleItem(int a_resId , String a_strName)
    {
        imageResId = a_resId;
        strName = a_strName;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return strName;
    }


}
