package com.example.myapplication1.MVVM.mv;

import android.icu.text.Edits;
import android.os.AsyncTask;
import android.util.MutableLong;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.myapplication1.DI.serviceLocator;
import com.example.myapplication1.MVVM.models.Cities;
import com.example.myapplication1.MVVM.models.Resources;
import com.example.myapplication1.MVVM.repositories.jsonWork;
import com.example.myapplication1.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TransportationViewModel extends ViewModel {
    private MutableLiveData<String> earn = new MutableLiveData<>();
    private MutableLiveData<String> priceForOneCityFrom = new MutableLiveData<>("");
    private MutableLiveData<String> priceForOneCityTo = new MutableLiveData<>("");
    private MutableLiveData<String> priceForCountCityFrom = new MutableLiveData<>();
    private MutableLiveData<String> priceForCountCityTo = new MutableLiveData<>();
    private jsonWork repository;


    public MutableLiveData<String> getPriceForCountCityFrom() {
        return priceForCountCityFrom;
    }

    public MutableLiveData<String> getPriceForCountCityTo() {
        return priceForCountCityTo;
    }

    public MutableLiveData<String> getPriceForOneCityFrom() {
        return priceForOneCityFrom;
    }

    public MutableLiveData<String> getPriceForOneCityTo() {
        return priceForOneCityTo;
    }

    public MutableLiveData<String> getEarn() {
        return earn;
    }

    public TransportationViewModel(){
        this.repository = serviceLocator.getServiceLocator().getRepository();
        earn = repository.getEarn();
        priceForOneCityFrom = repository.getPriceForOneCityFrom();
        priceForOneCityTo = repository.getPriceForOneCityTo();
        priceForCountCityFrom = repository.getPriceForCountCityFrom();
        priceForCountCityTo = repository.getPriceForCountCityTo();
    }

    public void CalculateEarn(String resource_name, String tier, String count, String City_from, String City_to) {
        Resources res = new Resources(resource_name, tier);
        Cities city_fr = new Cities(City_from);
        Cities city_t = new Cities(City_to);

        repository.getData(res,city_fr,city_t,Integer.parseInt(count));

    }

}
