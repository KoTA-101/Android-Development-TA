package com.example.innstant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innstant.R;

public class AddPictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);

        Button nextPict = (Button) findViewById(R.id.nextsetpricing);

        nextPict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AddPictureActivity.this, AddPictureActivity.class);
                startActivity(intent);
            }
        });
    }
}
