package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Stattistical_Report extends AppCompatActivity{
    private static  String TAG = "Stattistical_Report";
    DbHandler db = new DbHandler(Stattistical_Report.this);

    TextView sample;
    private float[] ydata ={12f, 44.5f, 66.34f};
    private  String[] xdata = {"ako", "ikaw", "tayo"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stattistical__report);
        Log.d(TAG, "onCreate: starting to create chart");
        pieChart = (PieChart) findViewById(R.id.PieChart);
        pieChart.setDescription("");
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(5);
        pieChart.setTransparentCircleAlpha(0);
        sample = (TextView) findViewById(R.id.sample);

        ArrayList<HashMap<String, String>> userList = db.easyscore();

        pieChart.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        pieChart.setCenterTextSize(25);
      //  pieChart.setDrawEntryLabels(true);
        addDataSet(pieChart);

sample.setText((CharSequence) userList);
    }


    private void addDataSet(PieChart chart) {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys  = new ArrayList<>();
        ArrayList<PieEntry> xEntrys = new ArrayList<>();

        int i;
        for(i = 0; i < ydata.length; i++ ){
            yEntrys.add(new PieEntry(ydata[i] , i));
        }
        int z;
        for(z = 0; z < xdata.length; z++ ){
            xEntrys.add(new PieEntry(z, xdata[z]));
        }
        PieDataSet piedataset = new PieDataSet(yEntrys, "");

        piedataset.setValueTextSize(20);



        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        piedataset.setColors(colors);

//        Legend legend = pieChart.getLegend();
  //      legend.setForm(Legend.LegendForm.SQUARE);
    //    legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData piedata = new PieData(piedataset);
        pieChart.setData(piedata);
        pieChart.invalidate();

/*
pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.d(TAG, "onValueSelected: Value select from chart");
        Log.d(TAG, "onValueSelected: " + e.toString());
        Log.d(TAG, "onValueSelected: " + h.toString());
        int pos1 = toString().indexOf("(sum): ");
        String percent = e.toString().substring(pos1 + 7);
        for (int i = 0; i < ydata.length; i++){
      if (ydata[i] == Float.parseFloat(percent)){
          pos1 = i;
          break;


      }
        }


        String difficult = xdata[pos1 + 1];
            Toast.makeText(Stattistical_Report.this, difficult + " : " + pos1 + "K", Toast.LENGTH_SHORT).show();




    }

    @Override
    public void onNothingSelected() {

    }
});


*/

    }
}
