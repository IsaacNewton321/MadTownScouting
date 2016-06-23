package com.example.robotics3.madtownscouting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TeamRoster extends AppCompatActivity {
    ListView teamrosterlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_roster);
        teamrosterlistView = (ListView)findViewById(R.id.teamrosterlistView);
    }
}
