package com.example.danhbajetpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddNewContactActivity extends AppCompatActivity {
    private ContactDataBase contactDataBase;

    Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
    }
    public class AddNewContactActivityClickHandlers{
        Context context;

        public AddNewContactActivityClickHandlers(Context context) {
            this.context = context;
        }


        public void onSubmitClicked(View view){

            if (contact.getName() == null){
                Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent i = new Intent();
                i.putExtra("NAME", contact.getName());
                i.putExtra("EMAIL", contact.getEmail());


                setResult(RESULT_OK, i);
                finish();


            }
        }


    }
}