package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

    // TODO : 10. implement FoodsAdapter.FoodItemClickListener yaptik.
    // TODO : 11. public void onItemClicked(FoodModel foodModel) olusturduk.
public class MainActivity extends AppCompatActivity implements FoodsAdapter.FoodItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView foodRecyclerView = findViewById(R.id.recyclerViewFoods);

        // TODO : 12.Model listesini doldurduk.

        ArrayList<FoodModel> foodModelArrayList = new ArrayList<>();

        foodModelArrayList.add(new FoodModel("Makarna","30 dk",R.drawable.ic_makarna,"4 kişilik bir aile için \n" +
                "1 paket makarna \n" +
                "5 su bardağı su \n" +
                "1 tatlı kaşığı tuz\n" +
                "Sıvı yağ"));

        foodModelArrayList.add(new FoodModel("Tavuk Sote","25 dk",R.drawable.ic_tavukl_sote,"Yarım kg tavuk göğsü\n" +
                "2 yemek kaşığı sıvı yağ\n" +
                "1 tatlı kaşığı domates salçası\n" +
                "2 adet yeşil biber\n" +
                "1 adet kırmızı biber\n" +
                "1 adet soğan\n" +
                "2 diş sarımsak\n" +
                "2 adet domates\n" +
                "Karabiber\n" +
                "Pul biber\n" +
                "Tuz\n" +
                "1 su bardağı su"));



        foodModelArrayList.add(new FoodModel("Taze Fasülye","40 dk",R.drawable.ic_fasulye,"600 gr taze yeşil fasulye (çalı fasulye kullandım)\n"+
                "2 adet domates\n"+
                "1 adet soğan\n"+
                "Yarım çay kaşığı pul biber\n"+
                "Yarım çay kaşığı karabiber\n"+
                "2 çay kaşığı tuz\n"+
                "Yarım çay bardağı zeytinyağı (veya sıvı yağ)\n"+
                "1,5 yemek kaşığı domates salçası\n"+
                "2 su bardağı sıcak su\n"+
                "2 su bardağı sıcak su\n"));

        FoodsAdapter foodsAdapter = new FoodsAdapter(this,foodModelArrayList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        foodRecyclerView.setLayoutManager(linearLayoutManager);
        foodRecyclerView.setAdapter(foodsAdapter);
    }


    // TODO : onItemClicked Icine intent tanimladik baska sayfaya gitsin diye
    @Override
    public void onItemClicked(FoodModel foodModel) {

        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra("model",foodModel);
        startActivity(intent);

    }
}