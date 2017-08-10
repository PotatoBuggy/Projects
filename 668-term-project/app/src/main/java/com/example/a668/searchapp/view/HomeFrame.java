package com.example.a668.searchapp.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a668.searchapp.controller.JsonController;
import com.example.a668.searchapp.request.JsonRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


/**
 * Created by spenc on 4/26/2017.
 */

public class HomeFrame extends Fragment {

    View rootView;
    Button crawl;
    EditText input_url;
    URL url;
    Bundle bundleBox;
    String host;
    Handler mHandler;
    static TextView text;
    boolean wait = true;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.home_frame, container, false);
        crawl= (Button) rootView.findViewById(R.id.crawl_button_id);
        input_url=(EditText) rootView.findViewById(R.id.url_edittext_id);
        //final Context context = this.getActivity().getApplicationContext();



        final JsonController controller = new JsonController(
                new JsonController.OnResponseListener() {
                    @Override
                    public void onSuccess(String response) {
                        Log.i("search JsonController", response);
                        wait = false;
                        //Go to activity_search fragment
                        Fragment nextView= new Search();
                        nextView.setArguments(bundleBox);
                        FragmentManager fraMng= getFragmentManager();
                        FragmentTransaction fraT= fraMng.beginTransaction()
                                .replace(R.id.frame_layout_id,nextView);
                        fraT.addToBackStack(nextView.getTag());
                        fraT.commit();

                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        Log.i("\nonFailure", "onFailure\n");
                    }
                });
        final RelativeLayout layout = (RelativeLayout) rootView.findViewById(R.id.home_screen_layout);

        text = (TextView) layout.findViewById(R.id.popup);


        //text.setText("Crawling");
       Handler mHandler = new Handler() {
           @Override
           public void publish(LogRecord logRecord) {

           }

           @Override
           public void flush() {

           }

           @Override
           public void close() throws SecurityException {

           }


        };
        final Context context = this.getActivity();
        //Go to Search page
        crawl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("crawl.setOnClick", "inside HomeFrame");
                layout.setBackgroundColor(Color.GRAY);
                text.setText("Crawling...");
//                new Timer().scheduleAtFixedRate(new TimerTask() {
//                    @Override
//                    public void run() {
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                //while(wait){
////                        new Timer().scheduleAtFixedRate(new TimerTask() {
////                        @Override
////                        public void run() {
//                                if (text.getText().length() < 10) {
//                                    text.setText(text.getText() + ".");
//                                } else {
//                                    text.setText("Crawling.");
//                                }
////                            try {
////                                Thread.sleep(1000);
////                            }catch(InterruptedException e){
////                                Thread.interrupted();
////                            }
//                            }
//                        });
//                    }
//                }, 0, 500);
                //crawlLoad();
                //Take Input String
                String urlText= input_url.getText().toString();

                if(urlText.equals("")){
                    Toast.makeText(getActivity(), "Please Enter URL Before Proceed." , Toast.LENGTH_LONG)
                            .show();
                }else{

                    //Create Title for Search Page
                    if (urlText.substring(0,4).equals("http")){
                        try {
                            //Get Host Name
                            url = new URL(urlText);
                            host = url.getHost();


                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                            host= "Web Crawler";
                        }
                    }else {
                        host = urlText;
                    }
                    controller.cancelAllRequests(context);
                    controller.sendRequest(host, context, false, true);
                    //Send Host name to nextView
                    bundleBox = new Bundle();
                    bundleBox.putString("Title",host);

                    // nextUrl where the crawl will next occur
//                    RelativeLayout layout = (RelativeLayout) rootView.findViewById(R.id.home_screen_layout);
  //                  layout.setBackgroundColor(0xFF00FF00);


                    JsonRequest.nextUrl = host;
                    //View layoutForToast = inflater.inflate(R.layout.home_frame,
                      //      (ViewGroup) rootView.findViewById(R.id.home_screen_layout));
                    //Go to activity_search fragment
                }
            }
        });

        return rootView;
    }

    private void crawlLoad() {
//        RelativeLayout layout = (RelativeLayout) rootView.findViewById(R.id.home_screen_layout);
//        layout.setBackgroundColor(Color.TRANSPARENT);
//        final TextView text = (TextView) layout.findViewById(R.id.popup);
//        text.setText("Crawling");
        Timer timer = new Timer();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //String s = (String) text.getText();
                        Log.i("hre", (String) text.getText());
                        //while(wait){
//                        new Timer().scheduleAtFixedRate(new TimerTask() {
//                        @Override
//                        public void run() {
                        if (text.getText().length() == 9) {
                            //String s = (String) text.getText().toString() + ".";
                            text.setText("Crawling..");
                        } else if(text.getText().length() == 10){
                            text.setText("Crawling...");
                        } else {
                            text.setText("Crawling.");
                        }
//                            try {
//                                Thread.sleep(1000);
//                            }catch(InterruptedException e){
//                                Thread.interrupted();
//                            }
                    }
                });
            }
        }, 0, 1000);
            }
                //mHandler.obtainMessage(1).sendToTarget();

//                    }
//                });

            }


