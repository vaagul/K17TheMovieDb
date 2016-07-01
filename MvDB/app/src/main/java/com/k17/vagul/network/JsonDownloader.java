package com.k17.vagul.network;

import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class JsonDownloader {

    public String GetJson(String URL) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();
        Call call = client.newCall(request);
        Response response;
        String jsonData = null;
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                jsonData = response.body().string();
            } else {
                jsonData = null;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    public String GetName(String stringjson)
    {
        String name= "";
        try {
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("original_title");
            Log.d("jsonstring","stringjson");
        }
        catch(JSONException ignored){
        }
        return name;
    }

    public String GetImgUrl(String stringjson)
    {
        String name= "";
        try{
            JSONObject json = new JSONObject(stringjson);
            String posterPath = json.optString("poster_path");
            name="http://image.tmdb.org/t/p/w185/"+posterPath;
        }
        catch (JSONException ignored) {
        }
        return name;
    }

    public String GetBackdrop(String stringJson)
    {
        String name= "";
        try{
            JSONObject json = new JSONObject(stringJson);
            String posterPath = json.optString("backdrop_path");
            name="http://image.tmdb.org/t/p/w780/"+posterPath;
        }
        catch (JSONException ignored) {
        }
        return name;
    }

    public String Gettagline(String stringjson)
    {
        String name= "";
        try {
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("tagline");
        }
        catch(JSONException ignored){
        }
        return name;
    }

    public String GetRunTime(String stringjson)
    {
        String name= "";
        try {
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("runtime");
        }
        catch(JSONException ignored){
        }
        return name;
    }

    public String GetOverView(String stringjson)
    {
        String name= "";
        try {
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("overview");
        }
        catch(JSONException ignored){
        }
        return name;
    }

    public String GetVoteAvg(String stringjson) {
        String name = "";
        try {
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("vote_average");
        }
        catch (JSONException ignored) {
        }
        return name;
    }

    public String GetStatus(String stringjson)
    {
        String name = "";
        try{
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("status");
        }
        catch (JSONException ignored) {
        }
        return name;
    }

    public String GetHomePage(String stringjson)
    {
        String name = "";
        try{
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("homepage");
        } catch (JSONException ignored) {
        }
        return name;
    }

    public String GetReleaseDate(String stringjson)
    {
        String name = "";
        try{
            JSONObject json = new JSONObject(stringjson);
            name = json.optString("release_date");
        } catch (JSONException ignored) {
        }
        return name;
    }

}
