package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class SelectTeam extends AppCompatActivity {
    EditText enternewteamnameText;
    EditText enternewteamnumberText;
    EditText entermatchtype_numberText;
    //AutoCompleteTextView autocomplete_matchtype_numberText;
    Button scoutnewteamButton;
    String teamName;
    String teamNumber;
    int matchtype_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_team);
 /*       ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matchtype);
        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.matchtypeCustomView);
        textView.setAdapter(adapter);*/
        enternewteamnameText = (EditText) findViewById(R.id.enternewteamnameText);
        enternewteamnumberText = (EditText) findViewById(R.id.enternewteamnumberText);
        entermatchtype_numberText = (EditText)findViewById(R.id.entermatchtype_numberText);
        scoutnewteamButton = (Button) findViewById(R.id.scoutnewteamButton);
        scoutnewteamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamName = enternewteamnameText.getEditableText().toString();
                teamNumber = enternewteamnumberText.getEditableText().toString();
                matchtype_number = Integer.valueOf(entermatchtype_numberText.getEditableText().toString());
                loadautonomousperiodScreen();
            }
        });
    }
    public void loadautonomousperiodScreen() {
        Intent autonomousperiodActivity = new Intent(this, AutonomousPeriod.class);
        autonomousperiodActivity.putExtra("TEAMNUMBER", teamNumber);
        autonomousperiodActivity.putExtra("TEAMNAME", teamName);
        autonomousperiodActivity.putExtra("MATCHTYPENUMBER", matchtype_number);
        startActivity(autonomousperiodActivity);
    }
}
/*    public void loadscoutingScreen(){
        Intent loadscoutingActivity = new Intent(this, ScoutingMenu.class);
        loadscoutingActivity.putExtra("TEAMNUMBER", teamNumber);
        loadscoutingActivity.putExtra("TEAMNAME", teamName);
        loadscoutingActivity.putExtra("MATCHTYPENUMBER", matchtype_number);
        startActivity(loadscoutingActivity);
    }

    //private static final String[] matchtype = new String[]{
      //      "Qualifying", "Semifinal", "QuarterFinal", "Final", "Tiebreaker"
}
*/
