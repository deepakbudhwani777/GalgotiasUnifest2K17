package com.gquasar.galgotiasunifest2017;

/**
 * Created by Prakhar on 1/10/2017.
 */

public class DataModel {

    private String title;
    private int image;

    public DataModel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public int getImage() {
        return image;
    }


    public String getTitle() {
        return title;
    }
}
