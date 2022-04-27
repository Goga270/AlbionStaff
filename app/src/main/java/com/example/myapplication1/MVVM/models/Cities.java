package com.example.myapplication1.MVVM.models;

public class Cities {
    private String name;
    private String api_name;

    public Cities(String name) {
        this.name = name;
        switch (name){
            case "Люмхурст":
                api_name = "Lymhurst";
                break;
            case "Форт Стерлинг":
                api_name = "Fort Sterling";
                break;
            case "Тетфорд":
                api_name = "Thetford";
                break;
            case "Мартлок":
                api_name = "Martlock";
                break;
            case "Бриджвотч":
                api_name = "Bridgewatch";
                break;
            case "Карлеон":
                api_name = "Caerleon";
                break;
        }
    }

    public String getName() {
        return name;
    }

    public String getApi_name() {
        return api_name;
    }
}
