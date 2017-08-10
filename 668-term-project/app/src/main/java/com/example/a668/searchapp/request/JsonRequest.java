package com.example.a668.searchapp.request;

import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.a668.searchapp.controller.JsonController;

import java.util.HashMap;
import java.util.Map;


public class JsonRequest extends Request<String> {

    static String response;
    public static String nextUrl; //updated from HomeFrame class, when user enters new url
    private final Listener<String> successListener;
    private Map<String, String> params;

    public JsonRequest( int method,
                        String url,
                        Listener<String> successListener,
                        Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.successListener = successListener;
    }

    public JsonRequest(int method, String url, Map<String, String> params,
                             Listener<String> reponseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.successListener = reponseListener;
        this.params = params;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        // Convert byte[] data received in the response to String
        String jsonString =  new String(response.data);
        this.response = jsonString;
        try {
            JsonController.waitForResponse = false;
            jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(jsonString, HttpHeaderParser.parseCacheHeaders(response));
        }catch(Exception e){
            Log.i("ERROR in parseNetork", "response error");
            return Response.success( "1", getCacheEntry());
        }
    }

    public static String returnResponse(){
        return response;
    }

    @Override
    protected void deliverResponse(String response) {
        Log.i("deliverResponse", response);
        successListener.onResponse(response);
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError{
        Map<String, String> headers = new HashMap<String, String>();

        //headers.put("User-agent", "YOUR_USER_AGENT");
        String creds = "admin:abc123415";

        //byte[] authEncBytes = Base64.encodeBase64(creds.getBytes());
        //java.util.Base64.getEncoder().encodeToString( creds.getBytes() );
        //Base64.encodeBase64( creds.getBytes());
        //String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
        String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", auth);
        params = headers;
        return headers;
    }


    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }

    @Override
    public void deliverError(VolleyError error) {
        Log.i("error volley", "in deliverError");
    }
}

