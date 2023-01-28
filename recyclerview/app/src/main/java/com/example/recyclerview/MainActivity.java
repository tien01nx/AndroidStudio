package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    //1 Adapter Recyclerview
    RecyclerView recyclerView;
    // 2 data source
    VaccinModel [] mylistData;

    // 3 Myadapter
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listView);
        
        mylistData = new VaccinModel[]{
                new VaccinModel("Hepatitis B Vaccxin",R.drawable.vaccine1),
                new VaccinModel("Tetanus Vaccxin",R.drawable.vaccine4),
                new VaccinModel("Tetanus 1",R.drawable.vaccine4),
                new VaccinModel("Tetanus 2",R.drawable.vaccine5),
                new VaccinModel("Tetanus 3",R.drawable.vaccine6),
                new VaccinModel("Tetanus 4",R.drawable.vaccine7),
        };
        //Adapter
        adapter = new MyAdapter(mylistData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //handlings the click events
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccxin name: "+ mylistData[pos].getTitle() , Toast.LENGTH_SHORT).show();
    }
}