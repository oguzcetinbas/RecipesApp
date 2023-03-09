package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // TODO : ActionBar'a geri tusu koyma.

        Intent intent = getIntent();

        FoodModel foodModel = (FoodModel) getIntent().getSerializableExtra("model");

        TextView textViewFoodTime = findViewById(R.id.textViewFoodTime);
        TextView textViewInfo = findViewById(R.id.textViewFoodInfo);
        ImageView imageViewFood = findViewById(R.id.imageViewFood);

        textViewFoodTime.setText(foodModel.getFoodTime());
        textViewFoodTime.setText(foodModel.getFoodInfo());
        imageViewFood.setImageResource(foodModel.getFoodImage());

    }
}