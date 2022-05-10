package com.example.myapplication1.MVVM.repositories;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.myapplication1.MVVM.models.Cities;
import com.example.myapplication1.MVVM.models.Resources;
import com.example.myapplication1.MVVM.mv.TransportationViewModel;
import com.fasterxml.jackson.core.JsonParser;

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
import java.util.HashMap;
import java.util.Map;

public class jsonWork extends ViewModel {
     //ButtonItem
     private Map<String, String[]> popupMenu = new HashMap<String,String[]>();

     //MarketItem
    private Map<String, String[]> apiNames = new HashMap<>();
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

    //Market
    private MutableLiveData<String> costBridgewatch = new MutableLiveData<>("");
    private MutableLiveData<String> costLymhust = new MutableLiveData<>("");
    private MutableLiveData<String> costCaerleon = new MutableLiveData<>("");
    private MutableLiveData<String> costFortSterling = new MutableLiveData<>("");
    private MutableLiveData<String> costThetford = new MutableLiveData<>("");
    private MutableLiveData<String> costMartlock = new MutableLiveData<>("");

    public MutableLiveData<String> getCostBridgewatch() {
        return costBridgewatch;
    }

    public MutableLiveData<String> getCostLymhust() {
        return costLymhust;
    }

    public MutableLiveData<String> getCostCaerleon() {
        return costCaerleon;
    }

    public MutableLiveData<String> getCostFortSterling() {
        return costFortSterling;
    }

    public MutableLiveData<String> getCostThetford() {
        return costThetford;
    }

    public MutableLiveData<String> getCostMartlock() {
        return costMartlock;
    }

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

    public jsonWork(){
        initialDataForMarketButtons();
        initialApiNamesForMarketItem();
    }

    private void initialApiNamesForMarketItem(){
        apiNames.put("Тканевая броня", new String[]{"T2_ARMOR_CLOTH_SET1", "T3_ARMOR_CLOTH_SET1", "T4_ARMOR_CLOTH_SET1",
        "T5_ARMOR_CLOTH_SET1", "T6_ARMOR_CLOTH_SET1", "T7_ARMOR_CLOTH_SET1", "T8_ARMOR_CLOTH_SET1", "T4_ARMOR_CLOTH_SET2",
        "T5_ARMOR_CLOTH_SET2", "T6_ARMOR_CLOTH_SET2", "T7_ARMOR_CLOTH_SET2", "T8_ARMOR_CLOTH_SET2","T4_ARMOR_CLOTH_SET3",
                "T5_ARMOR_CLOTH_SET3", "T6_ARMOR_CLOTH_SET3", "T7_ARMOR_CLOTH_SET3", "T8_ARMOR_CLOTH_SET3","T4_ARMOR_CLOTH_KEEPER",
                "T5_ARMOR_CLOTH_KEEPER", "T6_ARMOR_CLOTH_KEEPER", "T7_ARMOR_CLOTH_KEEPER", "T8_ARMOR_CLOTH_KEEPER","T4_ARMOR_CLOTH_MORGANA",
                "T5_ARMOR_CLOTH_MORGANA", "T6_ARMOR_CLOTH_MORGANA", "T7_ARMOR_CLOTH_MORGANA", "T8_ARMOR_CLOTH_MORGANA",});

    }

    private void initialDataForMarketButtons(){
        popupMenu.put("Броня", new String[] {"Тканевая броня", "Тканевый шлем", "Тканевые ботинки", "Кожанная броня", "Кожанный шлем", "Кожанные ботинки", "Тяжёлая броня"});
        popupMenu.put("Аксесуары", new String[] {"Сумка", "Плащ"});
        popupMenu.put("Артефакты", new String[]{"Броня", "Магия", "Оружие", "Левая рука", "Другое", "Дальнее оружие"});
    }

    public String[] getOneApiNames(String name){
        return apiNames.get(name);
    }

    public String[] getMenu(String name){
        return popupMenu.get(name);
    }

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

    public void getData(String apiname){
        String url = "https://www.albion-online-data.com/api/v2/stats/prices/" + apiname + "?locations=Caerleon,Bridgewatch,Lymhurst,Fort%20Sterling,Thetford,Martlock&qualities=1";

        new getURLDataForMarket().execute(url);
    }

    private class  getURLDataForMarket extends AsyncTask<String, String, String>{

        protected void  onPreExecute(){
            super.onPreExecute();
            costBridgewatch.setValue("Loading ...");
            costLymhust.setValue("Loading ...");
            costCaerleon.setValue("Loading ...");
            costFortSterling.setValue("Loading ...");
            costMartlock.setValue("Loading ...");
            costThetford.setValue("Loading ...");
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
                JSONArray array = new JSONArray(s);
                JSONObject bridgewatch = array.getJSONObject(0);
                JSONObject caerleon = array.getJSONObject(1);
                JSONObject fortSterling = array.getJSONObject(2);
                JSONObject lymhurst = array.getJSONObject(3);
                JSONObject martlock = array.getJSONObject(4);
                JSONObject thetford = array.getJSONObject(5);
                if(bridgewatch.getString("sell_price_min") == "" || bridgewatch.getInt("sell_price_min") == 0){
                    costBridgewatch.setValue("Информация временно отсутствует");
                }else {
                    costBridgewatch.setValue(bridgewatch.getString("sell_price_min"));
                }
                if(caerleon.getString("sell_price_min") == "" || caerleon.getInt("sell_price_min") == 0){
                    costCaerleon.setValue("Информация временно отсутствует");
                }else {
                    costCaerleon.setValue(caerleon.getString("sell_price_min") );
                }
                if(fortSterling.getString("sell_price_min") == "" || fortSterling.getInt("sell_price_min") == 0 ){
                    costFortSterling.setValue("Информация временно отсутствует");
                }else {
                    costFortSterling.setValue(fortSterling.getString("sell_price_min"));
                }
                if(lymhurst.getString("sell_price_min") == "" || lymhurst.getInt("sell_price_min") == 0){
                    costLymhust.setValue("Информация временно отсутствует");
                }else {
                    costLymhust.setValue(lymhurst.getString("sell_price_min"));
                }
                if(martlock.getString("sell_price_min") == "" || martlock.getInt("sell_price_min") == 0){
                    costMartlock.setValue("Информация временно отсутствует");
                }else {
                    costMartlock.setValue(martlock.getString("sell_price_min"));
                }
                if(thetford.getString("sell_price_min") == "" || thetford.getInt("sell_price_min") == 0){
                    costThetford.setValue("Информация временно отсутствует");
                }else {
                    costThetford.setValue(thetford.getString("sell_price_min"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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

    public void parseJson(){

    }


}
