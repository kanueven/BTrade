package com.example.btrade;

public class CategModel {
    int image;
    String title,description;

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public CategModel(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;

    }
}
