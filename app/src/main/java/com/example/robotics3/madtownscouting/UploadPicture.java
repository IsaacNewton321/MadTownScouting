package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
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
    String id;
    String pathToPic;
    Bitmap bp;
    ExifInterface ei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_picture);
        picUploadButton = (Button) findViewById(R.id.picUploadButton);
        picPreview = (ImageView) findViewById(R.id.picUploadPreview);
        String[] columns = new String[]{
                "_id",
                "teamNumber",
                "pic1"
        };
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
        c = myDB.query("TeamPictures", columns, "_id = ?", new String[]{id}, null, null, null);
        c.moveToFirst();
        try {
            if(c.getCount() > 0) {
                pathToPic = c.getString(c.getColumnIndex("pic1"));
                bp = BitmapFactory.decodeFile(pathToPic);
                ei = new ExifInterface(pathToPic);
            }
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,6);
        switch(orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                bp = rotateImage(bp, 90);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                bp = rotateImage(bp, 180);
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                bp = rotateImage(bp, 270);
                break;
            case ExifInterface.ORIENTATION_NORMAL:
            default:
                break;
        }

        picPreview.setImageBitmap(bp);
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix,
                true);
    }
}
