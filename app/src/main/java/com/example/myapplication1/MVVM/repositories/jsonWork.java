package com.example.myapplication1.MVVM.repositories;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.myapplication1.MVVM.models.Cities;
import com.example.myapplication1.MVVM.models.Resources;
import com.example.myapplication1.MVVM.mv.TransportationViewModel;

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

public class jsonWork extends ViewModel {
    //Transportation
    private MutableLiveData<String> priceForOneCityFrom = new MutableLiveData<>("");
    private MutableLiveData<String > priceForCountCityFrom = new MutableLiveData<>("");
    private MutableLiveData<String> priceForOneCityTo = new MutableLiveData<>("");
    private MutableLiveData<String> priceForCountCityTo = new MutableLiveData<>("");
    private Cities city_from;
    private Cities city_to;
    private Resources resources;
    private Integer count;
    private MutableLiveData<String> earn = new MutableLiveData<>("");
    private MutableLiveData<Boolean> flag = new MutableLiveData<>();

    //PereCraft
    private MutableLiveData<String> earn_PereCraft = new MutableLiveData<>("");
    private MutableLiveData<String> priceFirstResource = new MutableLiveData<>("");
    private MutableLiveData<String> priceSecondResource = new MutableLiveData<>("");

    public MutableLiveData<String> getEarn_PereCraft() {
        return earn_PereCraft;
    }

    public MutableLiveData<String> getPriceFirstResource() {
        return priceFirstResource;
    }

    public MutableLiveData<String> getPriceSecondResource() {
        return priceSecondResource;
    }

    public MutableLiveData<String> getEarn() {
        return earn;
    }

    public MutableLiveData<String> getPriceForOneCityFrom() {
        return priceForOneCityFrom;
    }

    public MutableLiveData<String> getPriceForCountCityFrom() {
        return priceForCountCityFrom;
    }

    public MutableLiveData<String> getPriceForOneCityTo() {
        return priceForOneCityTo;
    }

    public MutableLiveData<String> getPriceForCountCityTo() {
        return priceForCountCityTo;
    }

    public jsonWork(){ }

    public void getData(Resources resources, Cities city_from, Cities city_to, Integer count) {


        this.resources = resources;
        this.city_from = city_from;
        this.city_to = city_to;
        this.count = count;

        String url = "https://www.albion-online-data.com/api/v2/stats/prices/" + resources.getApi_name() + "?locations=" + city_from.getApi_name() + "," + city_to.getApi_name() + "&qualities=1";

        new getURLDataForTransportation().execute(url);
    }

    public void getData(Resources resources, Integer count){
        String url = "https://www.albion-online-data.com/api/v2/stats/prices/" + "resources.getApi_name() + ?locations=Caerleon,Bridgewatch,Lymhurst,Fort%20Sterling,Thetford,Martlock&qualities=1";


    }

    private class getURLDataForTransportation extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            earn.setValue("Loading...");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray object = new JSONArray(s);
                JSONObject obj = object.getJSONObject(0);
                String priceFrom, priceTo;
                if (obj.getString("city") == city_from.getApi_name()) {
                    priceFrom = obj.getString("sell_price_min");
                    priceForOneCityFrom.setValue(priceFrom);
                    Integer sum = Integer.parseInt(priceFrom) * count;
                    priceForCountCityFrom.setValue(sum.toString());


                    obj = object.getJSONObject(1);
                    priceTo = obj.getString("sell_price_min");
                    priceForOneCityTo.setValue(priceTo);
                    sum = Integer.parseInt(priceTo) * count;
                    priceForCountCityTo.setValue(sum.toString());
                } else {
                    priceTo= obj.getString("sell_price_min");
                    priceForOneCityTo.setValue(priceTo);
                    Integer sum = Integer.parseInt(priceTo) * count;
                    priceForCountCityTo.setValue(sum.toString());

                    obj = object.getJSONObject(1);
                    priceFrom = obj.getString("sell_price_min");
                    priceForOneCityFrom.setValue(priceFrom);
                    sum = Integer.parseInt(priceFrom) * count;
                    priceForCountCityFrom.setValue(sum.toString());
                }

                Integer itogSum = Integer.parseInt(priceTo)*count - Integer.parseInt(priceFrom)*count;
                earn.setValue(itogSum.toString());


            } catch (JSONException e) {
                e.printStackTrace();

            }
        }
    }

    private class getURLDataForPereCraft extends Thread {
        public
    }


}
