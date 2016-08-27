package com.example.robotics3.madtownscouting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Isaac on 6/26/2016.
 */
public class TeamListAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    private Context mContext;
    TeamRoster teams;
    String precursor;
    public TeamListAdapter(Context context, Cursor c, int flags, int pics){
        super(context, c, flags);
        mContext = context;
        if(pics == 0){
            precursor = "Matches Played: ";
        }else {
            precursor = "Pictures: ";
        }
    }



    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        teams = new TeamRoster();
        TextView teamNumberTextView = (TextView) view.findViewById(R.id.teamNumberText);
        teamNumberTextView.setText("Team " + cursor.getString(cursor.getColumnIndex("teamNumber")));
        TextView matchesPlayedTextView = (TextView) view.findViewById(R.id.matchesPlayedText);
        matchesPlayedTextView.setText(precursor + cursor.getString(cursor.getColumnIndex("matchCount")));
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // R.layout.list_row is your xml layout for each row
        cursorInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = cursorInflater.inflate(R.layout.teamslist, parent, false);
        bindView(v, context, cursor);
        return v;
    }
}
