package com.example.innstant.ui.RentStatus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.innstant.R;
import com.example.innstant.ui.Rent.RoomDetailActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class idleActivity extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idle);

        TextView from= (TextView) findViewById(R.id.from);
        TextView to =(TextView) findViewById(R.id.to);
        Button viewRequest =(Button) findViewById(R.id.viewRequestIdle);

        viewRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(idleActivity.this, RoomDetailActivity.class);
                startActivity(intent);
            }
        });

    }

}
