package com.example.innstant.ui.HostRoom;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innstant.R;
import com.example.innstant.data.model.Room;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class AddPictureActivity extends AppCompatActivity {
    Button nextPict;
    ImageView gambar1;
    ImageView gambar2;
    ImageView gambar3;
    ImageView gambar4;
    ImageView gambar5;
    ImageView gambar6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);

        Bundle bundle = getIntent().getExtras();
        String json = bundle.getString("dataRoom");
        Gson gson = new Gson();
        final Room room= gson.fromJson(json,Room.class);



//        Toast.makeText(AddPictureActivity.this,room.getName(),Toast.LENGTH_LONG).show();

        nextPict = (Button) findViewById(R.id.nextsetpricing);
        gambar1 =(ImageView) findViewById(R.id.gambar1);
        gambar2 =(ImageView) findViewById(R.id.gambar2);
        gambar3 =(ImageView) findViewById(R.id.gambar3);
        gambar4 =(ImageView) findViewById(R.id.gambar4);
        gambar5 =(ImageView) findViewById(R.id.gambar5);
        gambar6 =(ImageView) findViewById(R.id.gambar6);

        gambar1.setOnClickListener(new gambar1());
        gambar2.setOnClickListener(new gambar2());
        gambar3.setOnClickListener(new gambar3());
        gambar4.setOnClickListener(new gambar4());
        gambar5.setOnClickListener(new gambar5());
        gambar6.setOnClickListener(new gambar6());

        nextPict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AddPictureActivity.this, SetRoomPricingActivity.class);
                Gson gson= new Gson();
                String json = gson.toJson(room);
                intent.putExtra("dataRoom",json);
                startActivity(intent);
            }
        });
    }
    class gambar1 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,1);
        }
    }
    class gambar2 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,2);
        }
    }
    class gambar3 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,3);
        }
    }
    class gambar4 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,4);
        }
    }
    class gambar5 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,5);
        }
    }
    class gambar6 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,6);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar1.setImageBitmap(bitmap);

        }else if(requestCode == 2){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar2.setImageBitmap(bitmap);
        }else if(requestCode == 3){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar3.setImageBitmap(bitmap);

        }else if(requestCode == 4){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar4.setImageBitmap(bitmap);

        }else if(requestCode == 5){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar5.setImageBitmap(bitmap);

        }else if(requestCode == 6){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar6.setImageBitmap(bitmap);

        }
    }
}
