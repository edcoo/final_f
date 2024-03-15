package com.example.finalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        rv.setLayoutManager(layoutManager);

        CardAdapter adapter = new CardAdapter();
        rv.setAdapter(adapter);
    }

}