package com.example.myapplication1;

import androidx.recyclerview.widget.RecyclerView;

public class MarketItem  {

    private int img;
    private String name;
    private String tier;
    private String chars;

    public MarketItem(int img, String name, String tier, String chars) {
        this.img = img;
        this.name = name;
        this.tier = tier;
        this.chars = chars;
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
