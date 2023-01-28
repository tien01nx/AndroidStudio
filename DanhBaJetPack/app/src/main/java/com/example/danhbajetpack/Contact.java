package com.example.danhbajetpack;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;

@Entity(tableName = "contact_table")
public class Contact  extends BaseObservable {
    private String email;
    private String name;
    public Contact(String email, String name) {
        this.email = email;
        this.name = name;
    }
    @Bindable
    public String getEmail() {
        return email;
        notifyPropertyChanged(BR.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
