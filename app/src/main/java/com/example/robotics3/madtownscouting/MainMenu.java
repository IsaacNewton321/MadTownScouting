package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity {
    EditText searchBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button teamsButton = (Button)findViewById(R.id.teamsButton);
        Button scoutButton = (Button)findViewById(R.id.scoutButton);
        searchBox = (EditText)findViewById(R.id.searchField);
        Button enterSearch = (Button)findViewById(R.id.enterSearchButton);
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
    }

    public void loadteamRosterScreen(){
        Intent scoutingScreen = new Intent(this,TeamRoster.class);
        startActivity(scoutingScreen);
    }

    public void loadgameRosterScreen(){
        Intent gameRosterScreen = new Intent(this,GameRoster.class);
        startActivity(gameRosterScreen);
    }

    public void loadeventsRosterScreen(){
        Intent eventsRosterScreen = new Intent(this,EventsRoster.class);
        startActivity(eventsRosterScreen);
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
}
