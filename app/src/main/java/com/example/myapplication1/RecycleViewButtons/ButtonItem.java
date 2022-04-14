package com.example.myapplication1.RecycleViewButtons;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;


public class ButtonItem {
    private final Map<String,String[]> popUpMenuCatalog = new HashMap<>();
    private String name;
    private Context context;

    public ButtonItem(String name, Context context){
        this.name=name;
        this.context = context;
        setPopUpMenuCatalog();
    }

    private void setPopUpMenuCatalog(){
        popUpMenuCatalog.put("Броня", new String[] {"Тканевая броня", "Тканевый шлем", "Тканевые ботинки", "Кожанная броня", "Кожанный шлем", "Кожанные ботинки", "Тяжёлая броня"});
        popUpMenuCatalog.put("Аксесуары", new String[] {"fjfkjfk", " kjgjgjgkj"});
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Map<String, String[]> getPopUpMenuCatalog() {
        return popUpMenuCatalog;
    }
}
