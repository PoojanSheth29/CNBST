package com.myappgen2020.cnbst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserLogin extends AppCompatActivity {

    EditText  name,age,email,exp,classTeach,std,qlf,schoolName,addSchool,desk,NoStudents;

    Button  submit;

    Spinner  country,state,city,teachingStage;

    RadioButton  male,female;

    ArrayList<String> arrayList_country;
    ArrayAdapter<String> arrayAdapter_country;

    ArrayList<String> arrayList_indianState,arrayList_UsaState,arrayList_UkState;
    ArrayAdapter<String> arrayAdapter_state;

    ArrayList<String> arrayList_GujCity, arrayList_MhCity, arrayList_RajCity;
    ArrayAdapter<String> arrayAdapter_city;

    ArrayList<String> arrayList_teachingStage;
    ArrayAdapter<String> arrayAdapter_TeachingStage;

    String CountrySelected, StateSelected, CitySelected, TeachingStageSelected;





    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        name = findViewById(R.id.edt_name);
        age = findViewById(R.id.edt_age);
        email = findViewById(R.id.edt_email);
        exp = findViewById(R.id.edt_exp);
        classTeach = findViewById(R.id.edt_class);
        std = findViewById(R.id.edt_std);
        qlf = findViewById(R.id.edt_qlf);
        schoolName = findViewById(R.id.edt_schoolname);
        addSchool = findViewById(R.id.edt_addSchool);
        desk = findViewById(R.id.edt_desk);
        NoStudents = findViewById(R.id.edt_NoStudents);
        submit = findViewById(R.id.btn_userSubmit);

        male = findViewById(R.id.radbtn_male);
        female = findViewById(R.id.radbtn_female);

        country = (Spinner) findViewById(R.id.spinner_country);
        state = (Spinner) findViewById(R.id.spinner_state);
        city = (Spinner) findViewById(R.id.spinner_city);
        teachingStage = (Spinner) findViewById(R.id.spinner_teachingStage);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");


        arrayList_country = new ArrayList<>();
        arrayList_country.add("India");
        arrayList_country.add("USA");
        arrayList_country.add("UK");
        arrayList_country.add("Australia");
        arrayList_country.add("England");
        arrayAdapter_country = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_country);
        country.setAdapter(arrayAdapter_country);

        arrayList_indianState = new ArrayList<>();
        arrayList_indianState.add("Guj");
        arrayList_indianState.add("MH");
        arrayList_indianState.add("Rajasthan");

        arrayList_UsaState = new ArrayList<>();
        arrayList_UsaState.add("NYC");
        arrayList_UsaState.add("Washington DC");
        arrayList_UsaState.add("San Francisco");

        arrayList_UkState = new ArrayList<>();
        arrayList_UkState.add("London");
        arrayList_UkState.add("Paris");
        arrayList_UkState.add("Madrid");

        arrayList_GujCity = new ArrayList<>();
        arrayList_GujCity.add("Ahd");
        arrayList_GujCity.add("Bhv");
        arrayList_GujCity.add("Baroda");

        arrayList_MhCity = new ArrayList<>();
        arrayList_MhCity.add("Mumbai");
        arrayList_MhCity.add("Pune");
        arrayList_MhCity.add("Thane");

        arrayList_RajCity = new ArrayList<>();
        arrayList_RajCity.add("Udaipur");
        arrayList_RajCity.add("Jaipur");
        arrayList_RajCity.add("Mt Abu");





        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                CountrySelected = parent.getItemAtPosition(position).toString();
                if(position==0)
                {
                    arrayAdapter_state = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList_indianState);
                }
                if(position==1)
                {
                    arrayAdapter_state = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList_UsaState);
                }
                if(position==2)
                {
                    arrayAdapter_state = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList_UkState);
                }
                state.setAdapter(arrayAdapter_state);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StateSelected = parent.getItemAtPosition(position).toString();
                if(position==0)
                {
                    arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList_GujCity);
                }
                if(position==1)
                {
                    arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList_MhCity);
                }
                if(position==2)
                {
                    arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList_RajCity);
                }
                city.setAdapter(arrayAdapter_city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CitySelected = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayList_teachingStage = new ArrayList<>();
        arrayList_teachingStage.add("Pre Primary");
        arrayList_teachingStage.add("Primary");
        arrayList_teachingStage.add("Secondary");
        arrayList_teachingStage.add("Higher Secondary");
        arrayList_teachingStage.add("College");
        arrayAdapter_TeachingStage = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_teachingStage);
        teachingStage.setAdapter(arrayAdapter_TeachingStage);

        teachingStage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TeachingStageSelected = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });










        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                Intent i = new Intent(UserLogin.this,QuestionsAsked.class);
                i.putExtra("STR_Name",name.getText().toString());
                i.putExtra("STR_Age",age.getText().toString());
                i.putExtra("STR_Email",email.getText().toString());
                i.putExtra("STR_Exp",exp.getText().toString());
                i.putExtra("STR_ClassTeach",classTeach.getText().toString());
                i.putExtra("STR_Std",std.getText().toString());
                i.putExtra("STR_Qlf",qlf.getText().toString());
                i.putExtra("STR_SchoolName",schoolName.getText().toString());
                i.putExtra("STR_AddSchool",addSchool.getText().toString());
                i.putExtra("STR_Desk",desk.getText().toString());
                i.putExtra("STR_NoOfStudents",NoStudents.getText().toString());
                i.putExtra("STR_Country",CountrySelected);
                i.putExtra("STR_State",StateSelected);
                i.putExtra("STR_City",CitySelected);
                i.putExtra("STR_TS",TeachingStageSelected);



                if(male.isChecked())
                {
                    i.putExtra("STR_Gender",male.getText().toString());
                }
                if(female.isChecked())
                {
                    i.putExtra("STR_Gender",female.getText().toString());
                }

                startActivity(i);
                //String userskey = myRef.push().getKey();
                //Users users = new Users();
                //users.setUserKey(userskey);
//                users.setName(name.getText().toString());
//                users.setAge(age.getText().toString());
//                users.setEmail(email.getText().toString());
//                users.setExp(exp.getText().toString());
//                users.setClassTeach(classTeach.getText().toString());
//                users.setStd(std.getText().toString());
//                users.setQlf(qlf.getText().toString());
//                users.setSchoolName(schoolName.getText().toString());
//                users.setAddSchool(addSchool.getText().toString());
//                users.setDesk(desk.getText().toString());
//                users.setNoStudents(NoStudents.getText().toString());
//
//                if(male.isChecked())
//                {
//                    users.setGender(male.getText().toString());
//                }
//                if(female.isChecked())
//                {
//                    users.setGender(female.getText().toString());
//                }
//
//
//                users.setCountry(CountrySelected);
//                users.setState(StateSelected);
//                users.setCity(CitySelected);
//                users.setTeachingStage(TeachingStageSelected);
//                myRef.child(userskey).setValue(users);










            }
        });




    }
}