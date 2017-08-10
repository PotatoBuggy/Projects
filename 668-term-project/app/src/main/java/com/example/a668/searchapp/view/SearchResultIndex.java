package com.example.a668.searchapp.view;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.example.a668.searchapp.controller.JsonController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//import java.util.ObjectMapper;

/**
 * Created by rain-SB on 5/4/2017.
 */

public class SearchResultIndex  {
//    public static SearchResult[] searchResultIndex;
//    int numFound;
//    Result results;
//
//    public SearchResultIndex(){
//
//    }
//
//
//    public SearchResultIndex(String crawlerResponse/*NetworkResponse crawlerResponse*/) {
//        //String jsonString = new String(crawlerResponse.data);
//        //if(jsonString.contains(""))
//        //uncomment to let parsing work
//        if(JsonController.toParse)
//            parseRes(crawlerResponse); //parseRes(jsonString);
//        else
//            Log.i("no parsing", "in SearchResultIndex()");
//        //parseResponse(crawlerResponse);
////        if (searchResultIndex.length != numFound) {
////            System.out.println("Error number of Results Found: " + numFound);
////            System.out.println("Results Returned: " + searchResultIndex.length);
////        }
//    }
//
//
//    // SearchResultIndex() has String argument for backend branch, NetworkResponse argument for ivan branch
//    public SearchResultIndex(NetworkResponse crawlerResponse) {
//        String jsonString = new String(crawlerResponse.data);
//        //if(jsonString.contains(""))
//        //uncomment to let parsing work
//        if(JsonController.toParse)
//            parseRes(jsonString);
//        //parseResponse(crawlerResponse);
////        if (searchResultIndex.length != numFound) {
////            System.out.println("Error number of Results Found: " + numFound);
////            System.out.println("Results Returned: " + searchResultIndex.length);
////        }
//    }
//
//    //Parses to get string INSIDE OF  [...]
//    public void parseRes(String crawlRes){
//        // 5/10 placed try catch because put methods would result in error.
//        try {
//            Log.i("inside parseRes", crawlRes);
//            if (crawlRes.length() < 1) return;
//            String[] parts = crawlRes.split("\\[", 2);
////        System.out.println("parts LENGTH" + parts.length);
////        System.out.println(parts[0]);
////        System.out.println(parts[1]);
//
//            String[] parts2 = parts[1].split("\\]", 2);
//            //System.out.println("Parts 2" + parts2[0]);
//
//            String results = "[" + parts2[0] + "]";
//            parseResponse(results);
//        }catch(Exception e){
//            Log.i("error parseRes", e.getMessage());
//        }
//
//
//    }
//
//    //Parses into SearchResult Objects
//    public void parseResponse (String response){
//        Gson gson = new GsonBuilder().create();
//        Log.i("inside parseResponse", response);
//        searchResultIndex = gson.fromJson(response, SearchResult[].class);
//        for(SearchResult result: searchResultIndex)
//        {
//            Log.i("\nparseResponse", result.toString());
//        }
//
//        Log.i("here", "here2");
//
//    }


}
