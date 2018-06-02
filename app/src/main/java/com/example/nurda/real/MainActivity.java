package com.example.nurda.real;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();
    }

    public void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mNames.add("Sour lemon");
        mImageUrls.add(R.drawable.eda);

        mNames.add("Perfect city");
        mImageUrls.add(R.drawable.gorod);

        mNames.add("Real Madrid home stadium");
        mImageUrls.add(R.drawable.estadio_rm);

        mNames.add("Gallery");
        mImageUrls.add(R.drawable.gallery);

        mNames.add("Besstrashnaya koshka");
        mImageUrls.add(R.drawable.koska);

        mNames.add("Notebook is everything");
        mImageUrls.add(R.drawable.notebook);

        mNames.add("Rubik's cube");
        mImageUrls.add(R.drawable.rubiks_cube);

        mNames.add("Game dice");
        mImageUrls.add(R.drawable.dice);

        initRecyclerView();
    }

    public void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init Recycler View");
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(MainActivity.this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                ArrayList<String> tempList = new ArrayList<>();
                for (String temp: mNames){
                    if (temp.toLowerCase().contains(query.toLowerCase())){
                        tempList.add(temp);
                    }
                }
                adapter = new RecyclerViewAdapter(MainActivity.this,tempList,mImageUrls);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
