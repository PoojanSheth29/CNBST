package com.myappgen2020.cnbst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    float count_dsa[] = new float[18];
    float count_da[]= new float[18];
    float count_n[] = new float[18];
    float  count_a[] = new float[18];
    float count_sa[] = new float[18];

    
    
    
    
    
    Button button;
    ImageView img_piechart;
    private PieChart pieChart1,pieChart2,pieChart3,pieChart4,pieChart5,pieChart6,pieChart7,pieChart8,pieChart9,pieChart10,pieChart11,pieChart12,pieChart13,pieChart14,pieChart15,pieChart16,pieChart17;

    ArrayList<Bean> universal_admin ;
    FirebaseDatabase database;
    DatabaseReference myref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_piechart = findViewById(R.id.img_piechart);
        pieChart1 = findViewById(R.id.activity_main_piechart1);
        pieChart2 = findViewById(R.id.activity_main_piechart2);
        pieChart3 = findViewById(R.id.activity_main_piechart3);
        pieChart4 = findViewById(R.id.activity_main_piechart4);
        pieChart5 = findViewById(R.id.activity_main_piechart5);
        pieChart6 = findViewById(R.id.activity_main_piechart6);
        pieChart7 = findViewById(R.id.activity_main_piechart7);
        pieChart8 = findViewById(R.id.activity_main_piechart8);
        pieChart9 = findViewById(R.id.activity_main_piechart9);
        pieChart10 = findViewById(R.id.activity_main_piechart10);
        pieChart11 = findViewById(R.id.activity_main_piechart11);
        pieChart12 = findViewById(R.id.activity_main_piechart12);
        pieChart13 = findViewById(R.id.activity_main_piechart13);
        pieChart14 = findViewById(R.id.activity_main_piechart14);
        pieChart15 = findViewById(R.id.activity_main_piechart15);
        pieChart16 = findViewById(R.id.activity_main_piechart16);
        pieChart17 = findViewById(R.id.activity_main_piechart17);





        button = findViewById(R.id.btn_try123);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("Users");
        System.out.println("in load firebase");
        loadFirebaseData();
        img_piechart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();

            }
        });

        //System.out.println(excelWrite.universal);



        //  calculation();

    }

    private void loadFirebaseData()
    {
        universal_admin = new ArrayList<>();
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Bean bean  = dataSnapshot.getValue(Bean.class);
                    universal_admin.add(bean);

                }
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });


    }


    private void setupPieChart() {
        pieChart1.setDrawHoleEnabled(true);
        pieChart1.setUsePercentValues(true);
        pieChart1.setEntryLabelTextSize(12);
        pieChart1.setEntryLabelColor(Color.BLACK);
        pieChart1.setCenterText("Question 1");
        pieChart1.setCenterTextSize(24);
        pieChart1.getDescription().setEnabled(false);

        pieChart2.setDrawHoleEnabled(true);
        pieChart2.setUsePercentValues(true);
        pieChart2.setEntryLabelTextSize(12);
        pieChart2.setEntryLabelColor(Color.BLACK);
        pieChart2.setCenterText("Question 2");
        pieChart2.setCenterTextSize(24);
        pieChart2.getDescription().setEnabled(false);

        pieChart3.setDrawHoleEnabled(true);
        pieChart3.setUsePercentValues(true);
        pieChart3.setEntryLabelTextSize(12);
        pieChart3.setEntryLabelColor(Color.BLACK);
        pieChart3.setCenterText("Question 3");
        pieChart3.setCenterTextSize(24);
        pieChart3.getDescription().setEnabled(false);

        pieChart4.setDrawHoleEnabled(true);
        pieChart4.setUsePercentValues(true);
        pieChart4.setEntryLabelTextSize(12);
        pieChart4.setEntryLabelColor(Color.BLACK);
        pieChart4.setCenterText("Question 4");
        pieChart4.setCenterTextSize(24);
        pieChart4.getDescription().setEnabled(false);

        pieChart5.setDrawHoleEnabled(true);
        pieChart5.setUsePercentValues(true);
        pieChart5.setEntryLabelTextSize(12);
        pieChart5.setEntryLabelColor(Color.BLACK);
        pieChart5.setCenterText("Question 5");
        pieChart5.setCenterTextSize(24);
        pieChart5.getDescription().setEnabled(false);

        pieChart6.setDrawHoleEnabled(true);
        pieChart6.setUsePercentValues(true);
        pieChart6.setEntryLabelTextSize(12);
        pieChart6.setEntryLabelColor(Color.BLACK);
        pieChart6.setCenterText("Question 6");
        pieChart6.setCenterTextSize(24);
        pieChart6.getDescription().setEnabled(false);

        pieChart7.setDrawHoleEnabled(true);
        pieChart7.setUsePercentValues(true);
        pieChart7.setEntryLabelTextSize(12);
        pieChart7.setEntryLabelColor(Color.BLACK);
        pieChart7.setCenterText("Question 7");
        pieChart7.setCenterTextSize(24);
        pieChart7.getDescription().setEnabled(false);

        pieChart8.setDrawHoleEnabled(true);
        pieChart8.setUsePercentValues(true);
        pieChart8.setEntryLabelTextSize(12);
        pieChart8.setEntryLabelColor(Color.BLACK);
        pieChart8.setCenterText("Question 8");
        pieChart8.setCenterTextSize(24);
        pieChart8.getDescription().setEnabled(false);

        pieChart9.setDrawHoleEnabled(true);
        pieChart9.setUsePercentValues(true);
        pieChart9.setEntryLabelTextSize(12);
        pieChart9.setEntryLabelColor(Color.BLACK);
        pieChart9.setCenterText("Question 1");
        pieChart9.setCenterTextSize(24);
        pieChart9.getDescription().setEnabled(false);

        pieChart10.setDrawHoleEnabled(true);
        pieChart10.setUsePercentValues(true);
        pieChart10.setEntryLabelTextSize(12);
        pieChart10.setEntryLabelColor(Color.BLACK);
        pieChart10.setCenterText("Question 10");
        pieChart10.setCenterTextSize(24);
        pieChart10.getDescription().setEnabled(false);


        pieChart11.setDrawHoleEnabled(true);
        pieChart11.setUsePercentValues(true);
        pieChart11.setEntryLabelTextSize(12);
        pieChart11.setEntryLabelColor(Color.BLACK);
        pieChart11.setCenterText("Question 11");
        pieChart11.setCenterTextSize(24);
        pieChart11.getDescription().setEnabled(false);

        pieChart12.setDrawHoleEnabled(true);
        pieChart12.setUsePercentValues(true);
        pieChart12.setEntryLabelTextSize(12);
        pieChart12.setEntryLabelColor(Color.BLACK);
        pieChart12.setCenterText("Question 12");
        pieChart12.setCenterTextSize(24);
        pieChart12.getDescription().setEnabled(false);

        pieChart13.setDrawHoleEnabled(true);
        pieChart13.setUsePercentValues(true);
        pieChart13.setEntryLabelTextSize(12);
        pieChart13.setEntryLabelColor(Color.BLACK);
        pieChart13.setCenterText("Question 13");
        pieChart13.setCenterTextSize(24);
        pieChart13.getDescription().setEnabled(false);


        pieChart14.setDrawHoleEnabled(true);
        pieChart14.setUsePercentValues(true);
        pieChart14.setEntryLabelTextSize(12);
        pieChart14.setEntryLabelColor(Color.BLACK);
        pieChart14.setCenterText("Question 14");
        pieChart14.setCenterTextSize(24);
        pieChart14.getDescription().setEnabled(false);

        pieChart15.setDrawHoleEnabled(true);
        pieChart15.setUsePercentValues(true);
        pieChart15.setEntryLabelTextSize(12);
        pieChart15.setEntryLabelColor(Color.BLACK);
        pieChart15.setCenterText("Question 15");
        pieChart15.setCenterTextSize(24);
        pieChart15.getDescription().setEnabled(false);

        pieChart16.setDrawHoleEnabled(true);
        pieChart16.setUsePercentValues(true);
        pieChart16.setEntryLabelTextSize(12);
        pieChart16.setEntryLabelColor(Color.BLACK);
        pieChart16.setCenterText("Question 16");
        pieChart16.setCenterTextSize(24);
        pieChart16.getDescription().setEnabled(false);

        pieChart17.setDrawHoleEnabled(true);
        pieChart17.setUsePercentValues(true);
        pieChart17.setEntryLabelTextSize(12);
        pieChart17.setEntryLabelColor(Color.BLACK);
        pieChart17.setCenterText("Question 17");
        pieChart17.setCenterTextSize(24);
        pieChart17.getDescription().setEnabled(false);


//        Legend l1 = pieChart1.getLegend();
//        l1.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l1.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l1.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l1.setDrawInside(false);
//        l1.setEnabled(true);
//
//        Legend l2 = pieChart1.getLegend();
//        l2.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l2.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l2.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l2.setDrawInside(false);
//        l2.setEnabled(true);
//
//        Legend l3 = pieChart1.getLegend();
//        l3.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l3.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l3.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l3.setDrawInside(false);
//        l3.setEnabled(true);
//
//        Legend l4 = pieChart1.getLegend();
//        l4.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l4.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l4.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l4.setDrawInside(false);
//        l4.setEnabled(true);
//
//        Legend l5 = pieChart1.getLegend();
//        l5.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l5.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l5.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l5.setDrawInside(false);
//        l5.setEnabled(true);
//
//        Legend l6 = pieChart1.getLegend();
//        l6.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l6.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l6.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l6.setDrawInside(false);
//        l6.setEnabled(true);
//
//        Legend l7 = pieChart1.getLegend();
//        l7.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l7.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l7.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l7.setDrawInside(false);
//        l7.setEnabled(true);
//
//        Legend l8 = pieChart1.getLegend();
//        l8.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l8.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l8.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l8.setDrawInside(false);
//        l8.setEnabled(true);
//
//        Legend l9 = pieChart1.getLegend();
//        l9.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l9.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l9.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l9.setDrawInside(false);
//        l9.setEnabled(true);
//
//        Legend l10 = pieChart1.getLegend();
//        l10.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l10.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l10.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l10.setDrawInside(false);
//        l10.setEnabled(true);
//
//        Legend l11 = pieChart1.getLegend();
//        l11.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l11.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l11.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l11.setDrawInside(false);
//        l11.setEnabled(true);
//
//        Legend l12 = pieChart1.getLegend();
//        l12.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l12.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l12.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l12.setDrawInside(false);
//        l12.setEnabled(true);
//
//
//        Legend l13 = pieChart1.getLegend();
//        l13.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l13.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l13.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l13.setDrawInside(false);
//        l13.setEnabled(true);
//
//        Legend l14 = pieChart1.getLegend();
//        l14.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l14.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l14.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l14.setDrawInside(false);
//        l14.setEnabled(true);
//
//        Legend l15 = pieChart1.getLegend();
//        l15.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l15.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l15.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l15.setDrawInside(false);
//        l15.setEnabled(true);
//
//        Legend l16 = pieChart1.getLegend();
//        l16.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l16.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l16.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l16.setDrawInside(false);
//        l16.setEnabled(true);
//
//        Legend l17 = pieChart1.getLegend();
//        l17.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l17.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l17.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l17.setDrawInside(false);
//        l17.setEnabled(true);
//
//
//
//
        loadPieChartData();
    }
//
    private void loadPieChartData() {
        ArrayList<PieEntry> entries1 = new ArrayList<>();
        ArrayList<PieEntry> entries2 = new ArrayList<>();
        ArrayList<PieEntry> entries3 = new ArrayList<>();
        ArrayList<PieEntry> entries4 = new ArrayList<>();
        ArrayList<PieEntry> entries5 = new ArrayList<>();
        ArrayList<PieEntry> entries6 = new ArrayList<>();
        ArrayList<PieEntry> entries7 = new ArrayList<>();
        ArrayList<PieEntry> entries8 = new ArrayList<>();
        ArrayList<PieEntry> entries9 = new ArrayList<>();
        ArrayList<PieEntry> entries10 = new ArrayList<>();
        ArrayList<PieEntry> entries11 = new ArrayList<>();
        ArrayList<PieEntry> entries12 = new ArrayList<>();
        ArrayList<PieEntry> entries13 = new ArrayList<>();
        ArrayList<PieEntry> entries14 = new ArrayList<>();
        ArrayList<PieEntry> entries15 = new ArrayList<>();
        ArrayList<PieEntry> entries16 = new ArrayList<>();
        ArrayList<PieEntry> entries17 = new ArrayList<>();
        
        
        
        entries1.add(new PieEntry(count_dsa[1], "Strongly DisAgreed"));
        entries1.add(new PieEntry(count_da[1], "DisAgreed"));
        entries1.add(new PieEntry(count_n[1], "Neutral"));
        entries1.add(new PieEntry(count_a[1], "Agreed"));
        entries1.add(new PieEntry(count_sa[1], "Strongly Agreed"));

        entries2.add(new PieEntry(count_dsa[2], "Strongly DisAgreed"));
        entries2.add(new PieEntry(count_da[2], "DisAgreed"));
        entries2.add(new PieEntry(count_n[2], "Neutral"));
        entries2.add(new PieEntry(count_a[2], "Agreed"));
        entries2.add(new PieEntry(count_sa[2], "Strongly Agreed"));

        entries3.add(new PieEntry(count_dsa[3], "Strongly DisAgreed"));
        entries3.add(new PieEntry(count_da[3], "DisAgreed"));
        entries3.add(new PieEntry(count_n[3], "Neutral"));
        entries3.add(new PieEntry(count_a[3], "Agreed"));
        entries3.add(new PieEntry(count_sa[3], "Strongly Agreed"));

        entries4.add(new PieEntry(count_dsa[4], "Strongly DisAgreed"));
        entries4.add(new PieEntry(count_da[4], "DisAgreed"));
        entries4.add(new PieEntry(count_n[4], "Neutral"));
        entries4.add(new PieEntry(count_a[4], "Agreed"));
        entries4.add(new PieEntry(count_sa[4], "Strongly Agreed"));

        entries5.add(new PieEntry(count_dsa[5], "Strongly DisAgreed"));
        entries5.add(new PieEntry(count_da[5], "DisAgreed"));
        entries5.add(new PieEntry(count_n[5], "Neutral"));
        entries5.add(new PieEntry(count_a[5], "Agreed"));
        entries5.add(new PieEntry(count_sa[5], "Strongly Agreed"));

        entries6.add(new PieEntry(count_dsa[6], "Strongly DisAgreed"));
        entries6.add(new PieEntry(count_da[6], "DisAgreed"));
        entries6.add(new PieEntry(count_n[6], "Neutral"));
        entries6.add(new PieEntry(count_a[6], "Agreed"));
        entries6.add(new PieEntry(count_sa[6], "Strongly Agreed"));

        entries7.add(new PieEntry(count_dsa[7], "Strongly DisAgreed"));
        entries7.add(new PieEntry(count_da[7], "DisAgreed"));
        entries7.add(new PieEntry(count_n[7], "Neutral"));
        entries7.add(new PieEntry(count_a[7], "Agreed"));
        entries7.add(new PieEntry(count_sa[7], "Strongly Agreed"));

        entries8.add(new PieEntry(count_dsa[8], "Strongly DisAgreed"));
        entries8.add(new PieEntry(count_da[8], "DisAgreed"));
        entries8.add(new PieEntry(count_n[8], "Neutral"));
        entries8.add(new PieEntry(count_a[8], "Agreed"));
        entries8.add(new PieEntry(count_sa[8], "Strongly Agreed"));

        entries9.add(new PieEntry(count_dsa[9], "Strongly DisAgreed"));
        entries9.add(new PieEntry(count_da[9], "DisAgreed"));
        entries9.add(new PieEntry(count_n[9], "Neutral"));
        entries9.add(new PieEntry(count_a[9], "Agreed"));
        entries9.add(new PieEntry(count_sa[9], "Strongly Agreed"));

        entries10.add(new PieEntry(count_dsa[10], "Strongly DisAgreed"));
        entries10.add(new PieEntry(count_da[10], "DisAgreed"));
        entries10.add(new PieEntry(count_n[10], "Neutral"));
        entries10.add(new PieEntry(count_a[10], "Agreed"));
        entries10.add(new PieEntry(count_sa[10], "Strongly Agreed"));

        entries11.add(new PieEntry(count_dsa[11], "Strongly DisAgreed"));
        entries11.add(new PieEntry(count_da[11], "DisAgreed"));
        entries11.add(new PieEntry(count_n[11], "Neutral"));
        entries11.add(new PieEntry(count_a[11], "Agreed"));
        entries11.add(new PieEntry(count_sa[11], "Strongly Agreed"));

        entries12.add(new PieEntry(count_dsa[12], "Strongly DisAgreed"));
        entries12.add(new PieEntry(count_da[12], "DisAgreed"));
        entries12.add(new PieEntry(count_n[12], "Neutral"));
        entries12.add(new PieEntry(count_a[12], "Agreed"));
        entries12.add(new PieEntry(count_sa[12], "Strongly Agreed"));

        entries13.add(new PieEntry(count_dsa[13], "Strongly DisAgreed"));
        entries13.add(new PieEntry(count_da[13], "DisAgreed"));
        entries13.add(new PieEntry(count_n[13], "Neutral"));
        entries13.add(new PieEntry(count_a[13], "Agreed"));
        entries13.add(new PieEntry(count_sa[13], "Strongly Agreed"));

        entries14.add(new PieEntry(count_dsa[14], "Strongly DisAgreed"));
        entries14.add(new PieEntry(count_da[14], "DisAgreed"));
        entries14.add(new PieEntry(count_n[14], "Neutral"));
        entries14.add(new PieEntry(count_a[14], "Agreed"));
        entries14.add(new PieEntry(count_sa[14], "Strongly Agreed"));

        entries15.add(new PieEntry(count_dsa[15], "Strongly DisAgreed"));
        entries15.add(new PieEntry(count_da[15], "DisAgreed"));
        entries15.add(new PieEntry(count_n[15], "Neutral"));
        entries15.add(new PieEntry(count_a[15], "Agreed"));
        entries15.add(new PieEntry(count_sa[15], "Strongly Agreed"));

        entries16.add(new PieEntry(count_dsa[16], "Strongly DisAgreed"));
        entries16.add(new PieEntry(count_da[16], "DisAgreed"));
        entries16.add(new PieEntry(count_n[16], "Neutral"));
        entries16.add(new PieEntry(count_a[16], "Agreed"));
        entries16.add(new PieEntry(count_sa[16], "Strongly Agreed"));

        entries17.add(new PieEntry(count_dsa[17], "Strongly DisAgreed"));
        entries17.add(new PieEntry(count_da[17], "DisAgreed"));
        entries17.add(new PieEntry(count_n[17], "Neutral"));
        entries17.add(new PieEntry(count_a[17], "Agreed"));
        entries17.add(new PieEntry(count_sa[17], "Strongly Agreed"));


        ArrayList<Integer> colors = new ArrayList<>();
        for (int color : ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet1 = new PieDataSet(entries1, "");
        dataSet1.setColors(colors);

        PieData data1 = new PieData(dataSet1);
        //data1//.setDrawValues(true);
        data1.setValueFormatter(new PercentFormatter(pieChart1));
        data1.setValueTextSize(12f);
        data1.setValueTextColor(Color.BLACK);

        PieDataSet dataSet2 = new PieDataSet(entries2,"");
        dataSet2.setColors(colors);
        PieData data2 = new PieData(dataSet2);
        //data2//.setDrawValues(true);
        data2.setValueFormatter(new PercentFormatter(pieChart1));
        data2.setValueTextSize(12f);
        data2.setValueTextColor(Color.BLACK);

        PieDataSet dataSet3 = new PieDataSet(entries3, "Label");
        dataSet3.setColors(colors);
        PieData data3 = new PieData(dataSet3);
        //data3//.setDrawValues(true);
        data3.setValueFormatter(new PercentFormatter(pieChart1));
        data3.setValueTextSize(12f);
        data3.setValueTextColor(Color.BLACK);

        PieDataSet dataSet4 = new PieDataSet(entries4, "Label");
        dataSet4.setColors(colors);
        PieData data4 = new PieData(dataSet4);
        //data4//.setDrawValues(true);
        data4.setValueFormatter(new PercentFormatter(pieChart1));
        data4.setValueTextSize(12f);
        data4.setValueTextColor(Color.BLACK);

        PieDataSet dataSet5 = new PieDataSet(entries5, "Label");
        dataSet5.setColors(colors);
        PieData data5 = new PieData(dataSet5);
        //data5//.setDrawValues(true);
        data5.setValueFormatter(new PercentFormatter(pieChart1));
        data5.setValueTextSize(12f);
        data5.setValueTextColor(Color.BLACK);

        PieDataSet dataSet6 = new PieDataSet(entries6, "Label");
        dataSet6.setColors(colors);
        PieData data6 = new PieData(dataSet6);
        //data6//.setDrawValues(true);
        data6.setValueFormatter(new PercentFormatter(pieChart1));
        data6.setValueTextSize(12f);
        data6.setValueTextColor(Color.BLACK);

        PieDataSet dataSet7 = new PieDataSet(entries7, "Label");
        dataSet7.setColors(colors);
        PieData data7 = new PieData(dataSet7);
        //data7//.setDrawValues(true);
        data7.setValueFormatter(new PercentFormatter(pieChart1));
        data7.setValueTextSize(12f);
        data7.setValueTextColor(Color.BLACK);

        PieDataSet dataSet8 = new PieDataSet(entries8, "Label");
        dataSet8.setColors(colors);
        PieData data8 = new PieData(dataSet8);
       // data8//.setDrawValues(true);
        data8.setValueFormatter(new PercentFormatter(pieChart1));
        data8.setValueTextSize(12f);
        data8.setValueTextColor(Color.BLACK);

        PieDataSet dataSet9 = new PieDataSet(entries9, "Label");
        dataSet9.setColors(colors);
        PieData data9 = new PieData(dataSet8);
        //data9//.setDrawValues(true);
        data9.setValueFormatter(new PercentFormatter(pieChart1));
        data9.setValueTextSize(12f);
        data9.setValueTextColor(Color.BLACK);

        PieDataSet dataSet10 = new PieDataSet(entries10, "Label");
        dataSet10.setColors(colors);
        PieData data10 = new PieData(dataSet10);
        //data10//.setDrawValues(true);
        data10.setValueFormatter(new PercentFormatter(pieChart1));
        data10.setValueTextSize(12f);
        data10.setValueTextColor(Color.BLACK);


        PieDataSet dataSet11 = new PieDataSet(entries11, "Label");
        dataSet11.setColors(colors);
        PieData data11 = new PieData(dataSet11);
        //data11//.setDrawValues(true);
        data11.setValueFormatter(new PercentFormatter(pieChart1));
        data11.setValueTextSize(12f);
        data11.setValueTextColor(Color.BLACK);

        PieDataSet dataSet12 = new PieDataSet(entries12, "Label");
        dataSet12.setColors(colors);
        PieData data12 = new PieData(dataSet12);
        //data12//.setDrawValues(true);
        data12.setValueFormatter(new PercentFormatter(pieChart1));
        data12.setValueTextSize(12f);
        data12.setValueTextColor(Color.BLACK);


        PieDataSet dataSet13 = new PieDataSet(entries13, "Label");
        dataSet13.setColors(colors);
        PieData data13 = new PieData(dataSet13);
        //data13//.setDrawValues(true);
        data13.setValueFormatter(new PercentFormatter(pieChart1));
        data13.setValueTextSize(12f);
        data13.setValueTextColor(Color.BLACK);


        PieDataSet dataSet14 = new PieDataSet(entries14, "Label");
        dataSet14.setColors(colors);
        PieData data14 = new PieData(dataSet14);
       // data14//.setDrawValues(true);
        data14.setValueFormatter(new PercentFormatter(pieChart1));
        data14.setValueTextSize(12f);
        data14.setValueTextColor(Color.BLACK);

        PieDataSet dataSet15 = new PieDataSet(entries15, "Label");
        dataSet15.setColors(colors);
        PieData data15 = new PieData(dataSet15);
        //data15//.setDrawValues(true);
        data15.setValueFormatter(new PercentFormatter(pieChart1));
        data15.setValueTextSize(12f);
        data15.setValueTextColor(Color.BLACK);

        PieDataSet dataSet16 = new PieDataSet(entries16, "Label");
        dataSet16.setColors(colors);
        PieData data16 = new PieData(dataSet16);
        //data16//.setDrawValues(true);
        data16.setValueFormatter(new PercentFormatter(pieChart1));
        data16.setValueTextSize(12f);
        data16.setValueTextColor(Color.BLACK);

        PieDataSet dataSet17 = new PieDataSet(entries17, "Label");
        dataSet17.setColors(colors);
        PieData data17 = new PieData(dataSet17);
        //data17//.setDrawValues(true);
        data17.setValueFormatter(new PercentFormatter(pieChart1));
        data17.setValueTextSize(12f);
        data17.setValueTextColor(Color.BLACK);



        pieChart1.setData(data1);
        pieChart2.setData(data2);
        pieChart3.setData(data3);
        pieChart4.setData(data4);
        pieChart5.setData(data5);
        pieChart6.setData(data6);
        pieChart7.setData(data7);
        pieChart8.setData(data8);
        pieChart9.setData(data9);
        pieChart10.setData(data10);
        pieChart11.setData(data11);
        pieChart12.setData(data12);
        pieChart13.setData(data13);
        pieChart14.setData(data14);
        pieChart15.setData(data15);
        pieChart16.setData(data16);
        pieChart17.setData(data17);

        pieChart1.invalidate();
        pieChart2.invalidate();
        pieChart3.invalidate();
        pieChart4.invalidate();
        pieChart5.invalidate();
        pieChart6.invalidate();
        pieChart7.invalidate();
        pieChart8.invalidate();
        pieChart9.invalidate();
        pieChart10.invalidate();
        pieChart11.invalidate();
        pieChart12.invalidate();
        pieChart13.invalidate();
        pieChart14.invalidate();
        pieChart15.invalidate();
        pieChart16.invalidate();
        pieChart17.invalidate();

        pieChart1.animateY(1400, Easing.EaseInOutQuad);
        pieChart2.animateY(1400, Easing.EaseInOutQuad);
        pieChart3.animateY(1400, Easing.EaseInOutQuad);
        pieChart4.animateY(1400, Easing.EaseInOutQuad);
        pieChart5.animateY(1400, Easing.EaseInOutQuad);
        pieChart6.animateY(1400, Easing.EaseInOutQuad);
        pieChart7.animateY(1400, Easing.EaseInOutQuad);
        pieChart8.animateY(1400, Easing.EaseInOutQuad);
        pieChart9.animateY(1400, Easing.EaseInOutQuad);
        pieChart10.animateY(1400, Easing.EaseInOutQuad);
        pieChart11.animateY(1400, Easing.EaseInOutQuad);
        pieChart12.animateY(1400, Easing.EaseInOutQuad);
        pieChart13.animateY(1400, Easing.EaseInOutQuad);
        pieChart14.animateY(1400, Easing.EaseInOutQuad);
        pieChart15.animateY(1400, Easing.EaseInOutQuad);
        pieChart16.animateY(1400, Easing.EaseInOutQuad);
        pieChart17.animateY(1400, Easing.EaseInOutQuad);





    }



    public void calculation() {
        System.out.println("++++++++++++xxxxxxxxx++++++++++++++"+universal_admin.size());
        for(int j = 1 ; j<=universal_admin.size();j++)
        {
            count_dsa[j]=0;
            count_da[j]=0;
            count_n[j]=0;
            count_a[j]=0;
            count_sa[j]=0;
        }
        for(int i = 0 ; i<universal_admin.size();i++)
        {
            System.out.println("+++++++++++++++++++++++++++++++"+universal_admin.size());

            if(universal_admin.get(i).getAns1().equals("1")) {
                count_dsa[1] = count_dsa[1]+1;
            }

            else if(universal_admin.get(i).getAns1().equals("2")) {
                count_da[1] = count_da[1]+1;
            }
            else if(universal_admin.get(i).getAns1().equals("3")) {
                count_n[1] = count_n[1]+1;
            }
            else if(universal_admin.get(i).getAns1().equals("4")) {
                count_a[1] = count_a[1]+1;
            }
            else if(universal_admin.get(i).getAns1().equals("5")) {
                count_sa[1] = count_sa[1]+1;
            }


            if(universal_admin.get(i).getAns2().equals("1")) {
                count_dsa[2] = count_dsa[2]+1;
            }

            else if(universal_admin.get(i).getAns2().equals("2")) {
                count_da[2] = count_da[2]+1;
            }
            else if(universal_admin.get(i).getAns2().equals("3")) {
                count_n[2] = count_n[2]+1;
            }
            else if(universal_admin.get(i).getAns2().equals("4")) {
                count_a[2] = count_a[2]+1;
            }
            else if(universal_admin.get(i).getAns2().equals("5")) {
                count_sa[2] = count_sa[2]+1;
            }


            if(universal_admin.get(i).getAns3().equals("1")) {
                count_dsa[3] = count_dsa[3]+1;
            }

            else if(universal_admin.get(i).getAns3().equals("2")) {
                count_da[3] = count_da[3]+1;
            }
            else if(universal_admin.get(i).getAns3().equals("3")) {
                count_n[3] = count_n[3]+1;
            }
            else if(universal_admin.get(i).getAns3().equals("4")) {
                count_a[3] = count_a[3]+1;
            }
            else if(universal_admin.get(i).getAns3().equals("5")) {
                count_sa[3] = count_sa[3]+1;
            }

            if(universal_admin.get(i).getAns4().equals("1")) {
                count_dsa[4] = count_dsa[4]+1;
            }

            else if(universal_admin.get(i).getAns4().equals("2")) {
                count_da[4] = count_da[4]+1;
            }
            else if(universal_admin.get(i).getAns4().equals("3")) {
                count_n[4] = count_n[4]+1;
            }
            else if(universal_admin.get(i).getAns4().equals("4")) {
                count_a[4] = count_a[4]+1;
            }
            else if(universal_admin.get(i).getAns4().equals("5")) {
                count_sa[4] = count_sa[4]+1;
            }

            if(universal_admin.get(i).getAns5().equals("1")) {
                count_dsa[5] = count_dsa[5]+1;
            }

            else if(universal_admin.get(i).getAns5().equals("2")) {
                count_da[5] = count_da[5]+1;
            }
            else if(universal_admin.get(i).getAns5().equals("3")) {
                count_n[5] = count_n[5]+1;
            }
            else if(universal_admin.get(i).getAns5().equals("4")) {
                count_a[5] = count_a[5]+1;
            }
            else if(universal_admin.get(i).getAns5().equals("5")) {
                count_sa[5] = count_sa[5]+1;
            }

            if(universal_admin.get(i).getAns6().equals("1")) {
                count_dsa[6] = count_dsa[6]+1;
            }

            else if(universal_admin.get(i).getAns6().equals("2")) {
                count_da[6] = count_da[6]+1;
            }
            else if(universal_admin.get(i).getAns6().equals("3")) {
                count_n[6] = count_n[6]+1;
            }
            else if(universal_admin.get(i).getAns6().equals("4")) {
                count_a[6] = count_a[6]+1;
            }
            else if(universal_admin.get(i).getAns6().equals("5")) {
                count_sa[6] = count_sa[6]+1;
            }

            if(universal_admin.get(i).getAns7().equals("1")) {
                count_dsa[7] = count_dsa[7]+1;
            }

            else if(universal_admin.get(i).getAns7().equals("2")) {
                count_da[7] = count_da[7]+1;
            }
            else if(universal_admin.get(i).getAns7().equals("3")) {
                count_n[7] = count_n[7]+1;
            }
            else if(universal_admin.get(i).getAns7().equals("4")) {
                count_a[7] = count_a[7]+1;
            }
            else if(universal_admin.get(i).getAns7().equals("5")) {
                count_sa[7] = count_sa[7]+1;
            }

            if(universal_admin.get(i).getAns8().equals("1")) {
                count_dsa[8] = count_dsa[8]+1;
            }

            else if(universal_admin.get(i).getAns8().equals("2")) {
                count_da[8] = count_da[8]+1;
            }
            else if(universal_admin.get(i).getAns8().equals("3")) {
                count_n[8] = count_n[8]+1;
            }
            else if(universal_admin.get(i).getAns8().equals("4")) {
                count_a[8] = count_a[8]+1;
            }
            else if(universal_admin.get(i).getAns8().equals("5")) {
                count_sa[8] = count_sa[8]+1;
            }

            if(universal_admin.get(i).getAns9().equals("1")) {
                count_dsa[9] = count_dsa[9]+1;
            }

            else if(universal_admin.get(i).getAns9().equals("2")) {
                count_da[9] = count_da[9]+1;
            }
            else if(universal_admin.get(i).getAns9().equals("3")) {
                count_n[9] = count_n[9]+1;
            }
            else if(universal_admin.get(i).getAns9().equals("4")) {
                count_a[9] = count_a[9]+1;
            }
            else if(universal_admin.get(i).getAns9().equals("5")) {
                count_sa[9] = count_sa[9]+1;
            }

            if(universal_admin.get(i).getAns10().equals("1")) {
                count_dsa[10] = count_dsa[10]+1;
            }

            else if(universal_admin.get(i).getAns10().equals("2")) {
                count_da[10] = count_da[10]+1;
            }
            else if(universal_admin.get(i).getAns10().equals("3")) {
                count_n[10] = count_n[10]+1;
            }
            else if(universal_admin.get(i).getAns10().equals("4")) {
                count_a[10] = count_a[10]+1;
            }
            else if(universal_admin.get(i).getAns10().equals("5")) {
                count_sa[10] = count_sa[10]+1;
            }
            if(universal_admin.get(i).getAns11().equals("1")) {
                count_dsa[10] = count_dsa[10]+1;
            }

            else if(universal_admin.get(i).getAns11().equals("2")) {
                count_da[11] = count_da[11]+1;
            }
            else if(universal_admin.get(i).getAns11().equals("3")) {
                count_n[11] = count_n[11]+1;
            }
            else if(universal_admin.get(i).getAns11().equals("4")) {
                count_a[11] = count_a[11]+1;
            }
            else if(universal_admin.get(i).getAns11().equals("5")) {
                count_sa[11] = count_sa[11]+1;
            }

            if(universal_admin.get(i).getAns12().equals("1")) {
                count_dsa[12] = count_dsa[12]+1;
            }

            else if(universal_admin.get(i).getAns12().equals("2")) {
                count_da[12] = count_da[12]+1;
            }
            else if(universal_admin.get(i).getAns12().equals("3")) {
                count_n[12] = count_n[12]+1;
            }
            else if(universal_admin.get(i).getAns12().equals("4")) {
                count_a[12] = count_a[12]+1;
            }
            else if(universal_admin.get(i).getAns12().equals("5")) {
                count_sa[12] = count_sa[12]+1;
            }

            if(universal_admin.get(i).getAns13().equals("1")) {
                count_dsa[13] = count_dsa[13]+1;
            }

            else if(universal_admin.get(i).getAns13().equals("2")) {
                count_da[13] = count_da[13]+1;
            }
            else if(universal_admin.get(i).getAns13().equals("3")) {
                count_n[13] = count_n[13]+1;
            }
            else if(universal_admin.get(i).getAns13().equals("4")) {
                count_a[13] = count_a[13]+1;
            }
            else if(universal_admin.get(i).getAns13().equals("5")) {
                count_sa[13] = count_sa[13]+1;
            }

            if(universal_admin.get(i).getAns14().equals("1")) {
                count_dsa[14] = count_dsa[14]+1;
            }

            else if(universal_admin.get(i).getAns14().equals("2")) {
                count_da[14] = count_da[14]+1;
            }
            else if(universal_admin.get(i).getAns14().equals("3")) {
                count_n[14] = count_n[14]+1;
            }
            else if(universal_admin.get(i).getAns14().equals("4")) {
                count_a[14] = count_a[14]+1;
            }
            else if(universal_admin.get(i).getAns14().equals("5")) {
                count_sa[14] = count_sa[14]+1;
            }

            if(universal_admin.get(i).getAns15().equals("1")) {
                count_dsa[15] = count_dsa[15]+1;
            }

            else if(universal_admin.get(i).getAns15().equals("2")) {
                count_da[15] = count_da[15]+1;
            }
            else if(universal_admin.get(i).getAns15().equals("3")) {
                count_n[15] = count_n[15]+1;
            }
            else if(universal_admin.get(i).getAns15().equals("4")) {
                count_a[15] = count_a[15]+1;
            }
            else if(universal_admin.get(i).getAns15().equals("5")) {
                count_sa[15] = count_sa[15]+1;
            }

            if(universal_admin.get(i).getAns16().equals("1")) {
                count_dsa[16] = count_dsa[16]+1;
            }

            else if(universal_admin.get(i).getAns16().equals("2")) {
                count_da[16] = count_da[16]+1;
            }
            else if(universal_admin.get(i).getAns16().equals("3")) {
                count_n[16] = count_n[16]+1;
            }
            else if(universal_admin.get(i).getAns16().equals("4")) {
                count_a[16] = count_a[16]+1;
            }
            else if(universal_admin.get(i).getAns16().equals("5")) {
                count_sa[16] = count_sa[16]+1;
            }

            if(universal_admin.get(i).getAns17().equals("1")) {
                count_dsa[17] = count_dsa[17]+1;
            }

            else if(universal_admin.get(i).getAns17().equals("2")) {
                count_da[17] = count_da[17]+1;
            }
            else if(universal_admin.get(i).getAns17().equals("3")) {
                count_n[17] = count_n[17]+1;
            }
            else if(universal_admin.get(i).getAns17().equals("4")) {
                count_a[17] = count_a[17]+1;
            }
            else if(universal_admin.get(i).getAns17().equals("5")) {
                count_sa[17] = count_sa[17]+1;
            }








        }
        for (int i =0; i< universal_admin.size();i++) {
            count_dsa[i] = count_dsa[i] / universal_admin.size();
            count_da[i] = count_da[i] / universal_admin.size();
            count_n[i] = count_n[i] / universal_admin.size();
            count_a[i] = count_a[i] / universal_admin.size();
            count_sa[i] = count_sa[i] / universal_admin.size();
        }

        setupPieChart();




    }
}






