package com.example.robotics3.madtownscouting;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

/**
 * Created by Pollo on 3/1/2016.
 */




    public class MatchResultsAdapter extends CursorAdapter {
        private LayoutInflater cursorInflater;
        private Context mContext;
            public MatchResultsAdapter(Context context, Cursor c, int flags) {
            super(context, c,flags);
            mContext = context;
        }

    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewTitle = (TextView) view.findViewById(R.id.matchtype_numberText);
        textViewTitle.setText(cursor.getString(cursor.getColumnIndex("teamName")) + " " + cursor.getString(cursor.getColumnIndex("teamNumber")) + " " + cursor.getString(cursor.getColumnIndex("matchtype_number")));
        TextView textViewAutoActive = (TextView) view.findViewById(R.id.AutoActivetextView);
        textViewAutoActive.setText(" ActiveAuto " + cursor.getString(cursor.getColumnIndex("activeAuto")));
        TextView textViewSpybotStart = (TextView) view.findViewById(R.id.SpybotStarttextView);
        textViewSpybotStart.setText(" SpybotStart " + cursor.getString(cursor.getColumnIndex("spybotStart")));
        TextView textViewDefenseBreached = (TextView) view.findViewById(R.id.DefBreachedtextView);
        textViewDefenseBreached.setText(" BreachDef " + cursor.getString(cursor.getColumnIndex("defenseBreach")));
        TextView textViewAutoLowBarCrossed = (TextView) view.findViewById(R.id.AutoLowBarCrossedtextView);
        textViewAutoLowBarCrossed.setText(" AutoLowBar Crossed " + cursor.getString(cursor.getColumnIndex("autolowBar")));
        TextView AutoPortCullisCrossedtextView = (TextView) view.findViewById(R.id.AutoPortCullisCrossedtextView);
        AutoPortCullisCrossedtextView.setText(" AutoPortCullis Crossed " + cursor.getString(cursor.getColumnIndex("autoportCullis")));
        TextView AutoChevalDeFriseCrossed = (TextView) view.findViewById(R.id.AutoChevalDeFriseCrossedtextView);
        AutoChevalDeFriseCrossed.setText(" AutoChevalDeFrise Crossed " + cursor.getString(cursor.getColumnIndex("autochevaldeFrise")));
        TextView AutoMoatCrossed = (TextView) view.findViewById(R.id.AutoMoatCrossedtextView);
        AutoMoatCrossed.setText(" AutoMoat Crossed " + cursor.getString(cursor.getColumnIndex("autoMoat")));
        TextView AutoRampartsCrossed = (TextView) view.findViewById(R.id.AutoRampartsCrossedtextView);
        AutoRampartsCrossed.setText(" AutoRamparts Crossed " + cursor.getString(cursor.getColumnIndex("autoRamparts")));
        TextView AutoDrawBridgdeCrossed = (TextView) view.findViewById(R.id.AutoDrawBridgeCrossedtextView);
        AutoDrawBridgdeCrossed.setText(" AutoDrawBridge Crossed " + cursor.getString(cursor.getColumnIndex("autodrawBridge")));
        TextView AutoSallyPortCrossed = (TextView) view.findViewById(R.id.AutoSallyPortCrossedtextView);
        AutoSallyPortCrossed.setText(" AutoSallyPort Crossed " + cursor.getString(cursor.getColumnIndex("autosallyPort")));
        TextView AutoRockWallCrossed = (TextView) view.findViewById(R.id.AutoRockWallCrossedtextView);
        AutoRockWallCrossed.setText(" AutoRockWall Crossed " + cursor.getString(cursor.getColumnIndex("autorockWall")));
        TextView AutoRoughTerrainCrossed = (TextView) view.findViewById(R.id.AutoRoughTerrainCrossedtextView);
        AutoRoughTerrainCrossed.setText(" AutoRoughTerrain Crossed " + cursor.getString(cursor.getColumnIndex("autoroughTerrain")));
        TextView AutoHightextView = (TextView) view.findViewById(R.id.AutoHightextView);
        AutoHightextView.setText(" AutoHigh Goal " + cursor.getString(cursor.getColumnIndex("autohighScored")));
        TextView AutoLowtextView = (TextView) view.findViewById(R.id.AutoLowtextView);
        AutoLowtextView.setText(" AutoLow Goal " + cursor.getString(cursor.getColumnIndex("autolowScored")));
        TextView ShotsFiredtextView = (TextView) view.findViewById(R.id.ShotsFiredtextView);
        ShotsFiredtextView.setText(" ShotsFired " + cursor.getString(cursor.getColumnIndex("shotsFired")));
        TextView textViewHighGoalsScored = (TextView) view.findViewById(R.id.HighGoalsScoredtextView);
        textViewHighGoalsScored.setText(" HighScored " + cursor.getString(cursor.getColumnIndex("highGoalsScored")));
        TextView textViewLowGoalsScored = (TextView) view.findViewById(R.id.LowGoalsScoredtextView);
        textViewLowGoalsScored.setText(" LowGoals Scored " + cursor.getString(cursor.getColumnIndex("lowgoalsScored")));
        TextView LowBarCrossedtextView = (TextView) view.findViewById(R.id.LowBarCrossedtextView);
        LowBarCrossedtextView.setText(" Lowbar Crossed " + " " + cursor.getString(cursor.getColumnIndex("lowbarCrossed")));
        TextView LowBarHardCrossedtextView = (TextView) view.findViewById(R.id.LowBarHardCrossedtextView);
        LowBarHardCrossedtextView.setText(" Lowbar Hard Crossed " + cursor.getString(cursor.getColumnIndex("lowbarhardCrossed")));
        TextView PortcullisCrossedtextView = (TextView) view.findViewById(R.id.PortcullisCrossedtextView);
        PortcullisCrossedtextView.setText(" Portcullis Crossed " + " " + cursor.getString(cursor.getColumnIndex("portcullisCrossed")));
        TextView PortCullisHardCrossedtextView = (TextView) view.findViewById(R.id.PortCullisHardCrossedtextView);
        PortCullisHardCrossedtextView.setText(" Portcullis Hard Crossed " + cursor.getString(cursor.getColumnIndex("portcullishardCrossed")));
        TextView ChevalDeFrisetextView = (TextView) view.findViewById(R.id.ChevalDeFriseCrossedtextView);
        ChevalDeFrisetextView.setText(" ChevalDeFrise Crossed " + cursor.getString(cursor.getColumnIndex("chevaldefriseCrossed")));
        TextView ChevalDeFriseHardtextView = (TextView) view.findViewById(R.id.ChevalDeFriseHardCrossedtextView);
        ChevalDeFriseHardtextView.setText(" ChevalDeFrise Hard Crossed " + cursor.getString(cursor.getColumnIndex("chevaldefrisehardCrossed")));
        TextView MoatCrossedtextView = (TextView) view.findViewById(R.id.MoatCrossedtextView);
        MoatCrossedtextView.setText(" Moat Crossed " + cursor.getString(cursor.getColumnIndex("moatCrossed")));
        TextView MoatHardCrossedtextView = (TextView) view.findViewById(R.id.MoatHardCrossedtextView);
        MoatHardCrossedtextView.setText(" Moat Hard Crossed " + cursor.getString(cursor.getColumnIndex("moathardCrossed")));
        TextView RampartsCrossedtextView = (TextView) view.findViewById(R.id.RampartsCrossedtextView);
        RampartsCrossedtextView.setText(" Ramparts Crossed " + cursor.getString(cursor.getColumnIndex("rampartsCrossed")));
        TextView RampartsHardCrossedtextView = (TextView) view.findViewById(R.id.RampartsHardCrossedtextView);
        RampartsHardCrossedtextView.setText(" Ramparts Hard Crossed " + cursor.getString(cursor.getColumnIndex("rampartshardCrossed")));
        TextView DrawBridgeCrossedtextView = (TextView) view.findViewById(R.id.DrawBridgeCrossedtextView);
        DrawBridgeCrossedtextView.setText(" Drawbridge Crossed " + cursor.getString(cursor.getColumnIndex("drawbridgeCrossed")));
        TextView DrawBridgeHardCrossedtextView = (TextView) view.findViewById(R.id.DrawBridgeHardCrossedtextView);
        DrawBridgeHardCrossedtextView.setText(" Drawbridge Hard Crossed " + cursor.getString(cursor.getColumnIndex("drawbridgehardCrossed")));
        TextView SallyPortCrossedtextView = (TextView) view.findViewById(R.id.SallyPortCrossedtextView);
        SallyPortCrossedtextView.setText(" Sallyport Crossed " + cursor.getString(cursor.getColumnIndex("sallyportCrossed")));
        TextView SallyPortHardCrossedtextView = (TextView) view.findViewById(R.id.SallyPortCrossedHardtextView);
        SallyPortHardCrossedtextView.setText(" Sallyport Hard Crossed " + cursor.getString(cursor.getColumnIndex("sallyporthardCrossed")));
        TextView RockWallCrossedtextView = (TextView) view.findViewById(R.id.RockWallCrossedtextView);
        RockWallCrossedtextView.setText(" Rockwall Crossed " + cursor.getString(cursor.getColumnIndex("rockwallCrossed")));
        TextView RockWallHardCrossedtextView = (TextView) view.findViewById(R.id.RockWallHardCrossedtextView);
        RockWallHardCrossedtextView.setText(" Rockwall Hard Crossed " + cursor.getString(cursor.getColumnIndex("rockwallhardCrossed")));
        TextView RoughTerrainCrossedtextView = (TextView) view.findViewById(R.id.RoughTerrainCrossedtextView);
        RoughTerrainCrossedtextView.setText(" Rough Terrain " + cursor.getString(cursor.getColumnIndex("roughterrainCrossed")));
        TextView RoughTerrainHardCrossedtextView = (TextView) view.findViewById(R.id.RoughTerrainHardCrossedtextView);
        RoughTerrainHardCrossedtextView.setText(" Rough Terrain Hard Crossed " + cursor.getString(cursor.getColumnIndex("roughterrainhardCrossed")));
        TextView RobotChallengetextView = (TextView) view.findViewById(R.id.RobotChallengetextView);
        RobotChallengetextView.setText(" Robot Challenge " + cursor.getString(cursor.getColumnIndex("robotChallenge")));
        TextView textViewRobotClimb = (TextView) view.findViewById(R.id.RobotClimbtextView);
        textViewRobotClimb.setText(" RobotClimb " + cursor.getString(cursor.getColumnIndex("robotClimb")));
        TextView textViewClimbSpeed = (TextView) view.findViewById(R.id.ClimbSpeedtextView);
        textViewClimbSpeed.setText(" ClimbSpeed (seconds) " + cursor.getString(cursor.getColumnIndex("climbSpeed")));
        TextView textViewClimbSuccess = (TextView) view.findViewById(R.id.ClimbSuccesstextView);
        textViewClimbSuccess.setText(" ClimbSuccess " + cursor.getString(cursor.getColumnIndex("climbSuccessful")));
        TextView RobotMatchNotestextView = (TextView) view.findViewById(R.id.RobotMatchNotestextView);
        RobotMatchNotestextView.setText(cursor.getString(cursor.getColumnIndex("robotNotes")));
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // R.layout.list_row is your xml layout for each row
        cursorInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = cursorInflater.inflate(R.layout.matchresultslist, parent, false);
        bindView(v, context, cursor);
        return v;
    }
}
