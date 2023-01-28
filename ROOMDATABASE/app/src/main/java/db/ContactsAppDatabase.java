package db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import db.entity.Contact;

@Database(entities = {Contact.class},version = 1)
public abstract class ContactsAppDatabase extends RoomDatabase {

    // linking the DAO with our Database

    public abstract ContactDAO getContactDAO();
}
