package com.example.myapplication1.MVVM.repositories;

public class Data {
    private String city_from;
    private String city_to;
    private Integer count;

    public String getCity_from() {
        return city_from;
    }

    public String getCity_to() {
        return city_to;
    }

    public Integer getCount() {
        return count;
    }

    public void setCity_from(String city_from) {
        this.city_from = city_from;
    }

    public void setCity_to(String city_to) {
        this.city_to = city_to;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
