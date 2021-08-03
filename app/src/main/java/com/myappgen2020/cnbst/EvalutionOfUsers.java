package com.myappgen2020.cnbst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EvalutionOfUsers extends AppCompatActivity {
    String Abstraction,Inquisitive,Motivation,CriticalThinking;
    TextView Abs,Inq,Mot,Ct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalution_of_users);
        Abs = findViewById(R.id.tv_abs);
        Inq = findViewById(R.id.tv_inq);
        Mot = findViewById(R.id.tv_mot);
        Ct = findViewById(R.id.tv_ct);

        Intent i = getIntent();
        String a_1 = i.getStringExtra("optionSelected.get(0)");
        String a_2 = i.getStringExtra("optionSelected.get(1)");
        String a_3 = i.getStringExtra("optionSelected.get(2)");
        String a_4 = i.getStringExtra("optionSelected.get(3)");
        String a_5 = i.getStringExtra("optionSelected.get(4)");
        String a_6 = i.getStringExtra("optionSelected.get(5)");
        String a_7 = i.getStringExtra("optionSelected.get(6)");
        String a_8 = i.getStringExtra("optionSelected.get(7)");
        String a_9 = i.getStringExtra("optionSelected.get(8)");
        String a_10 = i.getStringExtra("optionSelected.get(9)");
        String a_11 = i.getStringExtra("optionSelected.get(10)");
        String a_12 = i.getStringExtra("optionSelected.get(11)");
        String a_13 = i.getStringExtra("optionSelected.get(12)");
        String a_14 = i.getStringExtra("optionSelected.get(13)");
        String a_15 = i.getStringExtra("optionSelected.get(14)");
        String a_16 = i.getStringExtra("optionSelected.get(15)");
        String a_17 = i.getStringExtra("optionSelected.get(16)");




        Abstraction = String.valueOf(Integer.parseInt(a_1)+Integer.parseInt(a_5)+Integer.parseInt(a_6)+Integer.parseInt(a_7));
        Inquisitive = String.valueOf(Integer.parseInt(a_3)+Integer.parseInt(a_4)+Integer.parseInt(a_17));
        Motivation = String.valueOf(Integer.parseInt(a_10)+Integer.parseInt(a_13)+Integer.parseInt(a_14));
        CriticalThinking = String.valueOf(Integer.parseInt(a_2)+Integer.parseInt(a_8)+Integer.parseInt(a_9)+Integer.parseInt(a_15));

        Abs.setText(Abstraction);
        Inq .setText(Inquisitive);
        Mot .setText(Motivation);
        Ct .setText(CriticalThinking);







    }
}