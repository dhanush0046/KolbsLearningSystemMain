package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;


public class GraphActivity extends AppCompatActivity {
    int op1Mark=0;
    int op2Mark=0;
    int op3Mark=0;
    int op4Mark=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        if (getIntent().hasExtra("o1") && getIntent().hasExtra("o2") && getIntent().hasExtra("o3") && getIntent().hasExtra("o4")){

            op1Mark= Integer.parseInt(getIntent().getStringExtra("o1"));
            op2Mark= Integer.parseInt(getIntent().getStringExtra("o2"));
            op3Mark= Integer.parseInt(getIntent().getStringExtra("o3"));
            op4Mark= Integer.parseInt(getIntent().getStringExtra("o4"));
        }

        RadarChart radarChart=findViewById(R.id.radarChart);

        ArrayList<RadarEntry> points=new ArrayList<>();

        points.add(new RadarEntry(op1Mark));
        points.add(new RadarEntry(op2Mark));
        points.add(new RadarEntry(op3Mark));
        points.add(new RadarEntry(op4Mark));

        RadarDataSet radarDataSet=new RadarDataSet(points,"Your Knowledge");
        radarDataSet.setColor(Color.RED);
        radarDataSet.setLineWidth(2f);
        radarDataSet.setValueTextColor(Color.RED);
        radarDataSet.setValueTextSize(14f);

        RadarData radarData=new RadarData();
        radarData.addDataSet(radarDataSet);

        String[] labels={"Feeling" , "Watching" , "Thinking" , "Doing"};
        XAxis xAxis=radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarChart.setData(radarData);


    }
}