package com.example.homework_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.content.DialogInterface;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    TextView lblDate;
    EditText txtDate;
    DatePickerDialog datePickerDialog;
    Button btnShow;
    String date;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lblDate=(TextView) findViewById(R.id.lblDate);
        btnShow=(Button) findViewById(R.id.btnShow);
        txtDate=(EditText) findViewById(R.id.txtDate);

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(SecondActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date =day + " / " + month + " / " + year;
                                txtDate.setText(date);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblDate.setText(date);
            }
        });


    }


}