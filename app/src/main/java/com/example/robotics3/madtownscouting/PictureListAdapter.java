package com.example.robotics3.madtownscouting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;

/**
 * Created by robotics7 on 8/31/2016.
 */
public class PictureListAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    private Context mContext;

    public PictureListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mContext = context;
    }
    public void bindView(View view, Context context, Cursor cursor){
        try {
            ImageView picPreview = (ImageView) view.findViewById(R.id.imageView2);
            byte[] bytes = cursor.getBlob(cursor.getColumnIndex("pic1"));
            Bitmap img = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            picPreview.setImageBitmap(img);
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
    }
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // R.layout.list_row is your xml layout for each row
        cursorInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = cursorInflater.inflate(R.layout.pictureslist, parent, false);
        bindView(v, context, cursor);
        return v;
    }
}
