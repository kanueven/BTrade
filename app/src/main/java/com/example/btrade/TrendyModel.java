package com.example.btrade;

public class TrendyModel {

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

        public TrendyModel(int image, String title, String description) {
            this.image = image;
            this.title = title;
            this.description = description;

        }
    }


