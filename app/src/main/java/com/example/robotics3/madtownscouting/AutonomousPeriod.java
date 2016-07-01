package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class AutonomousPeriod extends AppCompatActivity {
    //Button autoyesButton;
    //Button autonoButton;
    CheckBox activeautoperiodcheckBox;
    TextView autostartingpositionText;
    CheckBox spybotstartcheckBox;
    TextView autoperiodquestion2Text;
    Button breachyesButton;
    Button breachnoButton;
    TextView autoperiodquestion3Text;
    CheckBox autolowbarcheckBox;
    CheckBox autoportcullischeckBox;
    CheckBox autochevaldefrisecheckBox;
    CheckBox automoatcheckBox;
    CheckBox autorampartscheckBox;
    CheckBox autodrawbridgecheckBox;
    CheckBox autosallyportcheckBox;
    CheckBox autorockwallcheckBox;
    CheckBox autoroughterraincheckBox;
    TextView autoperiodquestion4Text;
    Button highgoalyesButton;
    Button highgoalnoButton;
    TextView autoperiodquestion5Text;
    Button lowgoalyesButton;
    Button lowgoalnoButton;
    Button enterautoDataButton;
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
    int autolowScored =  0;
    String teamName;
    String teamNumber;
    int matchtype_number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous_period);
        //autoyesButton = (Button)findViewById(R.id.autoyesButton);
        //autonoButton = (Button)findViewById(R.id.autonoButton);
        activeautoperiodcheckBox = (CheckBox) findViewById(R.id.activeautoperiodcheckBox);
        autostartingpositionText = (TextView)findViewById(R.id.autostartingpositionText);
        spybotstartcheckBox = (CheckBox)findViewById(R.id.spybotstartcheckBox);
        autoperiodquestion2Text = (TextView) findViewById(R.id.autoperiodquestion2Text);
        autoperiodquestion2Text.setVisibility(View.GONE);
        breachyesButton = (Button) findViewById(R.id.breachyesButton);
        breachyesButton.setVisibility(View.GONE);
        breachnoButton = (Button) findViewById(R.id.breachnoButton);
        breachnoButton.setVisibility(View.GONE);
        autoperiodquestion3Text = (TextView) findViewById(R.id.autoperiodquestion3Text);
        autoperiodquestion3Text.setVisibility(View.GONE);
        autolowbarcheckBox = (CheckBox) findViewById(R.id.autolowbarcheckBox);
        autolowbarcheckBox.setVisibility(View.GONE);
        autoportcullischeckBox = (CheckBox) findViewById(R.id.autoportcullischeckBox);
        autoportcullischeckBox.setVisibility(View.GONE);
        autochevaldefrisecheckBox = (CheckBox) findViewById(R.id.autochevaldefrisecheckBox);
        autochevaldefrisecheckBox.setVisibility(View.GONE);
        automoatcheckBox = (CheckBox) findViewById(R.id.automoatcheckBox);
        automoatcheckBox.setVisibility(View.GONE);
        autorampartscheckBox = (CheckBox) findViewById(R.id.autorampartscheckBox);
        autorampartscheckBox.setVisibility(View.GONE);
        autodrawbridgecheckBox = (CheckBox) findViewById(R.id.autodrawbridgecheckBox);
        autodrawbridgecheckBox.setVisibility(View.GONE);
        autosallyportcheckBox = (CheckBox) findViewById(R.id.autosallyportcheckBox);
        autosallyportcheckBox.setVisibility(View.GONE);
        autorockwallcheckBox = (CheckBox) findViewById(R.id.autorockwallcheckBox);
        autorockwallcheckBox.setVisibility(View.GONE);
        autoroughterraincheckBox = (CheckBox) findViewById(R.id.autoroughterraincheckBox);
        autoroughterraincheckBox.setVisibility(View.GONE);
        autoperiodquestion4Text = (TextView) findViewById(R.id.autoperiodquestion4Text);
        autoperiodquestion4Text.setVisibility(View.GONE);
        highgoalyesButton = (Button) findViewById(R.id.highgoalyesButton);
        highgoalyesButton.setVisibility(View.GONE);
        highgoalnoButton = (Button) findViewById(R.id.highgoalnoButton);
        highgoalnoButton.setVisibility(View.GONE);
        autoperiodquestion5Text = (TextView) findViewById(R.id.autoperiodquestion5Text);
        autoperiodquestion5Text.setVisibility(View.GONE);
        lowgoalyesButton = (Button) findViewById(R.id.lowgoalyesButton);
        lowgoalyesButton.setVisibility(View.GONE);
        lowgoalnoButton = (Button) findViewById(R.id.lowgoalnoButton);
        lowgoalnoButton.setVisibility(View.GONE);
        enterautoDataButton = (Button) findViewById(R.id.enterautoDataButton);
        if(savedInstanceState != null){
            defenseBreached = savedInstanceState.getInt("defenseBreached");
            autohighScored = savedInstanceState.getInt("autohighScored");
            autolowScored = savedInstanceState.getInt("autolowScored");
        }

        /*autoyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoPeriodActivtated = 1;
                autoperiodOptions();
            }
        });
        autonoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoPeriodActivtated = 0;
            }
        });*/
        activeautoperiodcheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoperiodquestion2Options();
            }
        });
        spybotstartcheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoperiodquestion4Options();
            }
        });
        breachyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defenseBreached = 1;
                autoperiodquestion3Options();
            }
        });
        breachnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defenseBreached = 0;
            }
        });
        highgoalyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autohighScored = 1;
            }
        });
        highgoalnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autohighScored = 0;
                autoperiodquestion5Options();
            }
        });
        lowgoalyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autolowScored = 1;
            }
        });
        lowgoalnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autolowScored = 0;
            }
        });
        enterautoDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadaccuracy_precisionScreen();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("defenseBreached", defenseBreached);
        outState.putInt("autohighScored", autohighScored);
        outState.putInt("autolowScored", autolowScored);
    }
    public void autoperiodquestion2Options(){
        if (autoperiodquestion2Text.getVisibility() == View.GONE){
            autoperiodquestion2Text.setVisibility(View.VISIBLE);
            breachyesButton.setVisibility(View.VISIBLE);
            breachnoButton.setVisibility(View.VISIBLE);
        }else{
            autoperiodquestion2Text.setVisibility(View.GONE);
            breachyesButton.setVisibility(View.GONE);
            breachnoButton.setVisibility(View.GONE);
        }
    }
    public void autoperiodquestion3Options(){
        if (autoperiodquestion3Text.getVisibility() == View.GONE) {
            autoperiodquestion3Text.setVisibility(View.VISIBLE);
            autolowbarcheckBox.setVisibility(View.VISIBLE);
            autoportcullischeckBox.setVisibility(View.VISIBLE);
            autochevaldefrisecheckBox.setVisibility(View.VISIBLE);
            automoatcheckBox.setVisibility(View.VISIBLE);
            autorampartscheckBox.setVisibility(View.VISIBLE);
            autodrawbridgecheckBox.setVisibility(View.VISIBLE);
            autosallyportcheckBox.setVisibility(View.VISIBLE);
            autorockwallcheckBox.setVisibility(View.VISIBLE);
            autoroughterraincheckBox.setVisibility(View.VISIBLE);
            autoperiodquestion4Text.setVisibility(View.VISIBLE);
            highgoalyesButton.setVisibility(View.VISIBLE);
            highgoalnoButton.setVisibility(View.VISIBLE);
        }else{
            autoperiodquestion3Text.setVisibility(View.GONE);
            autolowbarcheckBox.setVisibility(View.GONE);
            autoportcullischeckBox.setVisibility(View.GONE);
            autochevaldefrisecheckBox.setVisibility(View.GONE);
            automoatcheckBox.setVisibility(View.GONE);
            autorampartscheckBox.setVisibility(View.GONE);
            autodrawbridgecheckBox.setVisibility(View.GONE);
            autosallyportcheckBox.setVisibility(View.GONE);
            autorockwallcheckBox.setVisibility(View.GONE);
            autoroughterraincheckBox.setVisibility(View.GONE);
            autoperiodquestion4Text.setVisibility(View.GONE);
            highgoalyesButton.setVisibility(View.GONE);
            highgoalnoButton.setVisibility(View.GONE);
        }
    }
    public void autoperiodquestion4Options(){
        if (autoperiodquestion4Text.getVisibility() == View.GONE){
            autoperiodquestion4Text.setVisibility(View.VISIBLE);
            highgoalyesButton.setVisibility(View.VISIBLE);
            highgoalnoButton.setVisibility(View.VISIBLE);
        }else{
            autoperiodquestion4Text.setVisibility(View.GONE);
            highgoalyesButton.setVisibility(View.GONE);
            highgoalnoButton.setVisibility(View.GONE);
        }
    }
    public void autoperiodquestion5Options() {
        if (autoperiodquestion5Text.getVisibility() == View.GONE) {
            autoperiodquestion5Text.setVisibility(View.VISIBLE);
            lowgoalyesButton.setVisibility(View.VISIBLE);
            lowgoalnoButton.setVisibility(View.VISIBLE);
        }else{
            autoperiodquestion5Text.setVisibility(View.GONE);
            lowgoalyesButton.setVisibility(View.GONE);
            lowgoalnoButton.setVisibility(View.GONE);
        }
    }
    public void loadaccuracy_precisionScreen() {
        Intent accuracy_precisionActivity = new Intent(this, Accuracy_Precision.class);
        Intent intent = this.getIntent();
        teamName = intent.getStringExtra("TEAMNAME");
        teamNumber = intent.getStringExtra("TEAMNUMBER");
        matchtype_number = intent.getIntExtra("MATCHTYPENUMBER", 0);
        if (activeautoperiodcheckBox.isChecked()) {
            autoPeriodActivtated = 1;
        }
        if (spybotstartcheckBox.isChecked()) {
            spybotstart = 1;
        }
        if (autolowbarcheckBox.isChecked()) {
            autolowBar = 1;
        }
        if (autoportcullischeckBox.isChecked()) {
            autoportCullis = 1;
        }
        if (autochevaldefrisecheckBox.isChecked()) {
            autochevaldeFrise = 1;
        }
        if (automoatcheckBox.isChecked()) {
            autoMoat = 1;
        }
        if (autorampartscheckBox.isChecked()) {
            autoRamparts = 1;
        }
        if (autodrawbridgecheckBox.isChecked()) {
            autodrawBridge = 1;
        }
        if (autosallyportcheckBox.isChecked()) {
            autosallyPort = 1;
        }
        if (autorockwallcheckBox.isChecked()) {
            autorockWall = 1;
        }
        if (autoroughterraincheckBox.isChecked()) {
            autoroughTerrain = 1;
        }
        accuracy_precisionActivity.putExtra("AUTO", autoPeriodActivtated);
        accuracy_precisionActivity.putExtra("SPYBOT", spybotstart);
        accuracy_precisionActivity.putExtra("BREACHED", defenseBreached);
        accuracy_precisionActivity.putExtra("AUTO_LOWBAR", autolowBar);
        accuracy_precisionActivity.putExtra("AUTO_PORTCULLIS", autoportCullis);
        accuracy_precisionActivity.putExtra("AUTO_CDF", autochevaldeFrise);
        accuracy_precisionActivity.putExtra("AUTO_MOAT", autoMoat);
        accuracy_precisionActivity.putExtra("AUTO_RAMPARTS", autoRamparts);
        accuracy_precisionActivity.putExtra("AUTO_DRAWBRIDGE", autodrawBridge);
        accuracy_precisionActivity.putExtra("AUTO_SALLYPORT", autosallyPort);
        accuracy_precisionActivity.putExtra("AUTO_ROCKWALL", autorockWall);
        accuracy_precisionActivity.putExtra("AUTO_ROUGHTERRAIN", autoroughTerrain);
        accuracy_precisionActivity.putExtra("HIGH", autohighScored);
        accuracy_precisionActivity.putExtra("LOW", autolowScored);
        accuracy_precisionActivity.putExtra("TEAMNAME", teamName);
        accuracy_precisionActivity.putExtra("TEAMNUMBER", teamNumber);
        accuracy_precisionActivity.putExtra("MATCHTYPERNUMBER", matchtype_number);
        this.setResult(RESULT_OK, intent);
        startActivity(accuracy_precisionActivity);
    }
}
