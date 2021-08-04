package com.myappgen2020.cnbst;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.os.Message;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;
import javax.mail.Message;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EvalutionOfUsers extends AppCompatActivity {
    String Abstraction,Inquisitive,Motivation,CriticalThinking;
    TextView Abs,Inq,Mot,Ct;
    Button btn_emailSend;
    String sEmail = "mobileappaossdk@gmail.com";
    String sPassword = "PoojanSheth29";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalution_of_users);
        Abs = findViewById(R.id.tv_abs);
        Inq = findViewById(R.id.tv_inq);
        Mot = findViewById(R.id.tv_mot);
        Ct = findViewById(R.id.tv_ct);
        btn_emailSend = findViewById(R.id.btn_email);

        Intent i = getIntent();
        String email = i.getStringExtra("EMAIL");
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

        btn_emailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail,sPassword);
                    }
                });
                try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sEmail));
                message.setRecipients(MimeMessage.RecipientType.TO,InternetAddress.parse(email));
                message.setSubject("Mail Try 1");
                message.setText("Abstraction   " + Abstraction + "\n Inquisitive   "+ Inquisitive+"\n Motivation  " + Motivation+"\n CriticalThinking  "+ CriticalThinking);
                new SendMail().execute(message);


                }
                catch (MessagingException e)
                {
                    e.printStackTrace();
                }

            }
        });









    }

    private class SendMail extends AsyncTask<Message,String,String>
    {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(EvalutionOfUsers.this,"PleaeWait","Sending Mail...",true,false);

        }

        @Override
        protected String doInBackground(Message... messages) {
            try{

                Transport.send(messages[0]);
                return "Success";
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();
            if (s.equals("Success"))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(EvalutionOfUsers.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color= '#509324'>Success</font>"));
                builder.setMessage("Mail sent");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.show();

            }
            else
            {
                Toast.makeText(getApplicationContext(), "Fuck oFF", Toast.LENGTH_SHORT).show();
            }
        }


    }
}