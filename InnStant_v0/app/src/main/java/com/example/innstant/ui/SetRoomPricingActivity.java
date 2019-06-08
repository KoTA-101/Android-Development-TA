package com.example.innstant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innstant.R;

public class SetRoomPricingActivity extends AppCompatActivity {
    Button setAvaliablity ;
    Button saveRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_room_pricing);
        setAvaliablity.findViewById(R.id.setavaliable);
        saveRoom.findViewById(R.id.saveroom);

        setAvaliablity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetRoomPricingActivity.this,SetAvaliabilityActivity.class);
                startActivity(intent);
            }
        });

        saveRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
