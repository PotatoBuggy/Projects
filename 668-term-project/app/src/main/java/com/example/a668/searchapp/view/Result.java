package com.example.a668.searchapp.view;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a668.searchapp.controller.JsonController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by spenc on 4/16/2017.
 */

public class Result extends Fragment {

    ViewGroup rootView;
    String searchData;
    RecyclerView  recycler_view;
    LinearLayoutManager recylerManager;
    RVAdapter rvadapter;
    ArrayList<Data> dataList;
    static public int counter =0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView= (ViewGroup)inflater.inflate(R.layout.activity_result,container,false);

        recycler_view= (RecyclerView) rootView.findViewById(R.id.recycleview_items_id);
        recylerManager = new LinearLayoutManager(getActivity());

        //Set Up Recycler View
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(recylerManager);

        dataList = new ArrayList<>();

        //Receive Search Data
        Bundle bundle_box= getArguments();
        searchData= bundle_box.getString("SearchData");

        //Enable Search Field
        setHasOptionsMenu(true);

        return rootView;
    }


    //Create Search Field Through Menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //Join Custom Layout
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem items= menu.findItem(R.id.menu_search_id);

        //Create Search
        SearchView search = (SearchView)items.getActionView();

        final Context context = this.getActivity();

        //Add Search Function
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("search", query);
                counter++;
                if(query.length() > 1) {
                    loadData(query);
                    return false;
                } else {
                    Toast.makeText(getActivity(), "Must provide more than one character", Toast.LENGTH_SHORT).show();
                    recycler_view.setVisibility(View.GONE);
                    return true;
                }
            }

            //Filter Text to Search
            @Override
            public boolean onQueryTextChange(String newText){

                newText = newText.toLowerCase();

                if(newText.length() > 1) {
                    loadData(newText);
                } else if(newText.equals("")) {
                }
                return true;
            }
        });

        //Receive Search Data from Previous Fragment
        search.setQuery(searchData,false);

        super .onCreateOptionsMenu(menu, inflater);
    }


    public void loadData(String query) {

        dataList = new ArrayList<Data>();
        //String jsurl = "http://10.143.246.93:8983/solr/SFSU_test/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=50&fl=dc_title_s,id,description_s&omitHeader=true";
        String jsurl = "http://" + JsonController.ip + ":8983/solr/" + JsonController.datasource + "/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=50&fl=dc_title_s,id,description_s&omitHeader=true";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                jsurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.i("On Response(response): ", response + "\n");
                        try {
                            Log.i("Try: ", "Im before Obj init." + "\n");
                            JSONObject jsonObject = new JSONObject(response);
                            Log.i("Try: ", "Im after Obj init." + "\n");
                            JSONArray jsonArray = jsonObject.getJSONObject("response").getJSONArray("docs");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                String titl = "No title", descrip = "No Description";

                                if (o.optString("dc_title_s") != "") {
                                    titl = o.optString("dc_title_s");
                                }
                                if (o.optString("description_s") != "") {
                                    descrip = o.optString("dc_title_s");
                                }

                                Data data = new Data(
                                        titl,
                                        o.optString("id"),
                                        descrip
                                );

                                dataList.add(data);

                            }

                            rvadapter = new RVAdapter(dataList, getActivity().getApplicationContext());
                            rvadapter.setFilter(dataList);
                            recycler_view.setAdapter(rvadapter);

                        } catch (JSONException e) {
                            Log.i("Except ", "I m in Exp." + "\n");
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        RequestQueue rQ = Volley.newRequestQueue(getActivity());
        rQ.add(stringRequest);
    }
}





