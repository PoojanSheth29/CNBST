package com.myappgen2020.cnbst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class AdminLogin extends AppCompatActivity {


    EditText edtUserName,edtPwd;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        edtUserName = findViewById(R.id.edt_username);
        edtPwd = findViewById(R.id.edt_password);
        button = findViewById(R.id.btn_submitAdminLogin);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String usr = edtUserName.getText().toString();
               String pwd = edtPwd.getText().toString();

               if (usr.equals("admin") && pwd.equals("admin"))
               {
                   Intent intent = new Intent(AdminLogin.this,ExcelWrite.class);
                   startActivity(intent);
               }
               else
               {
                   Toast.makeText(getApplicationContext(), "Incorrect Id and Password", Toast.LENGTH_SHORT).show();
               }

            }
        });
    }
}