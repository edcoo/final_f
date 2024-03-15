package com.example.finalproject;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class CardViewHolder extends RecyclerView.ViewHolder {

    public ImageView Card;
    public TextView Name;
    public TextView Card_Type;

    public CardViewHolder(@NotNull View itemView) {
        super(itemView);
        Card = itemView.findViewById(R.id.Card);
        Name = itemView.findViewById(R.id.Name);
        Card_Type = itemView.findViewById(R.id.Card_Type);


    }

}
