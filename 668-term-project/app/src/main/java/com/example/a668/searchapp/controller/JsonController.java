//package com.example.a668.searchapp.controller;
//
//
//import android.content.Context;
//import android.net.Uri;
//import android.util.Log;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.VolleyLog;
//import com.android.volley.toolbox.RequestFuture;
//import com.example.a668.searchapp.request.JsonRequest;
//import com.example.a668.searchapp.volley.VolleySingleton;
//
//import java.util.HashMap;
//import java.util.Map;
///**
// * <p> Provides interface between {@link android.app.Activity} and {@link com.android.volley.toolbox.Volley} </p>
// */
//public class JsonController {
//
//    public String newJsonString;
//    private final int TAG = 100;
//    public static boolean waitForResponse;
//    public static boolean oldUrl;
//    public static boolean toParse;
//    private OnResponseListener responseListener;
//
//
//    /**
//     *
//     * @param responseListener  {@link OnResponseListener}
//     */
//    public JsonController(OnResponseListener responseListener) {
//        this.responseListener = responseListener;
//    }
//
//    /**
//     * Adds request to volley request queue
//     * @param query query term for search
//     */
//    public void sendRequest(String query, Context context) {
//
//        waitForResponse = true;
//        // Request Method
//        int method = Request.Method.GET;
//        if (true){
//            changeURL(context);
//            runWebCrawler(context);
//
//
////<<<<<<< HEAD
////=======
////        String test = "http://10.0.2.2:8983/solr/SFSU_test/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=10&fl=dc_title_s,description_s,id&omitHeader=true";
////        String url = test;
////>>>>>>> backend
//
//        }else {
//        }
//            String test = "http://10.0.2.2:8983/solr/sfsu/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=10&fl=dc_title_s,description_s,id&omitHeader=true";
//            //test = "http://10.0.2.2:8764/api/apollo/connectors/datasources/sfsuid";
//            String url = test;
//
//
//            // Create new request using JsonRequest
//            JsonRequest request
//                    = new JsonRequest(
//                    method,
//                    url,
//                    new Response.Listener() {
//                        @Override
//                        public void onResponse(Object response) {
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.i("FAILURE REASON", error.getMessage());
//                            responseListener.onFailure(error.getMessage());
//                        }
//                    });
////        ){
////            @Override
////            public Map<String, String> getHeaders(){
////                Map<String, String> headers = new HashMap<String, String>();
////                //headers.put("User-agent", "YOUR_USER_AGENT");
////                String creds = "admin:abc123415";
////
////                //byte[] authEncBytes = Base64.encodeBase64(creds.getBytes());
////                //java.util.Base64.getEncoder().encodeToString( creds.getBytes() );
////                //Base64.encodeBase64( creds.getBytes());
////                //String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
////                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
////                //String auth ="Basic " +  Base64.encode(creds.getBytes(), Base64.NO_WRAP);
////               // Base64.getEncoder().encodeToString(creds.getBytes("utf-8"))
////                Log.i("Auth" , auth);
////                headers.put("Content-Type", "application/json");
////                headers.put("Authorization", auth);
////                return headers;
////            }
////        };
//
//            // Add tag to request
//            request.setTag(TAG);
//
//            // Get RequestQueue from VolleySingleton
//            waitForResponse = true;
//            toParse = true;
//            VolleySingleton.getInstance(context).addToRequestQueue(request);
//            while(waitForResponse);
//
//            Log.i("SEARCH RESULT: ", JsonRequest.returnResponse());
//
//    }
//
//
//    // this changes the startlinks url of the web crawler.
//    public void changeURL(Context context){
//        String test = "http://10.0.2.2:8764/api/apollo/connectors/datasources/sfsuid";
//        String url = test;
//
//        int method = Request.Method.GET;
//        RequestFuture<String> future = RequestFuture.newFuture();
//        // Create new request using JsonRequest
//        JsonRequest request = new JsonRequest(
//                method,
//                url,
//                new Response.Listener<String>() {
////<<<<<<< HEAD
//                    public void onResponse(String response) {
//
//                    }
//                       //Log.i("OBJECT" , response.toString());
//                        //String response = ;
//
//                        //Log.i("THER RESPONSE", JsonRequest.returnResponse());
//////=======
////                    @Override
////                    public void onResponse(Object response) {
////
////                        newJsonString = String.valueOf(response);
//////                        Log.i("Response: ", String.valueOf(response));
//////>>>>>>> backend
////                    }
//                },
//                //future,
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("FAILURE REASON", error.getMessage());
//                        responseListener.onFailure(error.getMessage());
//                    }
//                });
//                //future);
//
//        // Add tag to request
//        request.setTag(TAG);
//
//        // Get RequestQueue from VolleySingleton
//        toParse = false;
//        VolleySingleton.getInstance(context).addToRequestQueue(request);
////<<<<<<< HEAD
//       // waitForResponse is set to false after response is set. It is set to true at the start of the sendRequest method.
//        while(waitForResponse);
//
//        try {
//            //String responseString  = future.get(10, TimeUnit.SECONDS);
//            Log.i("THER RESPONSE", JsonRequest.returnResponse());
//
//            waitForResponse = true;
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        } catch (ExecutionException e) {
////            e.printStackTrace();
//        } catch(Exception e){
//
//        }
//
//
//        // This block of code gets the "startLink" url in response
//        String responseString = JsonRequest.returnResponse();
//        // response will look like: .... "startLinks": [ "http://sfsu.edu"] ...
//        String whereStartLinksIs = responseString.substring(responseString.indexOf("startLinks"));
//        // gets substring from first bracket in [ "http://sfsu.edy"] .. , then from that to last bracket
//        String getFirstBracket = whereStartLinksIs.substring(whereStartLinksIs.indexOf("[") + 1);
//        String startLinkUrlInResponse = getFirstBracket.substring(0, getFirstBracket.indexOf("\" ]"));
//        startLinkUrlInResponse = startLinkUrlInResponse.substring(startLinkUrlInResponse.indexOf("\"") + 1);
//        startLinkUrlInResponse = startLinkUrlInResponse.trim();
//        Log.i("url start link", startLinkUrlInResponse);
//
//        if(!JsonRequest.nextUrl.contains("http://"))
//            JsonRequest.nextUrl = "http://" + JsonRequest.nextUrl;
//
//        responseString = responseString.replace(startLinkUrlInResponse, JsonRequest.nextUrl);
//
//
//
//        Log.i("changed startlink url", responseString);
//
//
//        // requestBody is the altered response having the new startLinks url
//        final String requestBody = responseString;
//        //String url = "http://10.0.2.2:8764/api/apollo/connectors/datasources/sfsuid";
//        url = "http://10.0.2.2:8764/api/apollo/connectors/datasources/sfsuid";
//        JsonRequest putRequest = new JsonRequest(Request.Method.PUT,url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                //Log.i("FAILURE REASON", error.getMessage());
//                responseListener.onFailure(error.getMessage());
//            }
//        }){
//
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                    HashMap<String, String> headers = new HashMap<String, String>();
////                    headers.put("Content-Type", "application/json");
//                    String creds = "admin:abc123415";
//                    //String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
//                    String auth = "Basic YWRtaW46YWJjMTIzNDE1";
//                    //Log.i("Auth" , auth);
//                    //headers.put("Content-Type", "application/json");
//                    headers.put("Authorization", auth);
//                    return headers;
//                }
//                @Override
//                public String getBodyContentType() {
//                return "application/json";
//                }
//
//                @Override
//                public byte[] getBody() throws AuthFailureError {
//                try {
//                    Log.i("new body sent", requestBody);
//                    return requestBody == null ? null : requestBody.getBytes();
//                } catch (Exception uee) {
//                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
//                    return null;
//                }
//            }};
//
//        toParse = false;
//        VolleySingleton.getInstance(context).addToRequestQueue(putRequest);
//        Log.i("STILL WAITING", "WAITING AFTER PUT REQUEST");
//        //while(waitForResponse);
//        Log.i("DONE WAITING", JsonRequest.returnResponse());
//        try {
//            Thread.sleep(5000);                 //1000 milliseconds is one second.
//            Log.i("wake up thread", "woke up");
//        } catch(InterruptedException ex) {
//            Log.i("interrupt exc", "thread interrupted");
//            Thread.currentThread().interrupt();
//        }
//
//    }
//
//    public void runWebCrawler(Context context){
//        String url = "http://10.0.2.2:8764/api/apollo/connectors/jobs/sfsuid";
//        JsonRequest postRequestToRunCrawler = new JsonRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //Log.i("OBJECT" , response.toString());
//                        //String response = ;
//
//                        //Log.i("THER RESPONSE", JsonRequest.returnResponse());
//                    }
//                },
//                //future,
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("FAILURE REASON", error.getMessage());
//                        responseListener.onFailure(error.getMessage());
//                    }
//                });
//        waitForResponse = true;
//
//        toParse = false;
//        VolleySingleton.getInstance(context).addToRequestQueue(postRequestToRunCrawler);
//        while(waitForResponse);
//
//        Log.i("run crawler", JsonRequest.returnResponse());
//        // waits 15 seconds
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//        try {
//            Thread.sleep(10000);                 //1000 milliseconds is one second.
//            Log.i("wake up thread", "woke up");
//        } catch(InterruptedException ex) {
//            Log.i("interrupt exc", "thread interrupted");
//            Thread.currentThread().interrupt();
//        }
//
////        final Context contextAccessedInRunnable = context;
////        final String urlAccessedInRunnable = url;
////        new android.os.Handler().postDelayed(
////                new Runnable() {
////                    public void run() {
////                        Log.i("tag", "This'll run 300 milliseconds later");
////                        JsonRequest deleteRequestToStopCrawler = new JsonRequest(Request.Method.DELETE, urlAccessedInRunnable,
////                                new Response.Listener<String>() {
////                                    @Override
////                                    public void onResponse(String response) {
////                                        //Log.i("OBJECT" , response.toString());
////                                        //String response = ;
////                                        Log.i("onResponse in delete", response);
////                                        //Log.i("THER RESPONSE", JsonRequest.returnResponse());
////                                    }
////                                },
////                                //future,
////                                new Response.ErrorListener() {
////                                    @Override
////                                    public void onErrorResponse(VolleyError error) {
////                                        Log.i("FAILURE REASON", error.getMessage());
////                                        responseListener.onFailure(error.getMessage());
////                                    }
////                                });
////                        waitForResponse = true;
////                        toParse = false;
////                        VolleySingleton.getInstance(contextAccessedInRunnable).addToRequestQueue(deleteRequestToStopCrawler);
////
////                        //while(waitForResponse);
////                        Log.i("stop crawler", JsonRequest.returnResponse());
////                        try {
////                            Thread.sleep(10000);                 //1000 milliseconds is one second.
////                            Log.i("wake up thread", "woke up");
////                        } catch(InterruptedException ex) {
////                            Log.i("interrupt exc", "thread interrupted");
////                            Thread.currentThread().interrupt();
////                        }
////                    }
////                },
////                15000);
//
//        // must wait until stopping the crawl finishes too.
////        new android.os.Handler().postDelayed(
////                new Runnable() {
////                    public void run() {
////                        Log.i("tag", "This'll run 15 seconds later");
////                    }
////                },
////                15000);
//
//
//        JsonRequest deleteRequestToStopCrawler = new JsonRequest(Request.Method.DELETE, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //Log.i("OBJECT" , response.toString());
//                        //String response = ;
//
//                        //Log.i("THER RESPONSE", JsonRequest.returnResponse());
//                    }
//                },
//                //future,
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("FAILURE REASON", error.getMessage());
//                        responseListener.onFailure(error.getMessage());
//                    }
//                });
//
//        waitForResponse = true;
//        VolleySingleton.getInstance(context).addToRequestQueue(deleteRequestToStopCrawler);
//        //while(waitForResponse);
//        Log.i("stop crawler", JsonRequest.returnResponse());
//        try {
//            Thread.sleep(10000);                 //1000 milliseconds is one second.
//            Log.i("wake up thread", "woke up");
//        } catch(InterruptedException ex) {
//            Log.i("interrupt exc", "thread interrupted");
//            Thread.currentThread().interrupt();
//        }
//
//        //while(waitForResponse);
//
//
////=======
//////        Log.i("\nJsonController.java", "After add to request queue");
////>>>>>>> backend
//    }
//
//    public void cancelAllRequests(Context context) {
//        VolleySingleton.getInstance(context).cancelAllRequests(TAG);
//    }
//
//    public interface OnResponseListener {
//        void onSuccess();
//        void onFailure(String errorMessage);
//    }
//
//}

// BACKEND BRANCH VERSION ABOVE

package com.example.a668.searchapp.controller;


import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.RequestFuture;
import com.example.a668.searchapp.request.JsonRequest;
import com.example.a668.searchapp.volley.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonController {

    private final int TAG = 100;
    public static boolean waitForResponse;
    public static boolean oldUrl;
    public static boolean toParse;
    private OnResponseListener responseListener;
    public static boolean crawlNotFinish;
    public final static String datasource = "sfsu6681";
    public final static String datasourceId = "668sfsu1";
    public final static String ip = "10.143.165.222";

    /**
     *
     * @param responseListener  {@link OnResponseListener}
     */

    public JsonController(OnResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    public JsonController(){}

    public void sendRequest(String query, Context context){
        sendRequest(query,context,false, false);
    }
    public void sendRequest(String query, Context context, boolean crawl, boolean fromHomeFrame) {


        //String datasource = "sfsu6681";
        waitForResponse = true;
        // Request Method
        int method = Request.Method.GET;
        if (crawl || fromHomeFrame){
            crawlNotFinish = true;
            changeURL(context);
            //runWebCrawler(context);
        }else {
            //return;
        }
        //10.143.246.93
//<<<<<<< HEAD
        //String test = "http://10.143.246.93:8983/solr/sfsu/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=10&fl=dc_title_s,id,description_s&omitHeader=true";
        String test = "http://" + ip + ":8983/solr/" + datasource + "/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=10&fl=dc_title_s,id,description_s&omitHeader=true";
//=======
//        String test = "http://10.143.246.93:8983/solr/SFSU_test/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=10&fl=dc_title_s,id,description_s&omitHeader=true";
//        //String test = "http://10.0.2.2:8983/solr/sfsu/select?indent=on&q=" + Uri.encode(query) + "&wt=json&rows=10&fl=dc_title_s,id,description_s&omitHeader=true";
//>>>>>>> 6da3c03c2da771f9b23270a900146781ddb85086
        //test = "http://10.0.2.2:8764/api/apollo/connectors/datasources/sfsuid";
        String url = test;


        // Create new request using JsonRequest
        JsonRequest request
                = new JsonRequest(
                method,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("SEARCH RESULT: ", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("FAILURE REASON", error.getMessage());
                        responseListener.onFailure(error.getMessage());
                    }
                });

        // Add tag to request
        request.setTag(TAG);

        // Get RequestQueue from VolleySingleton
        waitForResponse = true;
        toParse = true;
        VolleySingleton.getInstance(context).addToRequestQueue(request);
        while(waitForResponse);

    }


    // this changes the startlinks url of the web crawler.

    public void changeURL(final Context context){
        //final String datasourceId = "668sfsu1";
        String test = "http://" + ip + ":8764/api/apollo/connectors/datasources/" + datasourceId;
        //String test = "http://10.143.246.93:8764/api/apollo/connectors/datasources/sfsu_id";
        String url = test;
        final Context context2 = context;
        int method = Request.Method.GET;
        RequestFuture<String> future = RequestFuture.newFuture();
        final String[] datasourceResponse = new String[1];
        // Create new request using JsonRequest
        JsonRequest request
                = new JsonRequest(
                method,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //String
                        Log.i("inside onResponse 1st", response);
                        datasourceResponse[0] = response;

                        // This block of code gets the "startLink" url in response
                        String responseString = response;
                        String whereStartLinksIs = responseString.substring(responseString.indexOf("startLinks"));

                        // gets substring from first bracket in [ "http://sfsu.edy"] .. , then from that to last bracket
                        String getFirstBracket = whereStartLinksIs.substring(whereStartLinksIs.indexOf("[") + 1);
                        String startLinkUrlInResponse = getFirstBracket.substring(0, getFirstBracket.indexOf("\" ]"));
                        startLinkUrlInResponse = startLinkUrlInResponse.substring(startLinkUrlInResponse.indexOf("\"") + 1);
                        startLinkUrlInResponse = startLinkUrlInResponse.trim();
                        Log.i("url start link", startLinkUrlInResponse);

                        if(!JsonRequest.nextUrl.contains("http://"))
                            JsonRequest.nextUrl = "http://" + JsonRequest.nextUrl;

                        responseString = responseString.replace(startLinkUrlInResponse, JsonRequest.nextUrl);

                        final String requestBody = responseString;
                        //String url = "http://10.0.2.2:8764/api/apollo/connectors/datasources/sfsuid";
                        //url = "http://10.0.2.2:8764/api/apollo/connectors/datasources/sfsu_id";
                        //final String url2 = "http://10.143.246.93:8764/api/apollo/connectors/datasources/sfsu_id";
                        final String url2 = "http://" + ip + ":8764/api/apollo/connectors/datasources/" + datasourceId;
                        JsonRequest putRequest = new JsonRequest(Request.Method.PUT,url2, new HashMap<String, String>(), new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i("inside onResponse 2nd", response);
                                try {
                                    Thread.sleep(5000);                 //1000 milliseconds is one second.
                                } catch(InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                                runWebCrawler(context2);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.i("FAILURE REASON", error.getMessage());
                                responseListener.onFailure(error.getMessage());
                            }
                        }){

                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                HashMap<String, String> headers = new HashMap<String, String>();
//                    headers.put("Content-Type", "application/json");
                                String creds = "admin:abc123415";
                                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                                headers.put("Authorization", auth);
                                return headers;
                            }
                            @Override
                            public String getBodyContentType() {
                                return "application/json";
                            }

                            @Override
                            public byte[] getBody() throws AuthFailureError {
                                try {
                                    return requestBody == null ? null : requestBody.getBytes();
                                } catch (Exception uee) {
                                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                    return null;
                                }
                            }};

                        toParse = false;
                        VolleySingleton.getInstance(context2).addToRequestQueue(putRequest);
                    }
                },
                //future,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("FAILURE REASON", error.getMessage());
                        responseListener.onFailure(error.getMessage());
                    }
                });
        //future);

        // Add tag to request
        request.setTag(TAG);

        // Get RequestQueue from VolleySingleton
        toParse = false;
        waitForResponse = true;
        VolleySingleton.getInstance(context).addToRequestQueue(request);
        // waitForResponse is set to false after response is set. It is set to true at the start of the sendRequest method.
        while(waitForResponse);

        try {
            waitForResponse = true;
        } catch(Exception e){

        }

    }

    public void runWebCrawler(Context context){
        //String datasourceId = "668sfsu1";
        final String url = "http://" + ip + ":8764/api/apollo/connectors/jobs/" + datasourceId;
        //String url = "http://10.143.246.93:8764/api/apollo/connectors/jobs/sfsu_id";
        final Context context2 = context;
        JsonRequest postRequestToRunCrawler = new JsonRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.i("run crawler", response);

                        try {
                            Thread.sleep(10000);                 //1000 milliseconds is one second.
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        Log.i("here", "after first sleep");

                        JsonRequest deleteRequestToStopCrawler = new JsonRequest(Request.Method.DELETE, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                    }
                                },
                                //future,
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.i("FAILURE REASON", error.getMessage());
                                        responseListener.onFailure(error.getMessage());
                                    }
                                });
                        waitForResponse = true;
                        Log.i("here", "before stop crawler");
                        VolleySingleton.getInstance(context2).addToRequestQueue(deleteRequestToStopCrawler);
                        crawlNotFinish = true;
                        //while(waitForResponse);
                        // Give it 8 seconds to stop the crawler
                        try {
                            Thread.sleep(8000);                 //1000 milliseconds is one second.
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        // added this 12:28pm
                        responseListener.onSuccess(response);
                        //while(waitForResponse);
                    }
                },
                //future,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("FAILURE REASON", error.getMessage());
                        responseListener.onFailure(error.getMessage());
                    }
                });
        waitForResponse = true;

        toParse = false;
        VolleySingleton.getInstance(context).addToRequestQueue(postRequestToRunCrawler);
        while(waitForResponse);
    }

    public void cancelAllRequests(Context context) {
        VolleySingleton.getInstance(context).cancelAllRequests(TAG);
    }

    public interface OnResponseListener {
        void onSuccess(String response);
        void onFailure(String errorMessage);
    }

    public interface VolleyCallback {
        void onSuccess(JSONObject result) throws JSONException;
        void onError(String result) throws Exception;
    }
}

