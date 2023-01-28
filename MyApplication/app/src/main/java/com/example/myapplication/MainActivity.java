package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1 create listview
    ListView listView;
    private  static  CustomerAdapter adapter;

    ArrayList<CountryModelClass> dataModel;



    // 2 data source
    String [] worldCup22 ={
            "Germany",
            "Spain",
            "Brazil",
            "England",
            "USA",
            "Saudi Arabia",
            "France"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 adapterView: a lisview
        listView = findViewById(R.id.listview);

//        // 3 adapter
//        ArrayAdapter  adapter = new ArrayAdapter(this,R.layout.my_list,R.id.textview,worldCup22);
//        listView.setAdapter(adapter);

        //2 data cource
        dataModel = new ArrayList<>();
        dataModel.add(new CountryModelClass("Germany","4",R.drawable.germany));
        dataModel.add(new CountryModelClass("France","2",R.drawable.france));
        dataModel.add(new CountryModelClass("brazil","3",R.drawable.brazil));
        dataModel.add(new CountryModelClass("spain","1",R.drawable.spain));
        dataModel.add(new CountryModelClass("England","0",R.drawable.unitedkingdom));
        dataModel.add(new CountryModelClass("Saudi Arabia","6",R.drawable.saudiarabia));

        //3 adapter
        adapter = new CustomerAdapter(dataModel,getApplicationContext());
        listView.setAdapter(adapter);


        // 4 handling the click envents on ListView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Country; "+adapter.getItem(i).getCountry_name() +"World Cups Win: " + adapter.getItem(i).getCup_win_count() , Toast.LENGTH_SHORT).show();
            }
        });




    }
}