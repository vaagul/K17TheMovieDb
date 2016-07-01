package com.k17.vagul.mvdb;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.k17.vagul.network.JsonDownloader;

class CustomAdapter extends ArrayAdapter<String>{
    private final Context context;
    public CustomAdapter(Context context, String[] movieName) {

        super(context,R.layout.custom_row,movieName);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater oneRow= LayoutInflater.from(getContext());
        final View customView = oneRow.inflate(R.layout.custom_row, parent,false);
        String singleItem = getItem(position);
        TextView movieName= (TextView) customView.findViewById(R.id.movieName);
        ImageView movieImage= (ImageView) customView.findViewById(R.id.movieImage);

        JsonDownloader jsondownloader = new JsonDownloader();



        if(singleItem!=null) {
            Log.d("string",singleItem);
            movieName.setText(jsondownloader.GetName(singleItem));
            Glide.with(getContext())
                    .load(jsondownloader.GetImgUrl(singleItem))
                    .into(movieImage);
        }
        final String details = singleItem;
        customView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Intent sender= new Intent(context,SecondActivity.class);
                sender.putExtra("jsondetail",details);
                context.startActivity(sender);
            }
        });
        return customView;
    }






}





