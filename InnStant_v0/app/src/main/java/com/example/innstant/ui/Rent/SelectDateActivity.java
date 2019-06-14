package com.example.innstant.ui.Rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.innstant.R;

public class SelectDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        setTitle("Select Date");

        Button requestBook = (Button) findViewById(R.id.requestBook);
        requestBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectDateActivity.this,ApprovalActivity.class);
                startActivity(intent);
            }
        });

    }
}
