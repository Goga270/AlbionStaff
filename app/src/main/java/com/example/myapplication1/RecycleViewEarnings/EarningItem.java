package com.example.myapplication1.RecycleViewEarnings;

import androidx.fragment.app.Fragment;

public class EarningItem {
    private int img;
    private String text_earn;
    private String text_Vlojenia;
    private String text_button;
    private Fragment fragment;

    public Fragment getFragment() {
        return fragment;
    }

    public EarningItem(int img, String text_name, String text_Vlojenia, String tex_button, Fragment fragment) {
        this.img = img;
        this.text_earn = text_name;
        this.text_Vlojenia = text_Vlojenia;
        this.text_button = tex_button;
        this.fragment = fragment;
    }

    public int getImg() {
        return img;
    }

    public String getText_earn() {
        return text_earn;
    }

    public String getText_Vlojenia() {
        return text_Vlojenia;
    }

    public String getText_button() {
        return text_button;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setText_earn(String text_name) {
        this.text_earn = text_name;
    }

    public void setText_Vlojenia(String text_Vlojenia) {
        this.text_Vlojenia = text_Vlojenia;
    }

    public void setText_button(String tex_button) {
        this.text_button = tex_button;
    }
}
