package com.myappgen2020.cnbst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

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
    float count_dsa=0.5f, count_da=0.5f, count_n=0.5f, count_a=0.5f, count_sa=0.5f;
    private PieChart pieChart;
    //ExcelWrite excelWrite = new ExcelWrite();
    ArrayList<Answers> universal_admin;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = findViewById(R.id.activity_main_piechart);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        System.out.println("in load firebase");
        loadFirebaseData();
        calculation();

    }
//    calculation();

//    private void setupPieChart() {
//        pieChart.setDrawHoleEnabled(true);
//        pieChart.setUsePercentValues(true);
//        pieChart.setEntryLabelTextSize(12);
//        pieChart.setEntryLabelColor(Color.BLACK);
//        pieChart.setCenterText("Question 1");
//        pieChart.setCenterTextSize(24);
//        pieChart.getDescription().setEnabled(false);
//
//        Legend l = pieChart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l.setDrawInside(false);
//        l.setEnabled(true);
//        loadPieChartData();
//    }
//
//    private void loadPieChartData() {
//        ArrayList<PieEntry> entries = new ArrayList<>();
//        entries.add(new PieEntry(count_dsa, "Strongly DisAgreed"));
//        entries.add(new PieEntry(count_da, "DisAgreed"));
//        entries.add(new PieEntry(count_n, "Neutral"));
//        entries.add(new PieEntry(count_a, "Agreed"));
//        entries.add(new PieEntry(count_sa, "Strongly Agreed"));
//
//        ArrayList<Integer> colors = new ArrayList<>();
//        for (int color : ColorTemplate.MATERIAL_COLORS) {
//            colors.add(color);
//        }
//
//        for (int color : ColorTemplate.VORDIPLOM_COLORS) {
//            colors.add(color);
//        }
//
//        PieDataSet dataSet = new PieDataSet(entries, "Label");
//        dataSet.setColors(colors);
//
//        PieData data = new PieData(dataSet);
//        data.setDrawValues(true);
//        data.setValueFormatter(new PercentFormatter(pieChart));
//        data.setValueTextSize(12f);
//        data.setValueTextColor(Color.BLACK);
//
//        pieChart.setData(data);
//        pieChart.invalidate();
//
//        pieChart.animateY(1400, Easing.EaseInOutQuad);
//
//    }

    public void loadFirebaseData() {
        System.out.println("in load firebase");
        universal_admin = new ArrayList<Answers>();
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("in void");
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    System.out.println("in loop");
                    Answers answers = dataSnapshot.getValue(Answers.class);
                    universal_admin.add(answers);
                    System.out.println("in firebase"+universal_admin.size());
                    System.out.println("+++++++++++++++++++++++++++++++");


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        System.out.println("++++++++++++555555+++++++++++"+universal_admin);

        calculation();


    }

    public void calculation() {
        System.out.println("++++++++++++xxxxxxxxx++++++++++++++"+universal_admin.size());
        for(int i = 0 ; i<universal_admin.size();i++)
        {
            System.out.println("+++++++++++++++++++++++++++++++"+universal_admin.size());

            if(universal_admin.get(i).ans1.equals("1")) {
                count_dsa++;
            }

            else if(universal_admin.get(i).ans1.equals("2")) {
                count_da++;
            }
            else if(universal_admin.get(i).ans1.equals("3")) {
                count_n++;
            }
            else if(universal_admin.get(i).ans1.equals("4")) {
                count_a++;
            }
            else if(universal_admin.get(i).ans1.equals("5")) {
                count_sa++;
            }
            System.out.println(count_dsa);
            System.out.println(count_da);
            System.out.println(count_n);
            System.out.println(count_a);
            System.out.println(count_sa);



        }
//       count_dsa = count_dsa/universal_admin.size();
//        count_da = count_da/universal_admin.size();
//        count_n = count_n/universal_admin.size();
//        count_a = count_a/universal_admin.size();
//        count_sa = count_sa/universal_admin.size();
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+6++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ount_dsa");
        System.out.println(count_dsa);
        System.out.println(count_da);
        System.out.println(count_n);
        System.out.println(count_a);
        System.out.println(count_sa);
        //setupPieChart();




    }
}






