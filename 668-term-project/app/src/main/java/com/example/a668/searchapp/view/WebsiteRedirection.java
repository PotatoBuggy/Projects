package com.example.a668.searchapp.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;

/**
 * Created by adisonlee on 4/18/17.
 */

public class WebsiteRedirection extends Fragment
{

    public Intent redirectedWebsite(String searchResult)
    {
        Intent browserIntent;

        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(searchResult));
        return browserIntent;
    }

}
