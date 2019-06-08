package com.example.innstant.ui.RoomListed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.innstant.R;
import com.example.innstant.ui.RentStatus.idleActivity;

public class RoomDetailActivity extends AppCompatActivity {
    Button viewstatus ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

        viewstatus.findViewById(R.id.viewStatus);
        viewstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomDetailActivity.this, idleActivity.class);
                startActivity(intent);
            }
        });
    }
}
