package com.example.innstant.ui.Rent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.innstant.R;
import com.example.innstant.ui.RentStatus.idleActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SelectDateActivity extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        setTitle("Select Date");
        EditText awal = (EditText) findViewById(R.id.awal);
        EditText akhir = (EditText) findViewById(R.id.akhir);
        Button requestBook = (Button) findViewById(R.id.requestBook);


        requestBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectDateActivity.this,ApprovalActivity.class);
                startActivity(intent);
            }
        });

        awal.setOnClickListener(new View.OnClickListener() {
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

                private void updateLabel() {
                    String myFormat = "MM/dd/yy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    awal.setText(sdf.format(myCalendar.getTime()));
                }

            };
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SelectDateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }

        });
        akhir.setOnClickListener(new View.OnClickListener() {
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

                private void updateLabel() {
                    String myFormat = "MM/dd/yy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    akhir.setText(sdf.format(myCalendar.getTime()));
                }

            };
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SelectDateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
}
