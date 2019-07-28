package com.example.innstant.ui.RoomListed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.innstant.R;
import com.example.innstant.ui.RoomHostingActivity;

public class EditRoomActivity extends AppCompatActivity {
    Button save, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);
        save =(Button) findViewById(R.id.SaveEdit);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditRoomActivity.this, RoomHostingActivity.class);
                startActivity(intent);
            }
        });
    }
}
