package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity {
    EditText searchBox;
    Button webButton;
    Button picturesButton;
    Button viewPicsButton;
    Intent webIntent;
    Intent picturesIntent;
    Intent galleryIntent;
    SQLiteDatabase myDB;
    String MatchData = "MatchScouting";
    String PicData = "TeamPictures";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button teamsButton = (Button)findViewById(R.id.teamsButton);
        Button scoutButton = (Button)findViewById(R.id.scoutButton);
        searchBox = (EditText)findViewById(R.id.searchField);
        Button enterSearch = (Button)findViewById(R.id.enterSearchButton);
        webButton = (Button) findViewById(R.id.websiteButton);
        picturesButton = (Button) findViewById(R.id.addPicturesButton);
        viewPicsButton = (Button) findViewById(R.id.viewPicsButton);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        teamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadteamRosterScreen();
            }
        });

        scoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadselectteamScreen();
            }
        });
        enterSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search();
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
        viewPicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gallery();
            }
        });
        createMatchScoutingDatabase();
        createPicturesDatabase();
    }

    public void loadteamRosterScreen(){
        Intent scoutingScreen = new Intent(this,TeamRoster.class);
        startActivity(scoutingScreen);
    }

    public void loadselectteamScreen(){
        Intent selectteamScreen = new Intent(this,SelectTeam.class);
        startActivity(selectteamScreen);
    }
    public void Search(){
        Intent sendData = new Intent(this, SendData.class);
        sendData.putExtra("SEARCH", searchBox.getText().toString());
        startActivity(sendData);
    }

    public void webMenu() {
        webIntent = new Intent(this, SendData.class);
        startActivity(webIntent);
    }
    public void picturesMenu(){
        picturesIntent = new Intent(this, PicturesMenu.class);
        startActivity(picturesIntent);
    }

    public void gallery(){
        galleryIntent = new Intent(this, TeamPictureSelection.class);
        startActivity(galleryIntent);
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
    public void createPicturesDatabase(){
        try{
            myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
            myDB.execSQL("CREATE TABLE IF NOT EXISTS " + PicData + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, teamNumber int, pic1 BLOB)");
            if (myDB != null)
                myDB.close();
        } catch (SQLException e) {
            Log.e("Error", "Error", e);
        }
    }
}
