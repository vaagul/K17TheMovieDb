package com.k17.vagul.mvdb;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.k17.vagul.network.BackgroundDownloader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isNetworkAvailable()) {
            noInternetAlertMessage(this);

        }
        else {
            BackgroundDownloader getjson = new BackgroundDownloader(this, ActualMainActivity.class);
            getjson.execute();
        }

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void noInternetAlertMessage(Activity activity) {
        NoInternetConnectionDialog dialog = new NoInternetConnectionDialog();
        dialog.setCancelable(false);
        //dialog.
        dialog.show(getFragmentManager(), "no_internet_error_dialog");
        //dialog.s
        this.setFinishOnTouchOutside(false);

    }



}

