package com.example.robotics3.madtownscouting;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.robotics3.madtownscouting.R;

public class EditScreen extends AppCompatActivity {
EditText teamNameEnterText;
EditText teamNumberEnterText;
EditText matchNumberEnterText;
EditText activeAutoEnterText;
EditText spyBotStartEnterText;
EditText defenseBreachedEnterText;
EditText autoLowBarEnterText;
EditText autoPortcullisEnterText;
EditText autoChevalEnterText;
EditText autoMoatEnterText;
EditText autoRampartsEnterText;
EditText autoDrawBridgeEnterText;
EditText autoSallyEnterText;
EditText autoRockWallEnterText;
EditText autoRoughTerrainEnterText;
EditText autoHighGoalEnterText;
EditText autoLowGoalEnterText;
EditText shotsFiredEnterText;
EditText highGoalsScoredEnterText;
EditText lowGoalsScoredEnterText;
EditText lowBarCrossedEnterText;
EditText lowBarHardEnterText;
EditText portCullisCrossedEnterText;
EditText portCullisHardEnterText;
EditText chevalEnterText;
EditText chevalHardEnterText;
EditText moatCrossedEnterText;
EditText moatHardEnterText;
EditText rampartsCrossedEnterText;
EditText rampartsHardEnterText;
EditText drawbridgeCrossedEnterText;
EditText drawbridgeHardEnterText;
EditText sallyCrossedEnterText;
EditText sallyHardEnterText;
EditText rockwallCrossedEnterText;
EditText rockwallHardEnterText;
EditText roughTerrainCrossedEnterText;
EditText roughTerrainHardEnterText;
EditText robotChallengeEnterText;
EditText robotClimbEnterText;
EditText climbSpeedEnterText;
EditText climbSuccessEnterText;
EditText notesEnterText;

Button confirmEditsButton;

String tNumber;
String mNumber;

SQLiteDatabase myDB = null;
Cursor c;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
        
        teamNameEnterText = (EditText)findViewById(R.id.teamNameEnterText);
        teamNumberEnterText = (EditText)findViewById(R.id.teamNumberEnterText);
        matchNumberEnterText = (EditText)findViewById(R.id.matchNumberEnterText);
        activeAutoEnterText = (EditText)findViewById(R.id.activeAutoEnterText);
        spyBotStartEnterText = (EditText)findViewById(R.id.spyBotStartEnterText);
        defenseBreachedEnterText = (EditText)findViewById(R.id.defBreachedEnterText);
        autoLowBarEnterText = (EditText)findViewById(R.id.autoLowBarEnterText);
        autoPortcullisEnterText = (EditText)findViewById(R.id.autoPortCullisEnterText);
        autoChevalEnterText = (EditText)findViewById(R.id.autoChevalEnterText);
        autoMoatEnterText = (EditText)findViewById(R.id.autoMoatEnterText);
        autoRampartsEnterText = (EditText)findViewById(R.id.autoRampartsEnterText);
        autoDrawBridgeEnterText = (EditText)findViewById(R.id.autoDrawBridgeEnterText);
        autoSallyEnterText = (EditText)findViewById(R.id.autoSallyEnterText);
        autoRockWallEnterText = (EditText)findViewById(R.id.autoRockWallEnterText);
        autoRoughTerrainEnterText = (EditText)findViewById(R.id.autoRoughTerrainEnterText);
        autoHighGoalEnterText = (EditText)findViewById(R.id.autoHighGoalEnterText);
        autoLowGoalEnterText = (EditText)findViewById(R.id.autoLowGoalEnterText);
        shotsFiredEnterText = (EditText)findViewById(R.id.shotsFiredEnterText);
        highGoalsScoredEnterText = (EditText)findViewById(R.id.highGoalsScoredEnterText);
        lowGoalsScoredEnterText = (EditText)findViewById(R.id.lowGoalsScoredEnterText);
        lowBarCrossedEnterText = (EditText)findViewById(R.id.lowBarCrossedEnterText);
        lowBarHardEnterText = (EditText)findViewById(R.id.lowBarHardEnterText);
        portCullisCrossedEnterText = (EditText)findViewById(R.id.portCullisCrossedEnterText);
        portCullisHardEnterText = (EditText)findViewById(R.id.portCullisHardEnterText);
        chevalEnterText = (EditText)findViewById(R.id.chevalEnterText);
        chevalHardEnterText = (EditText)findViewById(R.id.chevalHardEnterText);
        moatCrossedEnterText = (EditText)findViewById(R.id.moatCrossedEnterText);
        moatHardEnterText = (EditText)findViewById(R.id.moatHardEnterText);
        rampartsCrossedEnterText = (EditText)findViewById(R.id.rampartsCrossedEnterText);
        rampartsHardEnterText = (EditText)findViewById(R.id.rampartsHardEnterText);
        drawbridgeCrossedEnterText = (EditText)findViewById(R.id.drawbridgeCrossedEnterText);
        drawbridgeHardEnterText = (EditText)findViewById(R.id.drawbridgeHardEnterText);
        sallyCrossedEnterText = (EditText)findViewById(R.id.sallyCrossedEnterText);
        sallyHardEnterText = (EditText)findViewById(R.id.sallyHardEnterText);
        rockwallCrossedEnterText = (EditText)findViewById(R.id.rockwallCrossedEnterText);
        rockwallHardEnterText = (EditText)findViewById(R.id.rockwallHardEnterText);
        roughTerrainCrossedEnterText = (EditText)findViewById(R.id.roughTerrainCrossedEnterText);
        roughTerrainHardEnterText = (EditText)findViewById(R.id.roughTerrainHardEnterText);
        robotChallengeEnterText = (EditText)findViewById(R.id.robotChallengeEnterText);
        robotClimbEnterText = (EditText)findViewById(R.id.robotClimbEnterText);
        climbSpeedEnterText = (EditText)findViewById(R.id.climbSpeedEnterText);
        climbSuccessEnterText = (EditText)findViewById(R.id.climbSuccessEnterText);
        notesEnterText = (EditText)findViewById(R.id.notesEnterText);
        
        confirmEditsButton = (Button)findViewById(R.id.confirmEditsButton);
        
        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
        c = myDB.rawQuery("SELECT * FROM MatchScouting WHERE _id =" + id, null);
        c.moveToFirst();
        int i = c.getCount();
        if(i > 0){
            teamNameEnterText.setText(c.getString(c.getColumnIndex("teamName")), TextView.BufferType.EDITABLE);
            teamNumberEnterText.setText(c.getString(c.getColumnIndex("teamNumber")), TextView.BufferType.EDITABLE);
            matchNumberEnterText.setText(c.getString(c.getColumnIndex("matchtype_number")), TextView.BufferType.EDITABLE);
            activeAutoEnterText.setText(c.getString(c.getColumnIndex("activeAuto")), TextView.BufferType.EDITABLE);
            spyBotStartEnterText.setText(c.getString(c.getColumnIndex("spybotStart")), TextView.BufferType.EDITABLE);
            defenseBreachedEnterText.setText(c.getString(c.getColumnIndex("defenseBreach")), TextView.BufferType.EDITABLE);
            autoLowBarEnterText.setText(c.getString(c.getColumnIndex("autolowBar")), TextView.BufferType.EDITABLE);
            autoPortcullisEnterText.setText(c.getString(c.getColumnIndex("autoportCullis")), TextView.BufferType.EDITABLE);
            autoChevalEnterText.setText(c.getString(c.getColumnIndex("autochevaldeFrise")), TextView.BufferType.EDITABLE);
            autoMoatEnterText.setText(c.getString(c.getColumnIndex("autoMoat")), TextView.BufferType.EDITABLE);
            autoRampartsEnterText.setText(c.getString(c.getColumnIndex("autoRamparts")), TextView.BufferType.EDITABLE);
            autoDrawBridgeEnterText.setText(c.getString(c.getColumnIndex("autodrawBridge")), TextView.BufferType.EDITABLE);
            autoSallyEnterText.setText(c.getString(c.getColumnIndex("autosallyPort")), TextView.BufferType.EDITABLE);
            autoRockWallEnterText.setText(c.getString(c.getColumnIndex("autorockWall")), TextView.BufferType.EDITABLE);
            autoRoughTerrainEnterText.setText(c.getString(c.getColumnIndex("autoroughTerrain")), TextView.BufferType.EDITABLE);
            autoHighGoalEnterText.setText(c.getString(c.getColumnIndex("autohighScored")), TextView.BufferType.EDITABLE);
            autoLowGoalEnterText.setText(c.getString(c.getColumnIndex("autolowScored")), TextView.BufferType.EDITABLE);
            shotsFiredEnterText.setText(c.getString(c.getColumnIndex("shotsFired")), TextView.BufferType.EDITABLE);
            highGoalsScoredEnterText.setText(c.getString(c.getColumnIndex("highGoalsScored")), TextView.BufferType.EDITABLE);
            lowGoalsScoredEnterText.setText(c.getString(c.getColumnIndex("lowgoalsScored")), TextView.BufferType.EDITABLE);
            lowBarCrossedEnterText.setText(c.getString(c.getColumnIndex("lowbarCrossed")), TextView.BufferType.EDITABLE);
            lowBarHardEnterText.setText(c.getString(c.getColumnIndex("lowbarhardCrossed")), TextView.BufferType.EDITABLE);
            portCullisCrossedEnterText.setText(c.getString(c.getColumnIndex("portcullisCrossed")), TextView.BufferType.EDITABLE);
            portCullisHardEnterText.setText(c.getString(c.getColumnIndex("portcullishardCrossed")), TextView.BufferType.EDITABLE);
            chevalEnterText.setText(c.getString(c.getColumnIndex("chevaldefriseCrossed")), TextView.BufferType.EDITABLE);
            chevalHardEnterText.setText(c.getString(c.getColumnIndex("chevaldefrisehardCrossed")), TextView.BufferType.EDITABLE);
            moatCrossedEnterText.setText(c.getString(c.getColumnIndex("moatCrossed")), TextView.BufferType.EDITABLE);
            moatHardEnterText.setText(c.getString(c.getColumnIndex("moathardCrossed")), TextView.BufferType.EDITABLE);
            rampartsCrossedEnterText.setText(c.getString(c.getColumnIndex("rampartsCrossed")), TextView.BufferType.EDITABLE);
            rampartsHardEnterText.setText(c.getString(c.getColumnIndex("rampartshardCrossed")), TextView.BufferType.EDITABLE);
            drawbridgeCrossedEnterText.setText(c.getString(c.getColumnIndex("drawbridgeCrossed")), TextView.BufferType.EDITABLE);
            drawbridgeHardEnterText.setText(c.getString(c.getColumnIndex("drawbridgehardCrossed")), TextView.BufferType.EDITABLE);
            sallyCrossedEnterText.setText(c.getString(c.getColumnIndex("sallyportCrossed")), TextView.BufferType.EDITABLE);
            sallyHardEnterText.setText(c.getString(c.getColumnIndex("sallyporthardCrossed")), TextView.BufferType.EDITABLE);
            rockwallCrossedEnterText.setText(c.getString(c.getColumnIndex("rockwallCrossed")), TextView.BufferType.EDITABLE);
            rockwallHardEnterText.setText(c.getString(c.getColumnIndex("rockwallhardCrossed")), TextView.BufferType.EDITABLE);
            roughTerrainCrossedEnterText.setText(c.getString(c.getColumnIndex("roughterrainCrossed")), TextView.BufferType.EDITABLE);
            roughTerrainHardEnterText.setText(c.getString(c.getColumnIndex("roughterrainhardCrossed")), TextView.BufferType.EDITABLE);
            robotChallengeEnterText.setText(c.getString(c.getColumnIndex("robotChallenge")), TextView.BufferType.EDITABLE);
            robotClimbEnterText.setText(c.getString(c.getColumnIndex("robotClimb")), TextView.BufferType.EDITABLE);
            climbSpeedEnterText.setText(c.getString(c.getColumnIndex("climbSpeed")), TextView.BufferType.EDITABLE);
            climbSuccessEnterText.setText(c.getString(c.getColumnIndex("climbSuccessful")), TextView.BufferType.EDITABLE);
            notesEnterText.setText(c.getString(c.getColumnIndex("robotNotes")), TextView.BufferType.EDITABLE);
        }
        c.close();
        myDB.close();
        confirmEditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeData();
            }
        });
    }
    public void changeData(){
        try {
            myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
            String notes = notesEnterText.getText().toString();
            notes = notes.replace("'", "\'");
            myDB.execSQL("UPDATE MatchScouting SET teamName = '" + teamNameEnterText.getText().toString() + "', teamNumber = '" + teamNumberEnterText.getText().toString() +
                    "', matchtype_number = " + matchNumberEnterText.getText().toString() + ", activeAuto = " + activeAutoEnterText.getText().toString() + ", spybotStart = " +
                    spyBotStartEnterText.getText().toString() + ", defenseBreach = " + defenseBreachedEnterText.getText().toString() + ", autolowBar = " + autoLowBarEnterText.getText().toString() +
                    ", autoportCullis = " + autoPortcullisEnterText.getText().toString() + ", autochevaldeFrise = " + autoChevalEnterText.getText().toString() + ", autoMoat = " +
                    autoMoatEnterText.getText().toString() + ", autoRamparts = " + autoRampartsEnterText.getText().toString() + ", autodrawBridge = " + autoDrawBridgeEnterText.getText().toString() +
                    ", autosallyPort = " + autoSallyEnterText.getText().toString() + ", autorockWall = " + autoRockWallEnterText.getText().toString() + ", autoroughTerrain = " +
                    autoRoughTerrainEnterText.getText().toString() + ", autohighScored = " + autoHighGoalEnterText.getText().toString() + ", autolowScored = " + autoLowGoalEnterText.getText().toString() +
                    ", shotsFired = " + shotsFiredEnterText.getText().toString() + ", highGoalsScored = " + highGoalsScoredEnterText.getText().toString() + ", lowgoalsScored = " + lowGoalsScoredEnterText.getText().toString() +
                    ", lowbarCrossed = " + lowBarCrossedEnterText.getText().toString() + ", lowbarhardCrossed = " + lowBarHardEnterText.getText().toString() + ", portcullisCrossed = " +
                    portCullisCrossedEnterText.getText().toString() + ", portcullishardCrossed = " + portCullisHardEnterText.getText().toString() + ", chevaldefriseCrossed = " + chevalEnterText.getText().toString() +
                    ", chevaldefrisehardCrossed = " + chevalHardEnterText.getText().toString() + ", moatCrossed = " + moatCrossedEnterText.getText().toString() + ", moathardCrossed = " +
                    moatHardEnterText.getText().toString() + ", rampartsCrossed = " + rampartsCrossedEnterText.getText().toString() + ", rampartshardCrossed = " + rampartsHardEnterText.getText().toString() +
                    ", drawbridgeCrossed = " + drawbridgeCrossedEnterText.getText().toString() + ", drawbridgehardCrossed = " + drawbridgeHardEnterText.getText().toString() + ", sallyportCrossed = " +
                    sallyCrossedEnterText.getText().toString() + ", sallyporthardCrossed = " + sallyHardEnterText.getText().toString() + ", rockwallCrossed = " + rockwallCrossedEnterText.getText().toString() +
                    ", rockwallhardCrossed = " + rockwallHardEnterText.getText().toString() + ", roughterrainCrossed = " + roughTerrainCrossedEnterText.getText().toString() + ", roughterrainhardCrossed = " +
                    roughTerrainHardEnterText.getText().toString() + ", robotChallenge = " + robotChallengeEnterText.getText().toString() + ", robotClimb = " + robotClimbEnterText.getText().toString() +
                    ", climbSpeed = " + climbSpeedEnterText.getText().toString() + ", climbSuccessful = " + climbSuccessEnterText.getText().toString() + ", robotNotes = '" + notes +
                    "' WHERE _id = " + id);
        }catch (SQLException e){
            System.out.print(e);
        }
        Cursor cur = myDB.rawQuery("SELECT * FROM MatchScouting WHERE _id =" + id, null);
        cur.moveToFirst();
        tNumber = cur.getString(cur.getColumnIndex("teamNumber"));
        mNumber = cur.getString(cur.getColumnIndex("matchtype_number"));
        cur.close();
        myDB.close();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("TEAM_NUMBER",tNumber);
        returnIntent.putExtra("MATCH_NUMBER", mNumber);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
