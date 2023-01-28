package com.example.rangbuocdulieu2chieu;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDataBase extends RoomDatabase {
    public abstract ContactDao getContactDao();
}
