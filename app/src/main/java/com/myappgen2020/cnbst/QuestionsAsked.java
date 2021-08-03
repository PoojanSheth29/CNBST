package com.myappgen2020.cnbst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class QuestionsAsked extends AppCompatActivity {

    TextView questions, options;
    RadioButton sa, a, n, da, sda;
    Button btn_Next;
    Boolean check = true;
    ArrayList<String> optionSelected = new ArrayList<>();
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    int count = 0;
    String strLang[] = {"I probe students ideas in order to explore their potential later on",
            "I question students on their ideas to develop their critical thinking skills",
            "I keep track of how students are developing their ideas.",
            "I pay attention to every students query.",
            "I give students opportunities to share their ideas and thoughts.",
            "I regularly give group assignments as part of my course assessment",
            "I expect students to cooperate with each other in group work.",
            "I provide opportunities for students to evaluate themselves.",
            "I motivate students to apply what was taught in different contexts.",
            "I am open to listening to students in distress.",
            "I counsel students who fail in their tasks in order to boost their morale.",
            "I encourage students to learn from their failures.",
            "I encourage students to learn the basics of the topic.",
            "I emphasize learning proficiency for essential knowledge and skills.",
            "I urge students to explore their ideas further before sharing my viewpoint.",
            "I don't react immediately to the suggestions of the students rather give them time.",
            "I do not force students to strictly adhere to guidelines on given tasks.", " ."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_asked);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");


        options = findViewById(R.id.txt_optList);
        sa = findViewById(R.id.rb_sa);
        a = findViewById(R.id.rb_a);
        n = findViewById(R.id.rb_n);
        da = findViewById(R.id.rb_da);
        sda = findViewById(R.id.rb_sda);
        btn_Next = findViewById(R.id.btn_AnsNext);

        options.setText("All Questions answers are Mandatory\n" +
                "\n" +
                "[   Strongly DisAgree - 1\n" +
                "    DisAgree                 - 2\n" +
                "    Neutral                   - 3\n" +
                "    Agree                      - 4\n" +
                "    Strongly Agree       - 5 ]");


        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                while (count < 16)
//                {
                System.out.println("YOYOUOUOUOUOUOU" + count + "YOYOUOUOUOUOUOU" + strLang[count]);
                questions = findViewById(R.id.txt_questions);
                questions.setText(strLang[count]);

                if (sa.isChecked()) {

                    optionSelected.add("5");
                    sa.setChecked(false);
                    check = true;

                } else if (a.isChecked()) {

                    optionSelected.add("4");
                    a.setChecked(false);
                    check = true;
                } else if (n.isChecked()) {

                    optionSelected.add("3");
                    n.setChecked(false);
                    check = true;
                } else if (da.isChecked()) {
                    optionSelected.add("2");
                    da.setChecked(false);
                    check = true;
                } else if (sda.isChecked()) {
                    optionSelected.add("1");
                    sda.setChecked(false);
                    check = true;
                }
                if (check == true) {
                    count = count + 1;
                    check = false;
                }


                System.out.println("YOYOUOUOUOUOUOU" + optionSelected + "YOYOUOUOUOUOUOU");


//
//
//


//                    } else {
//                        Toast.makeText(getApplicationContext(), "Please choose one", Toast.LENGTH_SHORT);
//                    }


                //}
                if (count == 18) {
                    btn_Next.setText("Submit");
                    questions.setText("Thanks for Answering the survey");
                    sa.setVisibility(View.GONE);
                    a.setVisibility(View.GONE);
                    n.setVisibility(View.GONE);
                    da.setVisibility(View.GONE);
                    sda.setVisibility(View.GONE);
                    btn_Next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name;
                            String age;
                            String email;
                            String exp;
                            String classTeach;
                            String std;
                            String qlf;
                            String schoolName;
                            String addSchool;
                            String desk;
                            String NoStudents;
                            String country;
                            String state;
                            String city;
                            String teachingStage;
                            String gender;

                            Intent intent = getIntent();
                            
                            String userskey = myRef.push().getKey();
                            name = intent.getStringExtra("STR_Name");
                            gender = intent.getStringExtra("STR_Gender");
                            age = intent.getStringExtra("STR_Age");
                            email = intent.getStringExtra("STR_Email");
                            exp = intent.getStringExtra("STR_Exp");
                            classTeach = intent.getStringExtra("STR_ClassTeach");
                            std  = intent.getStringExtra("STR_Std");
                            qlf = intent.getStringExtra("STR_Qlf");
                            schoolName = intent.getStringExtra("STR_SchoolName");
                            addSchool = intent.getStringExtra("STR_AddSchool");
                            desk = intent.getStringExtra("STR_Desk");
                            NoStudents = intent.getStringExtra("STR_NoOfStudents");
                            country = intent.getStringExtra("STR_Country");
                            state = intent.getStringExtra("STR_State");
                            city = intent.getStringExtra("STR_City");
                            teachingStage = intent.getStringExtra("STR_TS");


                            Users users = new Users();
                            users.setName(name);
                            users.setAge(age);
                            users.setEmail(email);
                            users.setExp(exp);
                            users.setClassTeach(classTeach);
                            users.setStd(std);
                            users.setQlf(qlf);
                            users.setSchoolName(schoolName);
                            users.setAddSchool(addSchool);
                            users.setDesk(desk);
                            users.setNoStudents(NoStudents);
                            users.setGender(gender);
                            users.setCountry(country);
                            users.setState(state);
                            users.setCity(city);
                            users.setTeachingStage(teachingStage);

                            users.setAns1(optionSelected.get(0));
                            users.setAns2(optionSelected.get(1));
                            users.setAns3(optionSelected.get(2));
                            users.setAns4(optionSelected.get(3));
                            users.setAns5(optionSelected.get(4));
                            users.setAns6(optionSelected.get(5));
                            users.setAns7(optionSelected.get(6));
                            users.setAns8(optionSelected.get(7));
                            users.setAns9(optionSelected.get(8));
                            users.setAns10(optionSelected.get(9));
                            users.setAns11(optionSelected.get(10));
                            users.setAns12(optionSelected.get(11));
                            users.setAns13(optionSelected.get(12));
                            users.setAns14(optionSelected.get(13));
                            users.setAns15(optionSelected.get(14));
                            users.setAns16(optionSelected.get(15));
                            users.setAns17(optionSelected.get(16));
                            myRef.child(userskey).setValue(users);

                            Intent i = new Intent(QuestionsAsked.this, EvalutionOfUsers.class);
                            i.putExtra("optionSelected.get(0)",optionSelected.get(0));
                            i.putExtra("optionSelected.get(1)",optionSelected.get(1));
                            i.putExtra("optionSelected.get(2)",optionSelected.get(2));
                            i.putExtra("optionSelected.get(3)",optionSelected.get(3));
                            i.putExtra("optionSelected.get(4)",optionSelected.get(4));
                            i.putExtra("optionSelected.get(5)",optionSelected.get(5));
                            i.putExtra("optionSelected.get(6)",optionSelected.get(6));
                            i.putExtra("optionSelected.get(7)",optionSelected.get(7));
                            i.putExtra("optionSelected.get(8)",optionSelected.get(8));
                            i.putExtra("optionSelected.get(9)",optionSelected.get(9));
                            i.putExtra("optionSelected.get(10)",optionSelected.get(10));
                            i.putExtra("optionSelected.get(11)",optionSelected.get(11));
                            i.putExtra("optionSelected.get(12)",optionSelected.get(12));
                            i.putExtra("optionSelected.get(13)",optionSelected.get(13));
                            i.putExtra("optionSelected.get(14)",optionSelected.get(14));
                            i.putExtra("optionSelected.get(15)",optionSelected.get(15));
                            i.putExtra("optionSelected.get(16)",optionSelected.get(16));

                            startActivity(i);

                        }
                    });

                }

            }
        });


    }
}