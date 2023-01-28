package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //
//    TextView personName,personEmail;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        personEmail = findViewById(R.id.personEmail);
//        personName = findViewById(R.id.personName);

        // textView
        Person p = new Person("hihi", "hihiconga123@gmail.com");
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setPerson(p);
//        personName.setText(p.getName());
//        personEmail.setText(p.getEmail());

        // Binding the Handler
        clickHandler = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(clickHandler);
    }

    public class MainActivityClickHandlers {
        Context context;

        public MainActivityClickHandlers(Context context) {
            this.context = context;
        }

        // First Button Click Handling
        public void onButton1Click(View view) {
            Toast.makeText(context, "Hello My Friends", Toast.LENGTH_SHORT).show();
        }


        // Second Button CLick Handling
        public void onButton2Click(View view) {
            Toast.makeText(context, "Bye Bye my Friends", Toast.LENGTH_SHORT).show();
        }

    }
}