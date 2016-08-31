package com.example.robotics3.madtownscouting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class UploadPicture extends AppCompatActivity {

    Button picUploadButton;
    ImageView picPreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_picture);
        picUploadButton = (Button) findViewById(R.id.picUploadButton);
        picPreview = (ImageView) findViewById(R.id.picUploadPreview);
    }
}
