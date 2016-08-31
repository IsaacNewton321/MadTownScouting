package com.example.robotics3.madtownscouting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PictureList extends AppCompatActivity {

    ListView picList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_list);
        picList = (ListView) findViewById(R.id.pictureListView);
    }
}
