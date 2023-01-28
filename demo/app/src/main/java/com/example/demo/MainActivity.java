package com.example.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.demo.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {
    private ContactDatabase contactDatabase;
    private ArrayList<Contact> contacts;
    private ContactDataAdapter contactDataAdapter;

    //Binding
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data binding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(handlers);


        //Recyclerview
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //Adapter
        contactDataAdapter = new ContactDataAdapter();
        recyclerView.setAdapter(contactDataAdapter);

        //database
        contactDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        ContactDatabase.class,
                        "ContactDB"
                )
                .allowMainThreadQueries()
                .build();

        // loadData
        LoadData();
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Contact contact = contacts.get(viewHolder.getAdapterPosition());
                DeleteContact(contact);
            }
        }).attachToRecyclerView(recyclerView);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 && resultCode ==RESULT_OK){
            String name = data.getStringExtra("NAME");
            String email = data.getStringExtra("EMAIL");
            Contact contact = new Contact(name,email,0);
            AddNewContact(contact);
        }
    }

    private void DeleteContact(Contact contact) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Onbackground
               contactDatabase.getContactDao().delete(contact);
                contacts.remove(contact);
                //On post Execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                      LoadData();
                        contactDataAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void LoadData() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Onbackground
                contacts = (ArrayList<Contact>) contactDatabase.getContactDao().getAllContacts();

                //On post Execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactDataAdapter.setContacts(contacts);
                        contactDataAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void AddNewContact(Contact contact){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Onbackground
                contactDatabase.getContactDao().insert(contact);

                //On post Execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        LoadData();
                        contactDataAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
    public class MainActivityClickHandlers {
        Context context;

        public MainActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onFABClicked(View view) {
            Intent i = new Intent(MainActivity.this, AddNewContactActivity.class);
            startActivityForResult(i, 1);
        }

    }
}