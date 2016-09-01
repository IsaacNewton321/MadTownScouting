package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class UploadPicture extends AppCompatActivity {

    Button picUploadButton;
    ImageView picPreview;
    SQLiteDatabase myDB = null;
    Cursor c;
    String teamNumber;
    byte[] bytes;
    Bitmap bp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_picture);
        picUploadButton = (Button) findViewById(R.id.picUploadButton);
        picPreview = (ImageView) findViewById(R.id.picUploadPreview);
        Intent intent = getIntent();
        teamNumber = intent.getStringExtra("TEAM_NUMBER");
        myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
        c = myDB.rawQuery("SELECT * FROM TeamPictures WHERE teamNumber = " + teamNumber, null);
        c.moveToFirst();
        try {
            bytes = c.getBlob(c.getColumnIndexOrThrow("pic1"));
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
        bp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        picPreview.setImageBitmap(bp);
    }
}
