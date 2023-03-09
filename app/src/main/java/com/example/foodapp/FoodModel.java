package com.example.foodapp;

import java.io.Serializable;

public class FoodModel implements Serializable { //TODO : Serializable butun modelleri alma.

    //TODO : 1. Data modelimizi olusturduk.

    private String foodName;
    private String foodTime;
    private String foodInfo;
    private int foodImage;


    // TODO : 2.Constracture olusturduk
    public FoodModel(String foodName, String foodTime, int foodImage, String foodInfo) {
        this.foodName = foodName;
        this.foodTime = foodTime;
        this.foodImage = foodImage;
        this.foodInfo = foodInfo;
    }

    // TODO : Getter ve Setter larimizi olusturduk
    public String getFoodName() {
        return foodName;
    }
    public String getFoodTime() {
        return foodTime;
    }
    public int getFoodImage() {
        return foodImage;
    }

    public String getFoodInfo() {
        return foodInfo;
    }
}
