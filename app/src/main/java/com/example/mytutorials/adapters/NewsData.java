package com.example.mytutorials.adapters;

public class NewsData {
    private String name;
    private int imageResourceId;
    public NewsData(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
}
