package com.example.a668.searchapp.view;

/**
 * Created by spenc on 4/20/2017.
 */

public class Data {
    String title;
    String description;
    String URL;
    Data(String title, String URL,String description) {
        this.title = title;
        this.URL = URL;
        this.description = description;
    }

     public String getTitle(){
         return title;
     }
}

