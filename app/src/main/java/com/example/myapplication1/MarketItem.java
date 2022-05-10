package com.example.myapplication1;

import android.graphics.Bitmap;
import android.net.Uri;

import androidx.recyclerview.widget.RecyclerView;

public class MarketItem  {

    private int img;
    private String name;
    private String tier;
    private String chars;
    private Uri image;
    private Bitmap bitmap;

    public Uri getImage() {
        return image;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public MarketItem(int id, String name, String tier, String chars) {
        this.img = id;
        this.name = name;
        this.tier = tier;
        this.chars = chars;
        //this.image = image;
        this.bitmap = bitmap;
    }

    public int getImg() {
        return img;
    }



    public String getName() {
        return name;
    }

    public String getTier() {
        return tier;
    }

    public String getChars() {
        return chars;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }
}
