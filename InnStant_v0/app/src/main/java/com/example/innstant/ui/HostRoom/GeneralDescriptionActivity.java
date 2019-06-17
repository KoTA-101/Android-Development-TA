package com.example.innstant.ui.HostRoom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innstant.R;

public class GeneralDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_description);

        Button nextPict = (Button) findViewById(R.id.nextaddpict);

        nextPict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(GeneralDescriptionActivity.this, AddPictureActivity.class);
                startActivity(intent);
            }
        });
    }
}
