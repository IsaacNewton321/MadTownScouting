package com.example.robotics3.madtownscouting;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robotics3.EditScreen;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MatchResults extends AppCompatActivity {
    Button preparedata;
    Button senddata;
    Button delete;
    ListView lv;
    SQLiteDatabase myDB = null;
    Cursor c;
    Cursor c1;
    MatchResultsAdapter matchAdapter;
    public ScoutingData MatchScouting;
    String address = "http://www.gorohi.com/1323/data.php";
    public boolean sendingData;
    int id = 0;
    String tNumber;
    String mNumber;

    public class ScoutingData {

        private String teamName;
        private String teamNumber;
        private String matchtype_number;

        public String activeAuto;
        public String spybotStart;
        public String defenseBreach;
        public String autolowBar;
        public String autoportCullis;
        public String autochevaldeFrise;
        public String autoMoat;
        public String autoRamparts;
        public String autodrawBridge;
        public String autosallyPort;
        public String autorocWall;
        public String autoroughTerrain;
        public String autohighScored;
        public String autolowScored;


        public String shotsFired;
        public String highgoalsScored;
        public String lowgoalsScored;
        public String lowbarCrossed;
        public String lowbarhardCrossed;
        public String portcullisCrossed;
        public String portcullishardCrossed;
        public String chevaldefriseCrossed;
        public String chevaldefrisehardCrossed;
        public String moatCrossed;
        public String moathardCrossed;
        public String rampartsCrossed;
        public String rampartshardCrossed;
        public String drawbridgeCrossed;
        public String drawbridgehardCrossed;
        public String sallyportCrossed;
        public String sallyporthardCrossed;
        public String rockwallCrossed;
        public String rockwallhardCrossed;
        public String roughterrainCrossed;
        public String roughterrainhardCrossed;
        public String robotChallenge;
        public String robotClimb;
        public String climbSpeed;
        public String climbSuccessful;
        public String robotNotes;

        public void LoadDatabase(int id) {
            myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
            c = myDB.rawQuery("SELECT * FROM MatchScouting WHERE _id =" + id, null);
            c.moveToFirst();
            int i = c.getCount();
            if (i > 0) {
                try {
                    teamName = c.getString(c.getColumnIndex("teamName"));
                    teamNumber = c.getString(c.getColumnIndex("teamNumber"));
                    matchtype_number = c.getString(c.getColumnIndex("matchtype_number"));
                    activeAuto = c.getString(c.getColumnIndex("activeAuto"));
                    spybotStart = c.getString(c.getColumnIndex("spybotStart"));
                    defenseBreach = c.getString(c.getColumnIndex("defenseBreach"));
                    autolowBar = c.getString(c.getColumnIndex("autolowBar"));
                    autoportCullis = c.getString(c.getColumnIndex("autoportCullis"));
                    autochevaldeFrise = c.getString(c.getColumnIndex("autochevaldeFrise"));
                    autoMoat = c.getString(c.getColumnIndex("autoMoat"));
                    autoRamparts = c.getString(c.getColumnIndex("autoRamparts"));
                    autodrawBridge = c.getString(c.getColumnIndex("autodrawBridge"));
                    autosallyPort = c.getString(c.getColumnIndex("autosallyPort"));
                    autorocWall = c.getString(c.getColumnIndex("autorockWall"));
                    autoroughTerrain = c.getString(c.getColumnIndex("autoroughTerrain"));
                    autohighScored = c.getString(c.getColumnIndex("autohighScored"));
                    autolowScored = c.getString(c.getColumnIndex("autolowScored"));
                    shotsFired = c.getString(c.getColumnIndex("shotsFired"));
                    highgoalsScored = c.getString(c.getColumnIndex("highGoalsScored"));
                    lowgoalsScored = c.getString(c.getColumnIndex("lowgoalsScored"));
                    lowbarCrossed = c.getString(c.getColumnIndex("lowbarCrossed"));
                    lowbarhardCrossed = c.getString(c.getColumnIndex("lowbarhardCrossed"));
                    portcullisCrossed = c.getString(c.getColumnIndex("portcullisCrossed"));
                    portcullishardCrossed = c.getString(c.getColumnIndex("portcullishardCrossed"));
                    chevaldefriseCrossed = c.getString(c.getColumnIndex("chevaldefriseCrossed"));
                    chevaldefrisehardCrossed = c.getString(c.getColumnIndex("chevaldefrisehardCrossed"));
                    moatCrossed = c.getString(c.getColumnIndex("moatCrossed"));
                    moathardCrossed = c.getString(c.getColumnIndex("moathardCrossed"));
                    rampartsCrossed = c.getString(c.getColumnIndex("rampartsCrossed"));
                    rampartshardCrossed = c.getString(c.getColumnIndex("rampartshardCrossed"));
                    drawbridgeCrossed = c.getString(c.getColumnIndex("drawbridgeCrossed"));
                    drawbridgehardCrossed = c.getString(c.getColumnIndex("drawbridgehardCrossed"));
                    sallyportCrossed = c.getString(c.getColumnIndex("sallyportCrossed"));
                    sallyporthardCrossed = c.getString(c.getColumnIndex("sallyporthardCrossed"));
                    rockwallCrossed = c.getString(c.getColumnIndex("rockwallCrossed"));
                    rockwallhardCrossed = c.getString(c.getColumnIndex("rockwallhardCrossed"));
                    roughterrainCrossed = c.getString(c.getColumnIndex("roughterrainCrossed"));
                    roughterrainhardCrossed = c.getString(c.getColumnIndex("roughterrainhardCrossed"));
                    robotChallenge = c.getString(c.getColumnIndex("robotChallenge"));
                    robotClimb = c.getString(c.getColumnIndex("robotClimb"));
                    climbSpeed = c.getString(c.getColumnIndex("climbSpeed"));
                    climbSuccessful = c.getString(c.getColumnIndex("climbSuccessful"));
                    robotNotes = c.getString(c.getColumnIndex("robotNotes"));
                } catch (Exception e) {
                    Log.d("ERROR", e.toString());
                }
            }
            c.close();
            myDB.close();
        }
    }


    public static String toJSon(ScoutingData data) {
        try {
            // Here we convert Java Object to JSON
            JSONObject Scouting = new JSONObject();
            Scouting.put("teamName", data.teamName); // Set the first name/pair
            Scouting.put("teamNumber", data.teamNumber);
            Scouting.put("matchtype_number", data.matchtype_number);

            JSONObject AutoPoints = new JSONObject();
            AutoPoints.put("activeAuto", data.activeAuto); // Set the first name/pair
            AutoPoints.put("spybotStart", data.spybotStart);
            AutoPoints.put("defenseBreach", data.defenseBreach);
            AutoPoints.put("autolowBar", data.autolowBar);
            AutoPoints.put("autoportCullis", data.autoportCullis);
            AutoPoints.put("autochevaldeFrise", data.autochevaldeFrise);
            AutoPoints.put("autoMoat", data.autoMoat);
            AutoPoints.put("autoRamparts", data.autoRamparts);
            AutoPoints.put("autodrawBridge", data.autodrawBridge);
            AutoPoints.put("autosallyPort", data.autosallyPort);
            AutoPoints.put("autorockWall", data.autorocWall);
            AutoPoints.put("autoroughTerrain", data.autoroughTerrain);
            AutoPoints.put("autohighScored", data.autohighScored);
            AutoPoints.put("autolowScored", data.autolowScored);

            Scouting.put("AutoPoints", AutoPoints);

            JSONObject TeleopPoints = new JSONObject();
            TeleopPoints.put("shotsFired", data.shotsFired);
            TeleopPoints.put("highgoalsScored", data.highgoalsScored);
            TeleopPoints.put("lowgoalsScored", data.lowgoalsScored);
            TeleopPoints.put("lowbarCrossed", data.lowbarCrossed);
            TeleopPoints.put("lowbarhardCrossed", data.lowbarhardCrossed);
            TeleopPoints.put("portcullisCrossed", data.portcullisCrossed);
            TeleopPoints.put("portcullishardCrossed", data.portcullishardCrossed);
            TeleopPoints.put("chevaldefriseCrossed", data.chevaldefriseCrossed);
            TeleopPoints.put("chevaldefrisehardCrossed", data.chevaldefrisehardCrossed);
            TeleopPoints.put("moatCrossed", data.moatCrossed);
            TeleopPoints.put("moathardCrossed", data.moathardCrossed);
            TeleopPoints.put("rampartsCrossed", data.rampartsCrossed);
            TeleopPoints.put("rampartshardCrossed", data.rampartshardCrossed);
            TeleopPoints.put("drawbridgeCrossed", data.drawbridgeCrossed);
            TeleopPoints.put("drawbridgehardCrossed", data.drawbridgehardCrossed);
            TeleopPoints.put("sallyportCrossed", data.sallyportCrossed);
            TeleopPoints.put("sallyporthardCrossed", data.sallyporthardCrossed);
            TeleopPoints.put("rockwallCrossed", data.rockwallCrossed);
            TeleopPoints.put("rockwallhardCrossed", data.rockwallhardCrossed);
            TeleopPoints.put("roughterrainCrossed", data.roughterrainCrossed);
            TeleopPoints.put("roughterrainhardCrossed", data.roughterrainhardCrossed);
            TeleopPoints.put("robotChallenged", data.robotChallenge);
            TeleopPoints.put("robotClimb", data.robotClimb);
            TeleopPoints.put("climbSpeed", data.climbSpeed);
            TeleopPoints.put("climbSuccessful", data.climbSuccessful);
            TeleopPoints.put("robotNotes",data.robotNotes);

            Scouting.put("TeleopPoints", TeleopPoints);

            return Scouting.toString();
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_results);
        MatchScouting = new ScoutingData();
        myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
        c1 = myDB.rawQuery("SELECT * FROM MatchScouting", null);
        int i = c1.getCount();
        if(i>0){
            try {
                lv = (ListView) findViewById(R.id.matchresultslistView);
                matchAdapter = new MatchResultsAdapter(MatchResults.this, c1, 0);
                lv.setAdapter(matchAdapter);
                lv.setLongClickable(true);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                        Cursor cur = (Cursor) matchAdapter.getItem(position);
                        cur.moveToPosition(position);
                        tNumber = cur.getString(cur.getColumnIndex("teamNumber"));
                        mNumber = cur.getString(cur.getColumnIndexOrThrow("matchtype_number"));
                        // Identifies the match number of the list component that you clicked, and prepares
                        // the values of the ScoutingData instance with the data from that list component
                        // so that when you click the send data button it will send the data from the match that you have last clicked on
                        id = Integer.valueOf(cur.getString(cur.getColumnIndexOrThrow("_id")));
                        MatchScouting.LoadDatabase(id);
                        Toast.makeText(getApplicationContext(),"Team "+ tNumber+ ", Match "+ mNumber+ " selected", Toast.LENGTH_SHORT).show();
                    }
                });
                lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    int pos, long id) {
                // TODO Auto-generated method stub
                Cursor cur = (Cursor) matchAdapter.getItem(pos);
                cur.moveToPosition(pos);
                int editID = Integer.valueOf(cur.getString(cur.getColumnIndex("_id")));
                Intent editIntent = new Intent(getBaseContext(), EditScreen.class);
                editIntent.putExtra("ID", editID);
                startActivityForResult(editIntent, 1);
                return true;
            }
        });
            }catch(Exception e){
                Log.d("ERROR",e.toString());
            }
        }
        preparedata = (Button) findViewById(R.id.preparedataButton);
        senddata = (Button) findViewById(R.id.senddataButton);
        delete = (Button) findViewById(R.id.deleteBtn);

        preparedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                id = intent.getIntExtra("ID", 0);
                MatchScouting.LoadDatabase(id);
            }
        });
        senddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = toJSon(MatchScouting);
                new MyAsyncTask().execute(json);
            }
        });
        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                myDB = openOrCreateDatabase("FRC", MODE_PRIVATE, null);
                myDB.execSQL("DELETE FROM MatchScouting WHERE _id = " + id);
                myDB.close();
                Toast.makeText(getApplicationContext(),"Team "+ tNumber + ", Match " + mNumber + " deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    private class MyAsyncTask extends AsyncTask<String, Integer, Double> {
        String response = "";
        @Override
        protected Double doInBackground(String... params) {
            postData(params[0]);
            return null;
        }
        protected void onPostExecute(Double result){
            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
        }


        public void postData(String jsonString) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(address);
            InputStream inputStream = null;
            try {
                List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
                nameValuePair.add(new BasicNameValuePair("data", jsonString));
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

                } catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
                HttpResponse httpResponse = httpClient.execute(httpPost);
                inputStream = httpResponse.getEntity().getContent();
                if(inputStream != null)
                {
                    response = convertInputStreamToString(inputStream);
                }
                else
                {
                    response = "Did not Work!";
                }
                inputStream.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(Integer.parseInt(android.os.Build.VERSION.SDK)> 5
                && keyCode == KeyEvent.KEYCODE_BACK){
            c1.close();
            myDB.close();
        }
        return super.onKeyDown(keyCode, event);
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
        {
            result += line;
        }
        inputStream.close();
        return result;
    }

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 1) {
        if(resultCode == Activity.RESULT_OK){
            
        }
        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getApplicationContext(),"Team " + , Toast.LENGTH_SHORT).show();
        }
    }
}
}
