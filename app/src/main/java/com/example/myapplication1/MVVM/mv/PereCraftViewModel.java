package com.example.myapplication1.MVVM.mv;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication1.DI.serviceLocator;
import com.example.myapplication1.MVVM.models.Resources;
import com.example.myapplication1.MVVM.repositories.jsonWork;

public class PereCraftViewModel {

    private MutableLiveData<String> earn = new MutableLiveData<>("");
    private MutableLiveData<String> priceFirstResource = new MutableLiveData<>("");
    private MutableLiveData<String> priceSecondResource = new MutableLiveData<>("");
    private jsonWork repository;

    public MutableLiveData<String> getEarn() {
        return earn;
    }

    public MutableLiveData<String> getPriceFirstResource() {
        return priceFirstResource;
    }

    public MutableLiveData<String> getPriceSecondResource() {
        return priceSecondResource;
    }

    public PereCraftViewModel(){
        this.repository = serviceLocator.getServiceLocator().getRepository();
        earn = repository.getEarn_PereCraft();
        priceFirstResource = repository.getPriceFirstResource();
        priceSecondResource = repository.getPriceSecondResource();

    }

    public void calculateEarn(String resource, String tier, String count){
        Resources res = new Resources(resource,tier);

    }
}
