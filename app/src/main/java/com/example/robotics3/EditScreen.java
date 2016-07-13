package com.example.robotics3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.robotics3.madtownscouting.R;

public class EditScreen extends AppCompatActivity {
TextView teamNameText;
TextView teamNumberText;
TextView matchNumberText;
TextView activeAutoText;
TextView spyBotStart;
TextView defenseBreachedText;
TextView autoLowBarText;
TextView autoPortcullisText;
TextView autoChevalDeFriseText;
TextView autoMoatText;
TextView autoRampartsText;
TextView autoDrawBridgeText;
TextView autoSallyText;
TextView autoRockWallText;
TextView autoRoughTerrainText;
TextView autoHighGoalText;
TextView autoLowGoalText;
TextView shotsFiredText;
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
EditText EnterText;

SQLiteDataBase myDB = null;
Cursor c;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
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
            autoPortCullisEnterText.setText(c.getString(c.getColumnIndex("autoportCullis")), TextView.BufferType.EDITABLE);
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
        }
    }
}
