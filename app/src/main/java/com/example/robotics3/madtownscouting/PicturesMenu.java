package com.example.robotics3.madtownscouting;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PicturesMenu extends AppCompatActivity {
    Button cameraButton;
    Button cameraRoll;
    Button savePictureButton;
    ImageButton rotateBtn;
    ImageView img;
    Bitmap bp = null;
    EditText teamNumberEnter;
    int width;
    int height;
    String teamNumber;
    SQLiteDatabase myDB = null;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures_menu);
        cameraButton = (Button) findViewById(R.id.camButton);
        cameraRoll = (Button) findViewById(R.id.cameraRollButton);
        savePictureButton = (Button) findViewById(R.id.savePicButton);
        rotateBtn = (ImageButton) findViewById(R.id.imageButton);
        img = (ImageView) findViewById(R.id.imageView);
        teamNumberEnter = (EditText) findViewById(R.id.photoNumberEditText);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        if(savedInstanceState != null){
            bp = BitmapFactory.decodeByteArray(savedInstanceState.getByteArray("bp"), 0, savedInstanceState.getByteArray("bp").length);
            img.setImageBitmap(bp);
        }

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessCamera();
            }
        });
        cameraRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraRollOpen();
            }
        });
        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bp != null){
                    bp = rotateImage(bp, 90);
                    img.setImageBitmap(bp);
                }
            }
        });
        savePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePic();
            }
        });
    }

    public void accessCamera(){
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    public void cameraRollOpen(){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String th = pictureDirectory.getPath();
        Uri data = Uri.parse(th);
        photoPickerIntent.setDataAndType(data, "image/*");
        startActivityForResult(photoPickerIntent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK) {
            getLastImage();
        }else if(requestCode == 1 && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            String path = imageUri.getPath();
            InputStream inputStream;
            try {
                inputStream = getContentResolver().openInputStream(imageUri);
                bp = BitmapFactory.decodeStream(inputStream);
                ExifInterface ei = new ExifInterface(path);
                int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,6);
                switch(orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        rotateImage(bp, 90);
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        rotateImage(bp, 180);
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        rotateImage(bp, 270);
                        break;
                    case ExifInterface.ORIENTATION_NORMAL:
                    default:
                        break;
                }
                img.setImageBitmap(bp);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(bp != null) {
            byte[] bytes = bitmapToByteArray();
            outState.putByteArray("bp", bytes);
        }
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix,
                true);
    }
    public void getLastImage(){
        String[] projection = new String[]{
    MediaStore.Images.ImageColumns._ID,
    MediaStore.Images.ImageColumns.DATA,
    MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
    MediaStore.Images.ImageColumns.DATE_TAKEN,
    MediaStore.Images.ImageColumns.MIME_TYPE
    };
final Cursor cursor = getContentResolver()
        .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, 
               null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");
               
    if (cursor.moveToFirst()) {
    String imageLocation = cursor.getString(1);
    File imageFile = new File(imageLocation);
    if (imageFile.exists()) {   // TODO: is there a better way to do this?
        bp = BitmapFactory.decodeFile(imageLocation);
        img.setImageBitmap(bp);
    }
} 
    }

    public void savePic(){
        teamNumber = teamNumberEnter.getText().toString();
        ContentValues args = new ContentValues();
        byte[] bytes = bitmapToByteArray();
        if(bytes != null) {
            myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);

                args.put("teamNumber", teamNumber);
                args.put("pic1", bytes);
                myDB.insert("TeamPictures", null, args);
            myDB.close();
            Toast.makeText(getApplicationContext(), "Saved Picture!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Select a picture to save!", Toast.LENGTH_SHORT).show();
        }
    }
    public byte[] bitmapToByteArray(){
        byte[] byteArray = null;
        if(bp != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();
        }
        return byteArray;
    }
}
