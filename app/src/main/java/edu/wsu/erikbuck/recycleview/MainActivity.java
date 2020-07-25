package edu.wsu.erikbuck.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> URLList = new ArrayList<>();
    private RecyclerView recyclerView;
    private URLAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new URLAdapter(URLList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        String fileName = "/data/data/com.example.native_activity/files/History.txt";
        try {
            FileInputStream fstream = new FileInputStream(new File(fileName));
            InputStreamReader istream = new InputStreamReader(fstream);
            BufferedReader bstream = new BufferedReader(istream);

            String line;
            while ((line = bstream.readLine()) != null) {
                URLList.add(line);
            }

        } catch (FileNotFoundException ex) {
            Log.e("MainActivity",ex.getMessage());
        } catch (IOException ex) {
            Log.e("MainActivity",ex.getMessage());
        }

        mAdapter.notifyDataSetChanged();
    }
}