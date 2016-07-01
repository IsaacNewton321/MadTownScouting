package com.example.robotics3.madtownscouting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class Accuracy_Precision extends AppCompatActivity {
    Button increaseshotsamountButton;
    TextView shotsamountValueText;
    Button decreaseshotsamountButton;
    Button increaseshotsscoredButton;
    TextView shotsscoredValueText;
    Button decreaseshotsscoredButton;
    TextView totalshotsamountValueText;
    Button increaselowgoalsscoredButton;
    TextView lowgoalsscoredText;
    Button decreaselowgoalsscoredButton;
    Button increaselowbareasycrossesButton;
    TextView lowbareasycrossedValueText;
    Button decreaselowbareasycrossesButton;
    Button increaselowbarhardcrossesButton;
    TextView lowbarhardcrossedValueText;
    Button decreaselowbarhardcrossesButton;
    Button increaseportculliseasycrossesButton;
    TextView portculliseasycrossedValueText;
    Button decreaseportculliseasycrosssesButton;
    Button increaseportcullishardcrossesButton;
    TextView portcullishardcrossedValueText;
    Button decreaseportcullishardcrossesButton;
    Button increasechevaldefriseeasycrossesButton;
    TextView chevaldefriseeasycrossedValueText;
    Button decreasechevaldefriseeasycrossesButton;
    Button increasechevaldefrisehardcrossesButton;
    TextView chevaldefrisehardcrossedValueText;
    Button decreasechevaldefrisehardcrossesButton;
    Button increasemoateasycrossesButton;
    TextView moateasycrossedValueText;
    Button decreasemoateasycrossesButton;
    Button increasemoathardcrossesButton;
    TextView moathardcrossedValueText;
    Button decreasemoathardcrossesButton;
    Button increaserampartseasycrossesButton;
    TextView rampartseasycrossedValueText;
    Button decreaserampartseasycrossesButton;
    Button increaserampartshardcrossesButton;
    TextView rampartshardcrossedValueText;
    Button decreaserampartshardcrossesButton;
    Button increasedrawbridgeeasycrossesButton;
    TextView drawbridgeeasycrossedValueText;
    Button decreasedrawbridgeeasycrossesButton;
    Button increasedrawbridgehardcrossesButton;
    TextView drawbridgehardcrossedValueText;
    Button decreasedrawbridgehardcrossesButton;
    Button increasesallyporteasycrossesButton;
    TextView sallyporteasycrossedValueText;
    Button decreasesallyporteasycrossesButton;
    Button increasesallyporthardcrossesButton;
    TextView sallyporthardcrossedValueText;
    Button decreasesallyporthardcrossesButton;
    Button increaserockwalleasycrossesButton;
    TextView rockwalleasycrossedValueText;
    Button decreaserockwalleasycrossesButton;
    Button increaserockwallhardcrossesButton;
    TextView rockwallhardcrossedValueText;
    Button decreaserockwallhardcrossesButton;
    Button increaseroughterraineasycrossesButton;
    TextView roughterraineasycrossedValueText;
    Button decreaseroughterraineasycrossesButton;
    Button increaseroughterrainhardcrossesButton;
    TextView roughterrainhardcrossedValueText;
    Button decreaseroughterrainhardcrossesButton;
    Button robotchallengeyesButton;
    Button robotchallengenoButton;
    Button robotclimbyesButton;
    Button robotclimbnoButton;
    EditText robotmatchnotesText;
    TextView climbdetail2Text;
    SeekBar climbspeedseekBar;
    TextView climbspeedvalueText;
    TextView climbdetail3Text;
    Button climbsuccesyesButton;
    Button climbsuccesnoButton;
    Button enterAccuracy_PrecisionDataButton;
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
    int autoPeriodActivtated;
    int spybotstart;
    int defenseBreached;
    int autolowBar;
    int autoportCullis;
    int autochevaldeFrise;
    int autoMoat;
    int autoRamparts;
    int autodrawBridge;
    int autosallyPort;
    int autorockWall;
    int autoroughTerrain;
    int autohighScored;
    int autolowScored;
    String teamName;
    String teamNumber;
    int matchtype_number;
    String robotNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accuracy__precision);
        increaseshotsamountButton = (Button) findViewById(R.id.increaseshotsamountButton);
        shotsamountValueText = (TextView) findViewById(R.id.shotsamountValueText);
        decreaseshotsamountButton = (Button) findViewById(R.id.decreaseshotsamountButton);
        increaseshotsscoredButton = (Button) findViewById(R.id.increaseshotsscoredButton);
        shotsscoredValueText = (TextView) findViewById(R.id.shotsscoredValueText);
        decreaseshotsscoredButton = (Button) findViewById(R.id.decreaseshotsscoredButton);
        totalshotsamountValueText = (TextView) findViewById(R.id.totalshotsamountValueText);
        increaselowgoalsscoredButton = (Button) findViewById(R.id.increaselowgoalsscoredButton);
        lowgoalsscoredText = (TextView) findViewById(R.id.lowgoalsscoredText);
        decreaselowgoalsscoredButton = (Button) findViewById(R.id.decreaselowgoalsscoredButton);
        increaselowbareasycrossesButton = (Button) findViewById(R.id.increaselowbareasycrossesButton);
        lowbareasycrossedValueText = (TextView) findViewById(R.id.lowbareasycrossedValueText);
        decreaselowbareasycrossesButton = (Button) findViewById(R.id.decreaselowbareasycrossesButton);
        increaselowbarhardcrossesButton = (Button) findViewById(R.id.increaselowbarhardcrossesButton);
        lowbarhardcrossedValueText = (TextView) findViewById(R.id.lowbarhardcrossedValueText);
        decreaselowbarhardcrossesButton = (Button) findViewById(R.id.decreaselowbarhardcrossesButton);
        increaseportculliseasycrossesButton = (Button) findViewById(R.id.increaseportculliseasycrossesButton);
        portculliseasycrossedValueText = (TextView) findViewById(R.id.portculliseasycrossedValueText);
        decreaseportculliseasycrosssesButton = (Button) findViewById(R.id.decreaseportculliseasycrossesButton);
        increaseportcullishardcrossesButton = (Button) findViewById(R.id.increaseportcullishardcrossesButton);
        portcullishardcrossedValueText = (TextView) findViewById(R.id.portcullishardcrossedValueText);
        decreaseportcullishardcrossesButton = (Button) findViewById(R.id.decreaseportcullishardcrossesButton);
        increasechevaldefriseeasycrossesButton = (Button) findViewById(R.id.increasechevaldefriseeasycrossesButton);
        chevaldefriseeasycrossedValueText = (TextView) findViewById(R.id.chevaldefriseeasycrossedValueText);
        decreasechevaldefriseeasycrossesButton = (Button) findViewById(R.id.decreasechevaldefriseeasycrossesButton);
        increasechevaldefrisehardcrossesButton = (Button) findViewById(R.id.increasechevaldefrisehardcrossesButton);
        chevaldefrisehardcrossedValueText = (TextView) findViewById(R.id.chevaldefrisehardcrossedValueText);
        decreasechevaldefrisehardcrossesButton = (Button) findViewById(R.id.decreasechevaldefrisehardcrossesButton);
        increasemoateasycrossesButton = (Button) findViewById(R.id.increasemoateasycrossesButton);
        moateasycrossedValueText = (TextView) findViewById(R.id.moateasycrossedValueText);
        decreasemoateasycrossesButton = (Button) findViewById(R.id.decreasemoateasycrossesButton);
        increasemoathardcrossesButton = (Button) findViewById(R.id.increasemoathardcrossesButton);
        moathardcrossedValueText = (TextView) findViewById(R.id.moathardcrossedValueText);
        decreasemoathardcrossesButton = (Button) findViewById(R.id.decreasemoathardcrossesButton);
        increaserampartseasycrossesButton = (Button) findViewById(R.id.increaserampartseasycrossesButton);
        rampartseasycrossedValueText = (TextView) findViewById(R.id.rampartseasycrossedValueText);
        decreaserampartseasycrossesButton = (Button) findViewById(R.id.decreaserampartseasycrossesButton);
        increaserampartshardcrossesButton = (Button) findViewById(R.id.increaserampartshardcrossesButton);
        rampartshardcrossedValueText = (TextView) findViewById(R.id.rampartshardcrossedValuetext);
        decreaserampartshardcrossesButton = (Button) findViewById(R.id.decreaserampartshardcrossesButton);
        increasedrawbridgeeasycrossesButton = (Button) findViewById(R.id.increasedrawbridgeeasycrossesButton);
        drawbridgeeasycrossedValueText = (TextView) findViewById(R.id.drawbridgeeasycrossedValueText);
        decreasedrawbridgeeasycrossesButton = (Button) findViewById(R.id.decreasedrawbridgeeasycrossesButton);
        increasedrawbridgehardcrossesButton = (Button) findViewById(R.id.increasedrawbridgehardcrossesButton);
        drawbridgehardcrossedValueText = (TextView) findViewById(R.id.drawbridgehardcrossedValueText);
        decreasedrawbridgehardcrossesButton = (Button) findViewById(R.id.decreasedrawbridgehardcrossesButton);
        increasesallyporteasycrossesButton = (Button) findViewById(R.id.increasesallyporteasycrossesButton);
        sallyporteasycrossedValueText = (TextView) findViewById(R.id.sallyporteasycrossedValueText);
        decreasesallyporteasycrossesButton = (Button) findViewById(R.id.decreasesallyporteasycrossesButton);
        increasesallyporthardcrossesButton = (Button) findViewById(R.id.increasesallyporthardcrossesButton);
        sallyporthardcrossedValueText = (TextView) findViewById(R.id.sallyporthardcrossedValueText);
        decreasesallyporthardcrossesButton = (Button) findViewById(R.id.decreasesallyporthardcrossesButton);
        increaserockwalleasycrossesButton = (Button) findViewById(R.id.increaserockwalleasycrossedButton);
        rockwalleasycrossedValueText = (TextView) findViewById(R.id.rockwalleasycrossedValueText);
        decreaserockwalleasycrossesButton = (Button) findViewById(R.id.decreaserockwalleasycrossesButton);
        increaserockwallhardcrossesButton = (Button) findViewById(R.id.increaserockwallhardcrossesButton);
        rockwallhardcrossedValueText = (TextView) findViewById(R.id.rockwallhardcrossedValueText);
        decreaserockwallhardcrossesButton = (Button) findViewById(R.id.decreaserockwallhardcrossesButton);
        increaseroughterraineasycrossesButton = (Button) findViewById(R.id.increaseroughterraineasycrossesButton);
        roughterraineasycrossedValueText = (TextView) findViewById(R.id.roughterraineasycrossedValueText);
        decreaseroughterraineasycrossesButton = (Button) findViewById(R.id.decreaseroughterraineasycrossesButton);
        increaseroughterrainhardcrossesButton = (Button) findViewById(R.id.increaseroughterrainhardcrossesButton);
        roughterrainhardcrossedValueText = (TextView) findViewById(R.id.roughterrainhardcrossedValueText);
        decreaseroughterrainhardcrossesButton = (Button) findViewById(R.id.decreaseroughterrainhardcrossesButton);
        robotchallengeyesButton = (Button) findViewById(R.id.robotchallengeyesButton);
        robotchallengenoButton = (Button) findViewById(R.id.robotchallengenoButton);
        robotclimbyesButton = (Button) findViewById(R.id.robotclimbyesButton);
        robotclimbnoButton = (Button) findViewById(R.id.robotclimbnoButton);
        climbdetail2Text = (TextView) findViewById(R.id.climbdetail2Text);
        climbdetail2Text.setVisibility(View.GONE);
        climbspeedseekBar = (SeekBar) findViewById(R.id.climbspeedseekBar);
        climbspeedseekBar.setVisibility(View.GONE);
        climbspeedvalueText = (TextView) findViewById(R.id.climbspeedvalueText);
        climbspeedvalueText.setVisibility(View.GONE);
        climbdetail3Text = (TextView) findViewById(R.id.climbdetail3Text);
        climbdetail3Text.setVisibility(View.GONE);
        climbsuccesyesButton = (Button) findViewById(R.id.climbsuccesyesButton);
        climbsuccesyesButton.setVisibility(View.GONE);
        climbsuccesnoButton = (Button) findViewById(R.id.climbsuccesnoButton);
        climbsuccesnoButton.setVisibility(View.GONE);
        robotmatchnotesText = (EditText) findViewById(R.id.robotmatchnotesText);
        if(savedInstanceState != null){
            shotsAmount = savedInstanceState.getInt("shotsAmount");
            shotsScored = savedInstanceState.getInt("shotsScored");
            lowgoalsScored = savedInstanceState.getInt("lowgoalsScored");
            lowbarCrossed = savedInstanceState.getInt("lowbarCrossed");
            lowbarhardCrossed = savedInstanceState.getInt("lowbarhardCrossed");
            portcullisCrossed = savedInstanceState.getInt("portcullisCrossed");
            portcullishardCrossed = savedInstanceState.getInt("portcullishardCrossed");
            chevaldefriseCrossed = savedInstanceState.getInt("chevaldefriseCrossed");
            chevaldefrisehardCrossed = savedInstanceState.getInt("chevaldefrisehardCrossed");
            moatCrossed = savedInstanceState.getInt("moatCrossed");
            moathardCrossed = savedInstanceState.getInt("moathardCrossed");
            rampartsCrossed = savedInstanceState.getInt("rampartsCrossed");
            drawbridgeCrossed = savedInstanceState.getInt("drawbridgeCrossed");
            drawbridgehardCrossed = savedInstanceState.getInt("drawbridgehardCrossed");
            sallyportCrossed = savedInstanceState.getInt("sallyportCrossed");
            sallyporthardCrossed = savedInstanceState.getInt("sallyporthardCrossed");
            rockwallCrossed = savedInstanceState.getInt("rockwallCrossed");
            rockwallhardCrossed = savedInstanceState.getInt("rockwallhardCrossed");
            roughterrainCrossed = savedInstanceState.getInt("roughterrainCrossed");
            roughterrainhardCrossed = savedInstanceState.getInt("roughterrainhardCrossed");
            robotChallenge = savedInstanceState.getInt("robotChallenge");
            robotClimb = savedInstanceState.getInt("robotClimb");
            successfulclimb = savedInstanceState.getInt("successfulclimb");
            climbSpeed = savedInstanceState.getInt("climbSpeed");
            setSavedInts();
        }
        increaseshotsamountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotsAmount += 1;
                String ShotsAmountText = Integer.toString(shotsAmount);
                shotsamountValueText.setText(ShotsAmountText);
                totalshotsamountValueText.setText(ShotsAmountText);
            }
        });
        decreaseshotsamountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotsAmount -= 1;
                String ShotsAmountText = Integer.toString(shotsAmount);
                shotsamountValueText.setText(ShotsAmountText);
                totalshotsamountValueText.setText(ShotsAmountText);
            }
        });
        increaseshotsscoredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotsScored += 1;
                String ShotsScoredText = Integer.toString(shotsScored);
                shotsscoredValueText.setText(ShotsScoredText);
            }
        });
        decreaseshotsscoredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotsScored -= 1;
                String ShotsScoredText = Integer.toString(shotsScored);
                shotsscoredValueText.setText(ShotsScoredText);
            }
        });
        increaselowgoalsscoredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowgoalsScored += 1;
                String LowGoalsScoredText = Integer.toString(lowgoalsScored);
                lowgoalsscoredText.setText(LowGoalsScoredText);
            }
        });
        decreaselowgoalsscoredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowgoalsScored -= 1;
                String LowGoalsScoredText = Integer.toString(lowgoalsScored);
                lowgoalsscoredText.setText(LowGoalsScoredText);
            }
        });
        increaselowbareasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowbarCrossed += 1;
                String LowBarCrossedText = Integer.toString(lowbarCrossed);
                lowbareasycrossedValueText.setText(LowBarCrossedText);
            }
        });
        decreaselowbareasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowbarCrossed -= 1;
                String LowBarCrossedText = Integer.toString(lowbarCrossed);
                lowbareasycrossedValueText.setText(LowBarCrossedText);
            }
        });
        increaselowbarhardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowbarhardCrossed += 1;
                String LowBarHardCrossedText = Integer.toString(lowbarhardCrossed);
                lowbarhardcrossedValueText.setText(LowBarHardCrossedText);
            }
        });
        decreaselowbarhardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowbarhardCrossed -= 1;
                String LowBarHardCrossedText = Integer.toString(lowbarhardCrossed);
                lowbarhardcrossedValueText.setText(LowBarHardCrossedText);
            }
        });
        increaseportculliseasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portcullisCrossed += 1;
                String PortCullisCrossedText = Integer.toString(portcullisCrossed);
                portculliseasycrossedValueText.setText(PortCullisCrossedText);
            }
        });
        decreaseportculliseasycrosssesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portcullisCrossed -= 1;
                String PortCullisCrossedText = Integer.toString(portcullisCrossed);
                portculliseasycrossedValueText.setText(PortCullisCrossedText);
            }
        });
        increaseportcullishardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portcullishardCrossed += 1;
                String PortCullisHardCrossedText = Integer.toString(portcullishardCrossed);
                portcullishardcrossedValueText.setText(PortCullisHardCrossedText);
            }
        });
        decreaseportcullishardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portcullishardCrossed -= 1;
                String PortCullisHardCrossedText = Integer.toString(portcullishardCrossed);
                portcullishardcrossedValueText.setText(PortCullisHardCrossedText);
            }
        });
        increasechevaldefriseeasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chevaldefriseCrossed += 1;
                String ChevalDeFriseCrossedText = Integer.toString(chevaldefriseCrossed);
                chevaldefriseeasycrossedValueText.setText(ChevalDeFriseCrossedText);
            }
        });
        decreasechevaldefriseeasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chevaldefriseCrossed -= 1;
                String ChevalDeFriseCrossedText = Integer.toString(chevaldefriseCrossed);
                chevaldefriseeasycrossedValueText.setText(ChevalDeFriseCrossedText);
            }
        });
        increasechevaldefrisehardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chevaldefrisehardCrossed += 1;
                String ChevalDeFriseHardCrossedText = Integer.toString(chevaldefrisehardCrossed);
                chevaldefrisehardcrossedValueText.setText(ChevalDeFriseHardCrossedText);
            }
        });
        decreasechevaldefrisehardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chevaldefrisehardCrossed -= 1;
                String ChevalDeFriseHardCrossedText = Integer.toString(chevaldefrisehardCrossed);
                chevaldefrisehardcrossedValueText.setText(ChevalDeFriseHardCrossedText);
            }
        });
        increasemoateasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moatCrossed +=1 ;
                String MoatCrossedText = Integer.toString(moatCrossed);
                moateasycrossedValueText.setText(MoatCrossedText);
            }
        });
        decreasemoateasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moatCrossed -=1 ;
                String MoatCrossedText = Integer.toString(moatCrossed);
                moateasycrossedValueText.setText(MoatCrossedText);
            }
        });
        increasemoathardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moathardCrossed += 1;
                String MoatHardCrossedText = Integer.toString(moathardCrossed);
                moathardcrossedValueText.setText(MoatHardCrossedText);
            }
        });
        decreasemoathardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moathardCrossed -= 1;
                String MoatHardCrossedText = Integer.toString(moathardCrossed);
                moathardcrossedValueText.setText(MoatHardCrossedText);
            }
        });
        increaserampartseasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rampartsCrossed += 1;
                String RampartsCrossedText = Integer.toString(rampartsCrossed);
                rampartseasycrossedValueText.setText(RampartsCrossedText);
            }
        });
        decreaserampartseasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rampartsCrossed -= 1;
                String RampartsCrossedText = Integer.toString(rampartsCrossed);
                rampartseasycrossedValueText.setText(RampartsCrossedText);
            }
        });
        increaserampartshardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rampartshardCrossed += 1;
                String RampartsHardCrossedText = Integer.toString(rampartshardCrossed);
                rampartshardcrossedValueText.setText(RampartsHardCrossedText);
            }
        });
        decreaserampartshardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rampartshardCrossed -= 1;
                String RampartsHardCrossedText = Integer.toString(rampartshardCrossed);
                rampartshardcrossedValueText.setText(RampartsHardCrossedText);
            }
        });
        increasedrawbridgeeasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawbridgeCrossed += 1;
                String DrawBridgeCrossedText = Integer.toString(drawbridgeCrossed);
                drawbridgeeasycrossedValueText.setText(DrawBridgeCrossedText);
            }
        });
        decreasedrawbridgeeasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawbridgeCrossed -= 1;
                String DrawBridgeCrossedText = Integer.toString(drawbridgeCrossed);
                drawbridgeeasycrossedValueText.setText(DrawBridgeCrossedText);
            }
        });
        increasedrawbridgehardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawbridgehardCrossed += 1;
                String DrawBridgeHardCrossedText = Integer.toString(drawbridgehardCrossed);
                drawbridgehardcrossedValueText.setText(DrawBridgeHardCrossedText);
            }
        });
        decreasedrawbridgehardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawbridgehardCrossed -= 1;
                String DrawBridgeHardCrossedText = Integer.toString(drawbridgehardCrossed);
                drawbridgehardcrossedValueText.setText(DrawBridgeHardCrossedText);
            }
        });
        increasesallyporteasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sallyportCrossed += 1;
                String SallyPortCrossedText = Integer.toString(sallyportCrossed);
                sallyporteasycrossedValueText.setText(SallyPortCrossedText);
            }
        });
        decreasesallyporteasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sallyportCrossed -= 1;
                String SallyPortCrossedText = Integer.toString(sallyportCrossed);
                sallyporteasycrossedValueText.setText(SallyPortCrossedText);
            }
        });
        increasesallyporthardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sallyporthardCrossed += 1;
                String SallyPortHardCrossedText = Integer.toString(sallyporthardCrossed);
                sallyporthardcrossedValueText.setText(SallyPortHardCrossedText);
            }
        });
        decreasesallyporthardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sallyporthardCrossed -= 1;
                String SallyPortHardCrossedText = Integer.toString(sallyporthardCrossed);
                sallyporthardcrossedValueText.setText(SallyPortHardCrossedText);
            }
        });
        increaserockwalleasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rockwallCrossed += 1;
                String RockWallCrossedText = Integer.toString(rockwallCrossed);
                rockwalleasycrossedValueText.setText(RockWallCrossedText);
            }
        });
        decreaserockwalleasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rockwallCrossed -= 1;
                String RockWallCrossedText = Integer.toString(rockwallCrossed);
                rockwalleasycrossedValueText.setText(RockWallCrossedText);
            }
        });
        increaserockwallhardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rockwallhardCrossed += 1;
                String RockWallHardCrossedText = Integer.toString(rockwallhardCrossed);
                rockwallhardcrossedValueText.setText(RockWallHardCrossedText);
            }
        });
        decreaserockwallhardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rockwallhardCrossed -= 1;
                String RockWallHardCrossedText = Integer.toString(rockwallhardCrossed);
                rockwallhardcrossedValueText.setText(RockWallHardCrossedText);
            }
        });
        increaseroughterraineasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roughterrainCrossed += 1;
                String RoughTerrainCrossedText = Integer.toString(roughterrainCrossed);
                roughterraineasycrossedValueText.setText(RoughTerrainCrossedText);
            }
        });
        decreaseroughterraineasycrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roughterrainCrossed -= 1;
                String RoughTerrainCrossedText = Integer.toString(roughterrainCrossed);
                roughterraineasycrossedValueText.setText(RoughTerrainCrossedText);
            }
        });
        increaseroughterrainhardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roughterrainhardCrossed += 1;
                String RoughTerrainHardCrossedText = Integer.toString(roughterrainhardCrossed);
                roughterrainhardcrossedValueText.setText(RoughTerrainHardCrossedText);
            }
        });
        decreaseroughterrainhardcrossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roughterrainhardCrossed -= 1;
                String RoughTerrainHardCrossedText = Integer.toString(roughterrainhardCrossed);
                roughterrainhardcrossedValueText.setText(RoughTerrainHardCrossedText);
            }
        });
        robotchallengeyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robotChallenge = 1;
            }
        });
        robotchallengenoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robotChallenge = 0;
            }
        });
        robotclimbyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robotClimb = 1;
                revealclimboptions();
            }
        });
        robotclimbnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robotClimb = 0;
            }
        });
        climbspeedseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                climbSpeed = progresValue;
                climbspeedvalueText.setText(Integer.toString(climbSpeed));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        climbsuccesyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successfulclimb = 1;
            }
        });
        climbsuccesnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successfulclimb = 0;
            }
        });
        enterAccuracy_PrecisionDataButton = (Button) findViewById(R.id.enteraccuracy_precisiondataButton);
        enterAccuracy_PrecisionDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robotNotes = robotmatchnotesText.getEditableText().toString();
                loadscoutingScreen();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("shotsAmount", shotsAmount);
        outState.putInt("shotsScored", shotsScored);
        outState.putInt("lowgoalsScored", lowgoalsScored);
        outState.putInt("lowbarCrossed", lowbarCrossed);
        outState.putInt("lowbarhardCrossed", lowbarhardCrossed);
        outState.putInt("portcullisCrossed", portcullisCrossed);
        outState.putInt("portcullishardCrossed", portcullishardCrossed);
        outState.putInt("chevaldefriseCrossed", chevaldefriseCrossed);
        outState.putInt("chevaldefrisehardCrossed", chevaldefrisehardCrossed);
        outState.putInt("moatCrossed", moatCrossed);
        outState.putInt("moathardCrossed", moathardCrossed);
        outState.putInt("rampartsCrossed", rampartsCrossed);
        outState.putInt("rampartshardCrossed", rampartshardCrossed);
        outState.putInt("drawbridgeCrossed", drawbridgeCrossed);
        outState.putInt("drawbridgehardCrossed", drawbridgehardCrossed);
        outState.putInt("sallyportCrossed", sallyportCrossed);
        outState.putInt("sallyporthardCrossed", sallyporthardCrossed);
        outState.putInt("rockwallCrossed", rockwallCrossed);
        outState.putInt("rockwallhardCrossed", rockwallhardCrossed);
        outState.putInt("roughterrainCrossed", roughterrainCrossed);
        outState.putInt("roughterrainhardCrossed", roughterrainhardCrossed);
    }

    public void loadscoutingScreen() {
        Intent getData = getIntent();
        autoPeriodActivtated = getData.getIntExtra("AUTO", 0);
        spybotstart = getData.getIntExtra("SPYBOT", 0);
        defenseBreached = getData.getIntExtra("BREACHED", 0);
        autolowBar = getData.getIntExtra("AUTO_LOWBAR", 0);
        autoportCullis = getData.getIntExtra("AUTO_PORTCULLIS", 0);
        autochevaldeFrise = getData.getIntExtra("AUTO_CDF", 0);
        autoMoat = getData.getIntExtra("AUTO_MOAT", 0);
        autoRamparts = getData.getIntExtra("AUTO_RAMPARTS", 0);
        autodrawBridge = getData.getIntExtra("AUTO_DRAWBRIDGE", 0);
        autosallyPort = getData.getIntExtra("AUTO_SALLYPORT", 0);
        autorockWall = getData.getIntExtra("AUTO_ROCKWALL", 0);
        autoroughTerrain = getData.getIntExtra("AUTO_ROUGHTERRAIN", 0);
        autohighScored = getData.getIntExtra("HIGH", 0);
        autolowScored = getData.getIntExtra("LOW", 0);
        teamName = getData.getStringExtra("TEAMNAME");
        teamNumber = getData.getStringExtra("TEAMNUMBER");
        matchtype_number = getData.getIntExtra("MATCHTYPERNUMBER", 0);

        Intent intent = new Intent(this, ScoutingMenu.class);
        intent.putExtra("LOWBAR", lowbarCrossed);
        intent.putExtra("HARDLOWBAR", lowbarhardCrossed);
        intent.putExtra("PORTCULLIS", portcullisCrossed);
        intent.putExtra("HARDPORTCULLIS", portcullishardCrossed);
        intent.putExtra("CHEVALDEFRISE", chevaldefriseCrossed);
        intent.putExtra("HARDCHEVALDEFRISE", chevaldefrisehardCrossed);
        intent.putExtra("MOAT", moatCrossed);
        intent.putExtra("HARDMOAT", moathardCrossed);
        intent.putExtra("RAMPARTS", rampartsCrossed);
        intent.putExtra("HARDRAMPARTS", rampartshardCrossed);
        intent.putExtra("DRAWBRIDGE", drawbridgeCrossed);
        intent.putExtra("HARDDRAWBRIDGE", drawbridgehardCrossed);
        intent.putExtra("SALLYPORT", sallyportCrossed);
        intent.putExtra("HARDSALLYPORT", sallyporthardCrossed);
        intent.putExtra("ROCKWALL", rockwallCrossed);
        intent.putExtra("HARDROCKWALL", rockwallhardCrossed);
        intent.putExtra("ROUGHTERRAIN", roughterrainCrossed);
        intent.putExtra("HARDROUGHTERRAIN", roughterrainhardCrossed);
        intent.putExtra("SHOTS_AMOUNT", shotsAmount);
        intent.putExtra("SHOTS_SCORED", shotsScored);
        intent.putExtra("LOWGOALS_SCORED", lowgoalsScored);
        intent.putExtra("CHALLENGE", robotChallenge);
        intent.putExtra("ROBOT_CLIMBING", robotClimb);
        intent.putExtra("CLIMBING_SPEED", climbSpeed);
        intent.putExtra("CLIMB_SUCCESS", successfulclimb);
        intent.putExtra("ROBOTNOTES", robotNotes);
        intent.putExtra("AUTO", autoPeriodActivtated);
        intent.putExtra("SPYBOT", spybotstart);
        intent.putExtra("BREACHED", defenseBreached);
        intent.putExtra("AUTO_LOWBAR", autolowBar);
        intent.putExtra("AUTO_PORTCULLIS", autoportCullis);
        intent.putExtra("AUTO_CDF", autochevaldeFrise);
        intent.putExtra("AUTO_MOAT", autoMoat);
        intent.putExtra("AUTO_RAMPARTS", autoRamparts);
        intent.putExtra("AUTO_DRAWBRIDGE", autodrawBridge);
        intent.putExtra("AUTO_SALLYPORT", autosallyPort);
        intent.putExtra("AUTO_ROCKWALL", autorockWall);
        intent.putExtra("AUTO_ROUGHTERRAIN", autoroughTerrain);
        intent.putExtra("HIGH", autohighScored);
        intent.putExtra("LOW", autolowScored);
        intent.putExtra("TEAMNAME", teamName);
        intent.putExtra("TEAMNUMBER", teamNumber);
        intent.putExtra("MATCHTYPENUMBER", matchtype_number);
        setResult(Activity.RESULT_OK, intent);
        startActivity(intent);
    }

    public void revealclimboptions(){
        if (climbdetail2Text.getVisibility() == View.GONE) {
            climbdetail2Text.setVisibility(View.VISIBLE);
            climbspeedseekBar.setVisibility(View.VISIBLE);
            climbspeedvalueText.setVisibility(View.VISIBLE);
            climbdetail3Text.setVisibility(View.VISIBLE);
            climbsuccesyesButton.setVisibility(View.VISIBLE);
            climbsuccesnoButton.setVisibility(View.VISIBLE);
        }else{
            climbdetail2Text.setVisibility(View.GONE);
            climbspeedseekBar.setVisibility(View.GONE);
            climbspeedvalueText.setVisibility(View.GONE);
            climbdetail3Text.setVisibility(View.GONE);
            climbsuccesyesButton.setVisibility(View.GONE);
            climbsuccesnoButton.setVisibility(View.GONE);
        }
    }
    public void setSavedInts(){
        shotsamountValueText.setText(String.valueOf(shotsAmount));
        shotsscoredValueText.setText(String.valueOf(shotsScored));
        totalshotsamountValueText.setText(String.valueOf(shotsAmount));
        lowgoalsscoredText.setText(String.valueOf(lowgoalsScored));
        lowbareasycrossedValueText.setText(String.valueOf(lowbarCrossed));
        lowbarhardcrossedValueText.setText(String.valueOf(lowbarhardCrossed));
        portculliseasycrossedValueText.setText(String.valueOf(portcullisCrossed));
        portcullishardcrossedValueText.setText(String.valueOf(portcullishardCrossed));
        chevaldefriseeasycrossedValueText.setText(String.valueOf(chevaldefriseCrossed));
        chevaldefrisehardcrossedValueText.setText(String.valueOf(chevaldefrisehardCrossed));
        moateasycrossedValueText.setText(String.valueOf(moatCrossed));
        moathardcrossedValueText.setText(String.valueOf(moathardCrossed));
        rampartseasycrossedValueText.setText(String.valueOf(rampartsCrossed));
        rampartshardcrossedValueText.setText(String.valueOf(rampartshardCrossed));
        drawbridgeeasycrossedValueText.setText(String.valueOf(drawbridgeCrossed));
        drawbridgehardcrossedValueText.setText(String.valueOf(drawbridgehardCrossed));
        sallyporteasycrossedValueText.setText(String.valueOf(sallyportCrossed));
        sallyporthardcrossedValueText.setText(String.valueOf(sallyporthardCrossed));
        rockwalleasycrossedValueText.setText(String.valueOf(rockwallCrossed));
        rockwallhardcrossedValueText.setText(String.valueOf(rockwallhardCrossed));
        roughterraineasycrossedValueText.setText(String.valueOf(roughterrainCrossed));
        roughterrainhardcrossedValueText.setText(String.valueOf(roughterrainhardCrossed));
    }
}