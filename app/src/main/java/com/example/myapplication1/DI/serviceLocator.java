package com.example.myapplication1.DI;

import android.content.Context;

import com.example.myapplication1.MVVM.repositories.jsonWork;
import com.example.myapplication1.second_market;

public class serviceLocator {
    public static serviceLocator serviceLocator = new serviceLocator();

    private jsonWork Repository;

    private Context context;

    private second_market second_marketFragment = new second_market();

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

    public second_market getSecondMarket(){
        return second_marketFragment;
    }
}
