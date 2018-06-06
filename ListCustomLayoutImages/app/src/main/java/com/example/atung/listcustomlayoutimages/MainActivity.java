package com.example.atung.listcustomlayoutimages;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[]items;
    String[]prices;
    String[]descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.myListView);
        items = getResources().getStringArray(R.array.items);
        prices = getResources().getStringArray(R.array.prices);
        descriptions = getResources().getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this,items,prices,descriptions);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showImageActivity = new Intent(getApplicationContext(),GallaryActivity.class);
                showImageActivity.putExtra("ITEM_ID",i);
                showImageActivity.putExtra("ITEM_ARRAY_NAME",items);
                startActivity(showImageActivity);
            }
        });


    }
}
