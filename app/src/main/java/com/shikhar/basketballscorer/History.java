package com.shikhar.basketballscorer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shikhar.basketballscorer.*;
import java.util.ArrayList;

public class History extends Activity {

    ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar tv=(Toolbar)findViewById(R.id.toolbar);

        //Method to place a back arrow button in toolbar, drawable image is eventually there
       tv.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));// back button present in the support library
        tv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); //method to go back to the precious page
            }
        });



        tv.setTitle("History");
        ArrayList<String> A=(ArrayList<String>)getIntent().getStringArrayListExtra("teamNameA");//team names of A are taken from MainActivity
        ArrayList<String> B=(ArrayList<String>)getIntent().getStringArrayListExtra("teamNameB");//team Names of B are taken from mainActivity
        ArrayList<Integer> scA=(ArrayList<Integer>)getIntent().getIntegerArrayListExtra("scoreofA"); //score of A is taken from Mainactivity
        ArrayList<Integer> scB=(ArrayList<Integer>)getIntent().getIntegerArrayListExtra("scoreofB"); //score of B is taken from Mainactivity

        lv=(ListView)findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new CustomAdapter(this,A,B,scA,scB);

        // ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_2);
        // lv.setAdapter(adapter);
        lv.setAdapter(arrayAdapter);


    }



}

