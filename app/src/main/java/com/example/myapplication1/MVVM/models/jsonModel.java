package com.example.myapplication1.MVVM.models;

import java.util.HashMap;
import java.util.Map;

public class jsonModel {
    private String LocalizationNameVariable;
    private String LocalizationDescriptionVariable;
    private Map<String,String> LocalizedNames = new HashMap<>();
    private Map<String,String> LocalizedDescriptions = new HashMap<>();
    private String Index;
    private  String UniqueName;

    public String getLocalizationNameVariable() {
        return LocalizationNameVariable;
    }

    public String getLocalizationDescriptionVariable() {
        return LocalizationDescriptionVariable;
    }

    public Map<String, String> getLocalizedNames() {
        return LocalizedNames;
    }

    public Map<String, String> getLocalizedDescriptions() {
        return LocalizedDescriptions;
    }

    public String getIndex() {
        return Index;
    }

    public String getUniqueName() {
        return UniqueName;
    }
}
