package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


    // TODO : 4. RecyclerView neyden extends olacagini belirttik
    // TODO : 5. Adapter in metodlarini implement ettik (onCreateViewHolder , onBindViewHolder , GetItemCount)
    // TODO : 6. FoodViewHolder i olusturduk
    // TODO : 7. onCreateViewHolder ---> icini doldurduk ---> GetItemCount icini doldurduk

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodViewHolder> {

    private final ArrayList<FoodModel> foodList;

    private final LayoutInflater layoutInflater;

    private FoodItemClickListener foodItemClickListener;

    @NonNull
    @Override
    public FoodsAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //row_food belirtmemiz gerekiyor

        View itemView = layoutInflater.inflate(R.layout.row_food,parent,false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodsAdapter.FoodViewHolder holder, int position) {

        FoodModel foodModel = foodList.get(position);
        holder.foodName.setText(foodModel.getFoodName());
        holder.foodTime.setText(foodModel.getFoodTime());
        holder.foodImage.setImageResource(foodModel.getFoodImage());

        holder.foodCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foodItemClickListener.onItemClicked(foodModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    // TODO : 8. FoodsAdapter Constracter olusturduk.
    public FoodsAdapter(Context context,ArrayList<FoodModel> foodList,FoodItemClickListener foodItemClickListener){

        layoutInflater=LayoutInflater.from(context);
        this.foodList = foodList;
        this.foodItemClickListener = foodItemClickListener;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder { // buraya row_food xml tanimlanacak

        public final TextView foodName;
        public final TextView foodTime;
        public final ImageView foodImage;
        public final CardView foodCardView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.textViewFoodName);
            foodTime = itemView.findViewById(R.id.textViewFoodTime);
            foodImage = itemView.findViewById(R.id.imageViewFood);
            foodCardView = itemView.findViewById(R.id.cardViewFood);
        }
    }

    // TODO : Click icin implement olusturduk.
    public interface FoodItemClickListener{

        void onItemClicked(FoodModel foodModel);

    }
}
