package com.shikhar.basketballscorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Submit extends AppCompatActivity {

    private int tA=0,tB=0,DA=0,DB=0,FA=0,Fb=0;
    private String SubmitNamesA,SubmitNamesB;
    int ScoreA, ScoreB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);




        Bundle extras = getIntent().getExtras();


        tA=extras.getInt("ThreePointerA");
        tB=extras.getInt("ThreepointerB");
        DA=extras.getInt("TwopointerA");
        DB=extras.getInt("TwopointerB");
        FA=extras.getInt("FreeThrowA");
        Fb=extras.getInt("FreeThrowB");
        ScoreA=extras.getInt("ScoreA");
        ScoreB=extras.getInt("ScoreB");
        SubmitNamesA=extras.getString("TeamA");
        SubmitNamesB=extras.getString("TeamB");

        TextView tv=(TextView)findViewById(R.id.submit_teamA);
        tv.setText(""+SubmitNamesA);
        TextView tv1=(TextView)findViewById(R.id.submit_teamB);
        tv1.setText(SubmitNamesB);
        TextView tv2=(TextView)findViewById(R.id.ThreePointer_teamAscore);
        tv2.setText(""+tA);
        TextView tv3=(TextView)findViewById(R.id.ThreePointer_teamBscore);
        tv3.setText(""+tB);
        TextView tv4=(TextView)findViewById(R.id.TwoPointer_teamAscore);
        tv4.setText(""+DA);
        TextView tv5=(TextView)findViewById(R.id.TwoPointer_teamBscore);
        tv5.setText(""+DB);
        TextView tv6=(TextView)findViewById(R.id.FreeThrow_teamAscore);
        tv6.setText(""+FA);
        TextView tv7=(TextView)findViewById(R.id.FreeThrow_teamBscore);
        tv7.setText(""+Fb);
        TextView tv8=(TextView)findViewById(R.id.submit_totalscoreteamA);
        tv8.setText(""+ScoreA);
        TextView tv9=(TextView)findViewById(R.id.submit_totalscoreteamB);
        tv9.setText(""+ScoreB);

        TextView tv10=(TextView)findViewById(R.id.Winner);

        if(ScoreA>ScoreB)
        {
            tv10.setText(SubmitNamesA);
        }
        else tv10.setText(SubmitNamesB);


    }

//  Whenever the activty as the back arrow is being used, call the function onOptionItemSelected
    //getSupportActionBar is called using this on call function
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}



