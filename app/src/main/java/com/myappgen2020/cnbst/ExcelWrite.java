package com.myappgen2020.cnbst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class ExcelWrite extends AppCompatActivity {
    TextView textView;
    Button button;
    File filePath = new File( "/Internal storage/storage/emulated/0");
    public static final int EXTERNAL_STORAGE_REQ_CODE = 10 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_write);



        int permission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    EXTERNAL_STORAGE_REQ_CODE);
        }


        textView = findViewById(R.id.tv_text);
        button = findViewById(R.id.btn_try1);
        buttonCreateExcel(button);
    }
    public  void buttonCreateExcel(View view)

    {
        System.out.println("AAAAAAAAAAAAANNNNNNNNNNNDAAAAAAAAAAAAAAR ACEEEEE PAN ^EEEEEEEEEEEEEEEEEEEEE");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);
        hssfCell.setCellValue(textView.getText().toString());
        System.out.println("fvhudfhvbdfvbuiivbfvudfher"+Environment.getExternalStorageDirectory());
        FileOutputStream fileOutputStream = null;
        try {

            System.out.println("error 1_1");
            System.out.println(filePath.exists());

            filePath.createNewFile();

            System.out.println("error 2");


            fileOutputStream = new FileOutputStream(filePath+"/Demo.xlsx");
            System.out.println("error 3");
            hssfWorkbook.write(fileOutputStream);


                fileOutputStream.flush();
                fileOutputStream.close();




        } catch (Exception e) {
            System.out.println("ha ");
            e.printStackTrace();
        }

    }
}