package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //1 data
    ArrayList<GameModel> gameModels;

    //2 adapter view
    RecyclerView recyclerView;


    //3Adapter

    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        gameModels = new ArrayList<>();
        gameModels.add(new GameModel("Horizon Chase",R.drawable.card1));
        gameModels.add(new GameModel("PUBG",R.drawable.card2));
        gameModels.add(new GameModel("Head Ball 2",R.drawable.card3));
        gameModels.add(new GameModel("Hooked On You",R.drawable.card4));
        gameModels.add(new GameModel("Fifa 2022 ",R.drawable.card5));
        gameModels.add(new GameModel("Fortnite  ",R.drawable.card6));

        adapter = new MyAdapter(this,gameModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}