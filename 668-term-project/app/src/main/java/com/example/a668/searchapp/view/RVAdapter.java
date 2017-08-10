package com.example.a668.searchapp.view;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by spenc on 4/20/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {

    List<Data> dataList;
    Context context;
    WebsiteRedirection redirectSearchResult;

    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        CardView card_view;
        TextView title;
        TextView description;
        TextView url;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            card_view= (CardView) itemView.findViewById(R.id.card_view_id);
            title = (TextView)itemView.findViewById(R.id.title_id);
            description = (TextView)itemView.findViewById(R.id.description_id);
            url = (TextView)itemView.findViewById(R.id.url_id);
        }

        //OnClick Listener is now here
        @Override
        public void onClick(View v) {

            redirectSearchResult = new WebsiteRedirection();
            String itemClicked = url.getText().toString();

            v.getContext().startActivity(redirectSearchResult.redirectedWebsite(itemClicked));
        }
    }

    RVAdapter(List<Data> dataList, Context context){
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return dataList!= null ? dataList.size() : 0;
    }


    //Create View
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_list, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    //Add Content to View
    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        Log.i("onBindView", "title: " + dataList.get(i).title + " | url: " + dataList.get(i).URL + "| desc: " + dataList.get(i).description + "\n");
        itemViewHolder.title.setText(dataList.get(i).title);
        itemViewHolder.url.setText(dataList.get(i).URL);
        itemViewHolder.description.setText(dataList.get(i).description);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //RecyclerView Filter method
    public void setFilter (ArrayList<Data> newList){

        dataList= new ArrayList<>();
        dataList.addAll(newList);
        notifyDataSetChanged();

    }
}

