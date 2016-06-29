package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoutingMenu extends AppCompatActivity {
    Button matchresultsButton;
    Button savedataButton;
    TextView teamnumberText;
    TextView teamnameText;
    TextView matchtype_numberText;
    Bundle bundle;
    String teamNumber;
    String teamName;
    int matchtype_number;
    String robotNotes;
    SQLiteDatabase myDB = null;
    public static final String KEY_TEAMNAME = "teamName";
    public static final String KEY_TEAMNUMBER = "teamNumber";
    public static final String KEY_MATCHTYPENUMBER = "mathctype_number";
    public static final String KEY_ROBOTNOTES = "robotNotes";
    int autoPeriodActivtated = 0;
    int spybotstart = 0;
    int defenseBreached = 0;
    int autolowBar = 0;
    int autoportCullis = 0;
    int autochevaldeFrise = 0;
    int autoMoat = 0;
    int autoRamparts = 0;
    int autodrawBridge = 0;
    int autosallyPort = 0;
    int autorockWall = 0;
    int autoroughTerrain = 0;
    int autohighScored = 0;
    int autolowScored = 0;
    int shotsAmount = 0;
    int shotsScored = 0;
    int lowgoalsScored = 0;
    int lowbarCrossed = 0;
    int lowbarhardCrossed = 0;
    int portcullisCrossed = 0;
    int portcullishardCrossed = 0;
    int chevaldefriseCrossed = 0;
    int chevaldefrisehardCrossed = 0;
    int moatCrossed = 0;
    int moathardCrossed = 0;
    int rampartsCrossed = 0;
    int rampartshardCrossed = 0;
    int drawbridgeCrossed = 0;
    int drawbridgehardCrossed = 0;
    int sallyportCrossed = 0;
    int sallyporthardCrossed = 0;
    int rockwallCrossed = 0;
    int rockwallhardCrossed = 0;
    int roughterrainCrossed = 0;
    int roughterrainhardCrossed = 0;
    int robotChallenge = 0;
    int robotClimb = 0;
    int successfulclimb = 0;
    int climbSpeed = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_scouting_menu);
        bundle = getIntent().getExtras();
        teamnumberText = (TextView)findViewById(R.id.teamnumberText);
        teamnameText = (TextView)findViewById(R.id.teamnameText);
        matchtype_numberText = (TextView)findViewById(R.id.matchtype_numberText);
        matchresultsButton = (Button) findViewById(R.id.matchsresultsButton);
        savedataButton = (Button)findViewById(R.id.savedataButton);
        matchresultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchresultsScreen();
            }
        });
        savedataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        teamnameText.setText(bundle.getString("TEAMNAME"));
        teamName = bundle.getString("TEAMNAME");
        teamnumberText.setText(bundle.getString("TEAMNUMBER"));
        teamNumber = bundle.getString("TEAMNUMBER");
        matchtype_numberText.setText(String.valueOf(bundle.getInt("MATCHTYPENUMBER")));
        matchtype_number = bundle.getInt("MATCHTYPENUMBER");
        robotNotes = bundle.getString("ROBOTNOTES");
    }

    public void saveData(){
        Intent getData = getIntent();
        Bundle bundle = getData.getExtras();
        teamName = bundle.getString("TEAMNAME");
        teamNumber = bundle.getString("TEAMNUMBER");
        matchtype_number = bundle.getInt("MATCHTYPENUMBER", 0);
        robotNotes = bundle.getString("ROBOTNOTES");

        robotNotes = robotNotes.replace("'", "");

        autoPeriodActivtated = bundle.getInt("AUTO");
        spybotstart = bundle.getInt("SPYBOT");
        defenseBreached = bundle.getInt("BREACHED");
        autolowBar = bundle.getInt("AUTO_LOWBAR");
        autoportCullis = bundle.getInt("AUTO_PORTCULLIS");
        autochevaldeFrise = bundle.getInt("AUTO_CDF");
        autoMoat = bundle.getInt("AUTO_MOAT");
        autoRamparts = bundle.getInt("AUTO_RAMPARTS");
        autodrawBridge = bundle.getInt("AUTO_DRAWBRIDGE");
        autosallyPort = bundle.getInt("AUTO_SALLYPORT");
        autorockWall = bundle.getInt("AUTO_ROCKWALL");
        autoroughTerrain = bundle.getInt("AUTO_ROUGHTERRAIN");
        autohighScored = bundle.getInt("HIGH");
        autolowScored = bundle.getInt("LOW");
        shotsAmount = bundle.getInt("SHOTS_AMOUNT");
        shotsScored = bundle.getInt("SHOTS_SCORED");
        lowgoalsScored = bundle.getInt("LOWGOALS_SCORED");
        lowbarCrossed = bundle.getInt("LOWBAR");
        lowbarhardCrossed = bundle.getInt("HARDLOWBAR");
        portcullisCrossed = bundle.getInt("PORTCULLIS");
        portcullishardCrossed = bundle.getInt("HARDPORTCULLIS");
        chevaldefriseCrossed = bundle.getInt("CHEVALDEFRISE");
        chevaldefrisehardCrossed = bundle.getInt("HARDCHEVALDEFRISE");
        moatCrossed = bundle.getInt("MOAT");
        moathardCrossed = bundle.getInt("HARDMOAT");
        rampartsCrossed = bundle.getInt("RAMPARTS");
        rampartshardCrossed = bundle.getInt("HARDRAMPARTS");
        drawbridgeCrossed = bundle.getInt("DRAWBRIDGE");
        drawbridgehardCrossed = bundle.getInt("HARDDRAWBRIDGE");
        sallyportCrossed = bundle.getInt("SALLYPORT");
        sallyporthardCrossed = bundle.getInt("HARDSALLYPORT");
        rockwallCrossed = bundle.getInt("ROCKWALL");
        rockwallhardCrossed = bundle.getInt("HARDROCKWALL");
        roughterrainCrossed = bundle.getInt("ROUGHTERRAIN");
        roughterrainhardCrossed = bundle.getInt("HARDROUGHTERRAIN");
        robotChallenge = bundle.getInt("CHALLENGE");
        robotClimb = bundle.getInt("ROBOT_CLIMBING");
        climbSpeed = bundle.getInt("CLIMBING_SPEED");
        successfulclimb = bundle.getInt("CLIMB_SUCCESS");


        try {
           myDB = this.openOrCreateDatabase("FRC", MODE_PRIVATE, null);
          /*  Cursor c = myDB.rawQuery("SELECT teamNumber FROM TeamRoster WHERE teamNumber ='" + teamNumber + "'", null);
            if (c.getCount() > 0) {
                System.out.println("Exists");
            }else {
                myDB.execSQL("INSERT INTO TeamRoster (teamNumber,teamName) VALUES ('" + teamNumber + "','" + teamName + "')");
            } */
                myDB.execSQL("INSERT INTO MatchScouting (teamName, teamNumber, matchtype_number, robotNotes, activeAuto, spybotStart, defenseBreach, autolowBar, " +
                        "autoportCullis, autochevaldeFrise, autoMoat, autoRamparts, autodrawBridge, autosallyPort, autorockWall, autoroughTerrain," +
                        "autohighScored, autolowScored, shotsFired, highGoalsScored, lowgoalsScored," +
                        " lowbarCrossed, lowbarhardCrossed, portcullisCrossed, portcullishardCrossed," +
                        " chevaldefriseCrossed, chevaldefrisehardCrossed, moatCrossed, moathardCrossed," +
                        " rampartsCrossed, rampartshardCrossed, drawbridgeCrossed, drawbridgehardCrossed," +
                        " sallyportCrossed, sallyporthardCrossed, rockwallCrossed, rockwallhardCrossed," +
                        " roughterrainCrossed, roughterrainhardCrossed, robotChallenge, robotClimb," +
                        "climbSpeed, climbSuccessful) VALUES ('" + teamName + "','" + teamNumber + "'," + matchtype_number + ",'" + robotNotes + "'," +
                        autoPeriodActivtated + "," + spybotstart + "," + defenseBreached + "," + autolowBar + "," + autoportCullis + "," + autochevaldeFrise +
                        "," + autoMoat + "," + autoRamparts + "," + autodrawBridge + "," + autosallyPort + "," +
                        autorockWall + "," + autoroughTerrain + "," + autohighScored + "," + autolowScored + "," + shotsAmount + "," + shotsScored + ","
                        + lowgoalsScored + "," + lowbarCrossed + "," + lowbarhardCrossed + "," + portcullisCrossed + "," + portcullishardCrossed + "," + chevaldefriseCrossed + "," + chevaldefrisehardCrossed +
                        "," + moatCrossed + "," + moathardCrossed + "," + rampartsCrossed + "," + rampartshardCrossed + "," + drawbridgeCrossed + "," +
                        drawbridgehardCrossed + "," + sallyportCrossed + "," + sallyporthardCrossed +
                        "," + rockwallCrossed + "," + rockwallhardCrossed + "," + roughterrainCrossed + "," + roughterrainhardCrossed +
                        "," + robotChallenge + "," + robotClimb + "," + climbSpeed + "," + successfulclimb + ")");
            myDB.close();
          //  c.close();
        }catch (SQLException e){
            System.out.print(e);
        }
    }
    public void matchresultsScreen() {
        myDB = this.openOrCreateDatabase("FRC", MODE_PRIVATE, null);
        Cursor c = myDB.rawQuery("SELECT matchtype_number, _id FROM MatchScouting ORDER BY _id desc LIMIT 1", null );
        int id = Integer.valueOf(c.getString(c.getColumnIndex("_id")));
        c.close();
        myDB.close();
        Intent matchsresultsActivity = new Intent(this, MatchResults.class);
        matchsresultsActivity.putExtra("MATCH_NUMBER", matchtype_number);
        matchsresultsActivity.putExtra("ID", id);
        startActivity(matchsresultsActivity);
    }
}

