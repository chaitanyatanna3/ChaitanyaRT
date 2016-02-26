package com.example.chaitanya.chaitanyart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class ContextRT extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_gridview);
        gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(new ImageAdapter(this));
    }
}
