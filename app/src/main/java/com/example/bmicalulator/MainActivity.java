package com.example.bmicalulator;

import android.app.AliasActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.height_edit_text);
                EditText weightEditText = findViewById(R.id.weight_edit_text);

                int h = Integer.parseInt(heightEditText.getText().toString()); //เป็นออฟเจ็คที่เป็นส่วนสูงในbody
                int w = Integer.parseInt(weightEditText.getText().toString()); //เป็นออฟเจ็คที่เป็นน้ำหนักในbody

                Body body = new Body (h,w);

                //String msg = "ค่า ฺ BMI" +String.format(Locale.US,"%.2f",bmi);
                String msg = "นักหนักของคุณอยู่ในเกณฑ์ " + body.getResultText() ;

                Toast.makeText(
                        MainActivity.this,
                        msg,
                        Toast.LENGTH_LONG
                ).show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Result");
                dialog.setMessage(msg);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);
                dialog.show();

                new AlertDialog.Builder((MainActivity.this);
                        .setTitle("Result");

            }
        });
    }

    private float calculateBmi (int heightInCm, int weightInKg){
        //bmi = kg/m*2;
                float height = heightInCm / 100 ;
                 Log.i(Tag,"ความสูงหน่วยเมตร = " +String.valueOf(height));

                float bmi =  weightInKg / (height * height) ;
                return bmi ;
    }
}
