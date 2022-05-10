package com.example.myapplication1.RecycleViewButtons;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.example.myapplication1.DI.serviceLocator;


public class ButtonItem {
    private String[] popUpMenuCatalog;
    private String name;
    private Context context;

    public ButtonItem(String name, Context context){
        this.name=name;
        this.context = context;
        setPopUpMenuCatalog();
    }

    private void setPopUpMenuCatalog(){
        popUpMenuCatalog = serviceLocator.getServiceLocator().getRepository().getMenu(name);
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

    public String[] getPopUpMenuCatalog() {
        return popUpMenuCatalog;
    }
}
