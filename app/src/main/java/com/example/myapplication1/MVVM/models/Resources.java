package com.example.myapplication1.MVVM.models;

public class Resources {
    private String name;
    private String tier;
    private String api_name;
    private String eng_name;

    public Resources(String name, String tier) {
        this.name = name;
        this.tier = tier;
        switch (name){
            case "Ткань":
                eng_name = "CLOTH";
                break;
            case "Хлопок":
                eng_name = "FIBER";
                break;
            case "Шкура":
                eng_name = "HIDE";
                break;
            case "Кожа":
                eng_name = "LEATHER";
                break;
            case "Металический слиток":
                eng_name = "METALBAR";
                break;
            case "Меттал":
                eng_name = "ORE";
                break;
            case "Дерево":
                eng_name = "WOOD";
                break;
            case "Обработанное дерево":
                eng_name = "PLANKS";
                break;
            case "Камень":
                eng_name = "ROCK";
                break;
            case "Каменный блок":
                eng_name = "STONEBLOCK";
                break;
        }
        setApi_name();
    }

    public String getTier() {
        return tier;
    }

    public void setApi_name() {
        this.api_name = "T" + this.tier + "_" + this.eng_name;
    }

    public String getApi_name() {
        return api_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public void setApi_name(String api_name) {
        this.api_name = api_name;
    }


}
