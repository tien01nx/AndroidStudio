package com.example.recyclerview;

public class VaccinModel {
    private  String title;
    private  int image;

    public VaccinModel() {
    }

    public VaccinModel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
