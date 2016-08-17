package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    Button scoutingButton;
    Button teamsButton;
    Button webButton;
    Button picturesButton;
    Intent scoutingIntent;
    Intent teamIntent;
    Intent webIntent;
    Intent picturesIntent;
    SQLiteDatabase myDB = null;
    String TeamData = "TeamRoster";
    String MatchData = "MatchScouting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        scoutingButton = (Button) findViewById(R.id.scoutingButton);
        webButton = (Button) findViewById(R.id.websiteButton);
        picturesButton = (Button) findViewById(R.id.addPicturesButton);
        scoutingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoutingMenu();
            }
        });
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webMenu();
            }
        });
        picturesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picturesMenu();
            }
        });
        createDatabase();
        createMatchScoutingDatabase();
    }

    public void scoutingMenu() {
        scoutingIntent = new Intent(this, MainMenu.class);
        startActivity(scoutingIntent);
    }
    public void webMenu() {
        webIntent = new Intent(this, SendData.class);
        startActivity(webIntent);
    }
    public void picturesMenu(){
        picturesIntent = new Intent(this, PicturesMenu.class);
        startActivity(picturesIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void createDatabase() {
        try {
            myDB = this.openOrCreateDatabase("FRC", MODE_PRIVATE, null);

   /* Create a Table in the Database. */
            myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                    + TeamData
                    + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, teamNumber VARCHAR, teamName VARCHAR);");
 /*           myDB.execSQL("INSERT INTO "
                    + TeamData
                    + " (teamNumber, teamName, location)"
                    + " VALUES (1324, 'MadTown Robotics', 'Madera, Ca');");*/
            Cursor c = myDB.rawQuery("SELECT * FROM " + TeamData, null);
            if (myDB != null)
                myDB.close();
            c.close();
        } catch (SQLException e) {
            Log.e("Error", "Error", e);
        }
    }

    public void createMatchScoutingDatabase() {
        try {
            myDB = this.openOrCreateDatabase("FRC", MODE_PRIVATE, null);
            myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                    + MatchData
                    + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, matchUploaded int, teamName VARCHAR, teamNumber VARCHAR, matchtype_number int, robotNotes VARCHAR," +
                    " activeAuto int, spybotStart int, defenseBreach int, autolowBar int, autoportCullis int, autochevaldeFrise int," +
                    " autoMoat int, autoRamparts int, autodrawBridge int, autosallyPort int, autorockWall int, autoroughTerrain int, " +
                    "autohighScored int, autolowScored int, shotsFired int, highGoalsScored int, lowgoalsScored int," +
                    "lowbarCrossed int, lowbarhardCrossed int, portcullisCrossed int, portcullishardCrossed int," +
                    " chevaldefriseCrossed int, chevaldefrisehardCrossed int, moatCrossed int, moathardCrossed int," +
                    " rampartsCrossed int, rampartshardCrossed int, drawbridgeCrossed int, drawbridgehardCrossed int," +
                    " sallyportCrossed int, sallyporthardCrossed int, rockwallCrossed int, rockwallhardCrossed int," +
                    " roughterrainCrossed int, roughterrainhardCrossed int, robotChallenge int, robotClimb int, climbSpeed int, climbSuccessful int)");
            if (myDB != null)
                myDB.close();
        } catch (SQLException e) {
            Log.e("Error", "Error", e);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
