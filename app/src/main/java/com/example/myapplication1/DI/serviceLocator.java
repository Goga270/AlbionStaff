package com.example.myapplication1.DI;

import android.content.Context;

import com.example.myapplication1.MVVM.repositories.jsonWork;

public class serviceLocator {
    public static serviceLocator serviceLocator = new serviceLocator();

    private jsonWork Repository;

    private Context context;

    private serviceLocator(){
        serviceLocator = this;
        Repository = new jsonWork();
    }

    public static serviceLocator getServiceLocator(){
        return serviceLocator;
    }

    public jsonWork getRepository() {
        return Repository;
    }
}
