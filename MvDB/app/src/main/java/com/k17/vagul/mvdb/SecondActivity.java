package com.k17.vagul.mvdb;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.k17.vagul.network.JsonDownloader;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String json = "";
        Intent myIntent = getIntent();
        if (myIntent.hasExtra("jsondetail"))
        {
            json=myIntent.getStringExtra("jsondetail");
        }
        final JsonDownloader jsondownloader = new JsonDownloader();
        TextView title=(TextView)findViewById(R.id.maintitle);
        TextView tagline=(TextView)findViewById(R.id.tagline);
        TextView runtime=(TextView)findViewById(R.id.runtime);
        TextView overview=(TextView)findViewById(R.id.overview);
        TextView voteavg=(TextView)findViewById(R.id.voteavg);
        TextView status=(TextView)findViewById(R.id.status);
        TextView homepage=(TextView)findViewById(R.id.homepage);
        TextView releasedate=(TextView)findViewById(R.id.releasedate);
        assert title != null;
        title.setText(jsondownloader.GetName(json));
        assert tagline != null;
        tagline.setText(jsondownloader.Gettagline(json));
        assert runtime != null;
        runtime.setText(jsondownloader.GetRunTime(json) + " Minutes");
        assert overview != null;
        overview.setText(jsondownloader.GetOverView(json));
        assert status != null;
        status.setText(jsondownloader.GetStatus(json));
        assert voteavg != null;
        voteavg.setText(jsondownloader.GetVoteAvg(json));
        assert releasedate != null;
        releasedate.setText(jsondownloader.GetReleaseDate(json));

        ImageView Backdrop =(ImageView)findViewById(R.id.backDrop);
        assert Backdrop != null;
        Glide.with(this)
                .load(jsondownloader.GetBackdrop(json))
                .into(Backdrop);

        final String jsoncopy = json;
        assert homepage != null;
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = jsondownloader.GetHomePage(jsoncopy);
                if(url.equalsIgnoreCase(""))
                {
                    Toast.makeText(SecondActivity.this,"homepage not yet created" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }
        });

    }
}
