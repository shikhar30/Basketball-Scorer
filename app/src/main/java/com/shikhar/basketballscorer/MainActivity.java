package com.shikhar.basketballscorer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int score;//scorer for team A
    int scoreB;//scorer for team B
    int n=0;
    int m=0;//keeping the count of the array list
    public static final String PREFS_NAME = "MyPrefsFile";
    int tA,tB,DA,DB,FA,Fb;
     String team1,team2;

    private int seconds; // to calculate the seconds
    private boolean running;// to save the state when the button is pressed in the boolean form

    public ArrayList<String> namesA= new ArrayList<>();//List to save the names of the team A
    public ArrayList<String> namesB=new ArrayList<>();//list to save the names of the team B
    public ArrayList<Integer> ScoreTeamA=new ArrayList<Integer>();  //list to score of team A
    public ArrayList<Integer> ScoreTeamB=new ArrayList<Integer>(); // list to score of team B


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        runTimer();
        if (savedInstanceState != null)
        {
            // Restore value of members from saved state
            namesA = savedInstanceState.getStringArrayList("teamA");
            namesB = savedInstanceState.getStringArrayList("teamB");
            ScoreTeamA=savedInstanceState.getIntegerArrayList("scoreA");
            ScoreTeamB=savedInstanceState.getIntegerArrayList("scoreB");
        }
        runTimer();

    }
    /*triple pointer for team A*/
    public void triplepointer(View v)
    {
        score+=3;
        displayScore(score);
        tA++;
    }
    /*double pointer for team A*/
    public void doublePointer(View v)
    {
        score+=2;
        displayScore(score);
        DA++;
    }
    /*free throw calculation for teamA*/
    public void freeThrow(View v)
    {
        score++;
        displayScore(score);
        FA++;
    }
    /*  triple point calculation for team B*/
    public void triplepoint(View v)
    {
        scoreB+=3;
        displayScoreB(scoreB);
        tB++;
    }
    /*  double point calculation for team B*/
    public void doublePoint(View v)
    {
        scoreB+=2;
        displayScoreB(scoreB);
        DB++;
    }
    /*free throw calculation for teamB*/
    public void free(View v)
    {
        scoreB++;
        displayScoreB(scoreB);
        Fb++;
    }

    /*score display for team B*/
    public void displayScoreB(int scoreB)
    {
        TextView tv=(TextView)findViewById(R.id.scoreB);
        tv.setText(String.valueOf(scoreB));
    }


    /*score display for teamA*/
    public void displayScore(int score)
    {
        TextView tv=(TextView)findViewById(R.id.scoretext);
        tv.setText(String.valueOf(score));
    }
    public void reset(View v)
    {
        score=0;
        scoreB=0;
        displayScore(score);
        displayScoreB(scoreB);
        tA=0;tB=0;DA=0;DB=0;FA=0;Fb=0;
    }
//Submit button click. and sending of data to the new intent
    public void Submit(View v)
    {
        n+=1;
        m+=1;
        addToStringList();
        addToIntegerList();
        running=false;

      Intent i=new Intent(this,Submit.class);seconds=0;
        i.putExtra("ThreePointerA",tA);
        i.putExtra("ThreepointerB",tB);
        i.putExtra("TwopointerA",DA);
        i.putExtra("TwopointerB",DB);
        i.putExtra("FreeThrowA",FA);
        i.putExtra("FreeThrowB",Fb);
        i.putExtra("ScoreA",score);
        i.putExtra("ScoreB",scoreB);
        i.putExtra("TeamA",team1);
        i.putExtra("TeamB",team2);
        startActivity(i);
       /* score=0;
        scoreB=0;
        displayScore(score);
        displayScoreB(scoreB);*/

    }
// making the array list of the names
    public void addToStringList(){

        EditText et=(EditText)findViewById(R.id.teamname);
        EditText et1=(EditText)findViewById(R.id.TeamB);
        team1=et.getText().toString();
        team2=et1.getText().toString();
        /*SubmitNamesA=team1;
        SubmitNamesB=team2;*/
        namesA.add(n-1,team1);
        namesB.add(n-1,team2);

    }



//making the arraylist of the scores


    public void addToIntegerList(){
        TextView tv=(TextView)findViewById(R.id.scoretext);
        TextView tv1=(TextView)findViewById(R.id.scoreB);
        int scoreA=Integer.parseInt(tv.getText().toString());
        int scoreB=Integer.parseInt(tv1.getText().toString());
        ScoreTeamA.add(m-1,scoreA);
        ScoreTeamB.add(m-1,scoreB);
    }


    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        // Save the user's current game state
        savedInstanceState.putStringArrayList("teamA", namesA);
        savedInstanceState.putIntegerArrayList("ScoreA",ScoreTeamA);
        savedInstanceState.putIntegerArrayList("ScoreB",ScoreTeamB);
        savedInstanceState.putStringArrayList("teamB",namesB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

//timer start button
    public void timerstarter(View view)
    {
        running=true;
    }

    //timer stop button

    public void timerStopper(View view)
    {
        running=false;
    }
//reset button for the timer
    public void resettimer(View v)
    {
        running=false;
        seconds=0;
    }
//handler and the method for the new thread of
    //timer. provides running of the timer in the background
    public void runTimer()
    {
        final TextView tv=(TextView)findViewById(R.id.timer);
        final Handler mHandler= new Handler() ;
       mHandler.post(new Runnable() {
           @Override
           public void run() {
               int hours=seconds/3600;
               int minutes=(seconds%3600)/60;
                int secs=seconds%60;
               String time= String.format("%02d:%02d:%02d",hours,minutes,secs);
               tv.setText(time);
               if(running) {
                   seconds++;
               }
               mHandler.postDelayed(this,1000);
               }

       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout rl=(RelativeLayout)findViewById(R.id.relative);

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.History) {
            Intent intent = new Intent(this,History.class);
            intent.putStringArrayListExtra("teamNameA",namesA);
            intent.putStringArrayListExtra("teamNameB",namesB);
            intent.putIntegerArrayListExtra("scoreofA",ScoreTeamA);
            intent.putIntegerArrayListExtra("scoreofB",ScoreTeamB);
            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }
}
