package com.example.rangbuocdulieu2chieu;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.Entity;

@Entity(tableName = "contact_table")
public class Contact extends BaseObservable {
    private String name;
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getEmail() {
        return email;
        notifyPropertyChanged(BR.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
