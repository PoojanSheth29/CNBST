//package com.myappgen2020.cnbst;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.os.Environment;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//public class ExcelWrite extends AppCompatActivity {
//    TextView textView;
//    Button button;
//    File filePath = new File( "/Internal storage/storage/emulated/0");
//    public static final int EXTERNAL_STORAGE_REQ_CODE = 10 ;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_excel_write);
//
//
//
//        int permission = ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE);
//
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // request permission
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                    EXTERNAL_STORAGE_REQ_CODE);
//        }
//
//
//        textView = findViewById(R.id.tv_text);
//        button = findViewById(R.id.btn_try1);
//        buttonCreateExcel(button);
//    }
//    public  void buttonCreateExcel(View view)
//
//    {
//        System.out.println("AAAAAAAAAAAAANNNNNNNNNNNDAAAAAAAAAAAAAAR ACEEEEE PAN ^EEEEEEEEEEEEEEEEEEEEE");
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
//        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");
//        HSSFRow hssfRow = hssfSheet.createRow(0);
//        HSSFCell hssfCell = hssfRow.createCell(0);
//        hssfCell.setCellValue(textView.getText().toString());
//        System.out.println("fvhudfhvbdfvbuiivbfvudfher"+Environment.getExternalStorageDirectory());
//        FileOutputStream fileOutputStream = null;
//        try {
//
//            System.out.println("error 1_1");
//            System.out.println(filePath.exists());
//
//            filePath.createNewFile();
//
//            System.out.println("error 2");
//
//
//            fileOutputStream = new FileOutputStream(filePath+"/Demo.xlsx");
//            System.out.println("error 3");
//            hssfWorkbook.write(fileOutputStream);
//
//
//                fileOutputStream.flush();
//                fileOutputStream.close();
//
//
//
//
//        } catch (Exception e) {
//            System.out.println("ha ");
//            e.printStackTrace();
//        }
//
//    }
//}
package com.myappgen2020.cnbst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelWrite extends AppCompatActivity {

    TextView Daonloaad;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Bean> universal;

    WritableWorkbook workbook;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_write);
        Daonloaad = findViewById(R.id.tv_text);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        loadFirebaseData();
        Daonloaad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
                else
                {
                    //your code
                    createExcelSheet();
                }

            }
        });


    }

    public void loadFirebaseData()
    {
        universal = new ArrayList<Bean>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot)
            {
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Bean bean =dataSnapshot.getValue(Bean.class);
                    universal.add(bean);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    void createExcelSheet() {
        //File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

        String csvFile = "AnswerBean.xls";
        java.io.File futureStudioIconFile = new java.io.File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/" + csvFile);
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        try {
            workbook = Workbook.createWorkbook(futureStudioIconFile, wbSettings);
            createFirstSheet();
//            createSecondSheet();
            //closing cursor
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createFirstSheet() {
        try {
           




            //Excel sheet name. 0 (number)represents first sheet
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            // column and row title
            sheet.addCell(new Label(0, 0, "name"));
            sheet.addCell(new Label(1, 0, "age"));
            sheet.addCell(new Label(2, 0, "email"));
            sheet.addCell(new Label(3, 0, "exp"));
            sheet.addCell(new Label(4, 0, "classTeach"));
            sheet.addCell(new Label(5, 0, "std"));
            sheet.addCell(new Label(6, 0, "qlf"));
            sheet.addCell(new Label(7, 0, "schoolName"));
            sheet.addCell(new Label(8, 0, "addSchool"));
            sheet.addCell(new Label(9, 0, "desk"));
            sheet.addCell(new Label(10, 0, "NoStudents"));
            sheet.addCell(new Label(11, 0, "country"));
            sheet.addCell(new Label(12, 0, "state"));
            sheet.addCell(new Label(13, 0, "city"));
            sheet.addCell(new Label(14, 0, "teachingStage"));
            sheet.addCell(new Label(15, 0, "gender"));
            sheet.addCell(new Label(16, 0, "ans1"));
            sheet.addCell(new Label(17, 0, "ans2"));
            sheet.addCell(new Label(18, 0, "ans3"));
            sheet.addCell(new Label(19, 0, "ans4"));
            sheet.addCell(new Label(20, 0, "ans5"));
            sheet.addCell(new Label(21, 0, "ans6"));
            sheet.addCell(new Label(22, 0, "ans7"));
            sheet.addCell(new Label(23, 0, "ans8"));
            sheet.addCell(new Label(24, 0, "ans9"));
            sheet.addCell(new Label(25, 0, "ans10"));
            sheet.addCell(new Label(26, 0, "ans11"));
            sheet.addCell(new Label(27, 0, "ans12"));
            sheet.addCell(new Label(28, 0, "ans13"));
            sheet.addCell(new Label(29, 0, "ans14"));
            sheet.addCell(new Label(30, 0, "ans15"));
            sheet.addCell(new Label(31, 0, "ans16"));
            sheet.addCell(new Label(32, 0, "ans17"));




            for (int i = 0; i < universal.size(); i++) {
                sheet.addCell(new Label(0, i + 1, universal.get(i).getName()));
                sheet.addCell(new Label(1, i + 1, universal.get(i).getAge()));
                sheet.addCell(new Label(2, i + 1, universal.get(i).getEmail()));
                sheet.addCell(new Label(3, i + 1, universal.get(i).getExp()));
                sheet.addCell(new Label(4, i + 1, universal.get(i).getClassTeach()));
                sheet.addCell(new Label(5, i + 1, universal.get(i).getStd()));
                sheet.addCell(new Label(6, i + 1, universal.get(i).getQlf()));
                sheet.addCell(new Label(7, i + 1, universal.get(i).getSchoolName()));
                sheet.addCell(new Label(8, i + 1, universal.get(i).getAddSchool()));
                sheet.addCell(new Label(9, i + 1, universal.get(i).getDesk()));
                sheet.addCell(new Label(10, i + 1, universal.get(i).getNoStudents()));
                sheet.addCell(new Label(11, i + 1, universal.get(i).getCountry()));
                sheet.addCell(new Label(12, i + 1, universal.get(i).getState()));
                sheet.addCell(new Label(13, i + 1, universal.get(i).getCity()));
                sheet.addCell(new Label(14, i + 1, universal.get(i).getTeachingStage()));
                sheet.addCell(new Label(15, i + 1, universal.get(i).getGender()));
                sheet.addCell(new Label(16, i + 1, universal.get(i).getAns1()));
                sheet.addCell(new Label(17, i + 1, universal.get(i).getAns2()));
                sheet.addCell(new Label(18, i + 1, universal.get(i).getAns3()));
                sheet.addCell(new Label(19, i + 1, universal.get(i).getAns4()));
                sheet.addCell(new Label(20, i + 1, universal.get(i).getAns5()));
                sheet.addCell(new Label(21, i + 1, universal.get(i).getAns6()));
                sheet.addCell(new Label(22, i + 1, universal.get(i).getAns7()));
                sheet.addCell(new Label(23, i + 1, universal.get(i).getAns8()));
                sheet.addCell(new Label(24, i + 1, universal.get(i).getAns9()));
                sheet.addCell(new Label(25, i + 1, universal.get(i).getAns10()));
                sheet.addCell(new Label(26, i + 1, universal.get(i).getAns11()));
                sheet.addCell(new Label(27, i + 1, universal.get(i).getAns12()));
                sheet.addCell(new Label(28, i + 1, universal.get(i).getAns13()));
                sheet.addCell(new Label(29, i + 1, universal.get(i).getAns14()));
                sheet.addCell(new Label(30, i + 1, universal.get(i).getAns15()));
                sheet.addCell(new Label(31, i + 1, universal.get(i).getAns16()));
                sheet.addCell(new Label(32, i + 1, universal.get(i).getAns17()));



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}