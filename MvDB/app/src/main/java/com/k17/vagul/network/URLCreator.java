package com.k17.vagul.network;
public class URLCreator {
    String URL;
    public URLCreator(String id) {
        URL = "https://api.themoviedb.org/3/movie/"+id+"?api_key=c718e833cb7157193dd13f6094627734";
    }
    public String GetUrl()
    {
        return URL;
    }

}
