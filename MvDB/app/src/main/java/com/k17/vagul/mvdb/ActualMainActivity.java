package com.k17.vagul.mvdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ActualMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_main);
        Bundle b=this.getIntent().getExtras();
        String[] array=b.getStringArray("key");
        ListAdapter myCustomView = new CustomAdapter(this,array);
        ListView mainView = (ListView) findViewById(R.id.movieContainer);
        assert mainView != null;
        mainView.setAdapter(myCustomView);
    }
}
