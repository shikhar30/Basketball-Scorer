package com.shikhar.basketballscorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;


class CustomAdapter extends ArrayAdapter {

    List<String> namesA;
    List<String> namesB;
    List<Integer> scoreA;
    List<Integer> scoreB;
    LayoutInflater inflater;
    Context context;


    public CustomAdapter(Context context,  List<String> namesA,List<String> namesB,List<Integer> scoreA,List<Integer> scoreB) {
        super(context, R.layout.custom_row ,namesA);
        this.namesA=namesA;
        this.context=context;
        this.namesB=namesB;
        this.scoreA=scoreA;
        this.scoreB=scoreB;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




        inflater=LayoutInflater.from(getContext());
        View customview=inflater.inflate(R.layout.custom_row,parent,false);

        String data=namesA.get(position);
        String data1=namesB.get(position);
        Integer score1=scoreA.get(position);
        Integer score2=scoreB.get(position);
        TextView tv = (TextView) customview.findViewById(R.id.TeamAB);
        tv.setText(data);
        TextView tv1 = (TextView) customview.findViewById(R.id.teamBA);
        tv1.setText(data1);
        TextView sco=(TextView)customview.findViewById(R.id.scoreAB);
        sco.setText(""+score1);
        TextView scor=(TextView)customview.findViewById(R.id.scoreBA);
        scor.setText(""+score2);
        return customview;
    }
}
