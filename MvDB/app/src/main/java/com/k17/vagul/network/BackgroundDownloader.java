package com.k17.vagul.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.k17.vagul.mvdb.MainActivity;

public class BackgroundDownloader extends AsyncTask<Void,Integer, Void> {

    private Context context;
    private Class classToLoad;
    private ProgressDialog dialog;

    String[] name={"314","561","272","752","1452","155","13183","34813","20533","44912","49026","49521","209112","297761","297762","141052"};
    String[] urls = new String[16];

    int i = 0;

    public BackgroundDownloader(MainActivity ctx, Class c) {
        context=ctx;
        classToLoad=c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog = new ProgressDialog(context);
        dialog.setMessage("Fetching data from the internet...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.show();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (String id : name) {

            URLCreator createurl = new URLCreator(id);
            String url = createurl.GetUrl();
            JsonDownloader jsondownloader = new JsonDownloader();
            urls[i]=jsondownloader.GetJson(url);
            i++;

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        dialog.dismiss();
        Bundle b=new Bundle();
        b.putStringArray("key", urls);
        Intent i = new Intent(context, classToLoad);
        i.putExtras(b);
        context.startActivity(i);
        //context.finish();
    }


}

