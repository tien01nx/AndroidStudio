package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button=findViewById(R.id.button);
        displaySavedText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();
                displatAndSaveText(enteredText);
            }
        });
    }

    private void displaySavedText() {
//        Lấy giá trị từ sharedpref
        SharedPreferences sharedPreferences = getSharedPreferences("hihi",MODE_PRIVATE);
        String s1 = sharedPreferences.getString("name","");
        textView.setText(s1);
    }

    private void displatAndSaveText(String enteredText ) {
        // gan textview  = edittext
        textView.setText(enteredText);
        // luu van ban va chia se
        SharedPreferences sharedPreferences = getSharedPreferences("hihi",MODE_PRIVATE);
        // ghi du lieu va chia se
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        editor.putString("name",enteredText);
        editor.commit();

    }
}