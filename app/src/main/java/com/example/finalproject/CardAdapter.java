package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    List<Card> Cards;

    public CardAdapter() {
        super();
        Cards = new ArrayList<>();
        Cards.add(new Card(R.drawable.eden1,"Card1", "Credit Card"));
        Cards.add(new Card(R.drawable.eden2,"Card2", "Passport Card"));
        Cards.add(new Card(R.drawable.eden3,"Card3", "Driver License"));
        Cards.add(new Card(R.drawable.eden4,"Card4", "Insurance Card"));
        Cards.add(new Card(R.drawable.eden5,"Card5", "ID Card"));
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card Card = Cards.get(position);
        holder.Card.setImageResource(Card.Card);
        holder.Name.setText(Card.Name);
        holder.Card_Type.setText(Card.Card_Type);

    }

    @Override
    public int getItemCount() {
        return Cards.size();
    }
}
