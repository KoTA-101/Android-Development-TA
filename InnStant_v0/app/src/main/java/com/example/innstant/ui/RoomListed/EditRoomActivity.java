package com.example.innstant.ui.RoomListed;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.innstant.R;
import com.example.innstant.data.model.Room;
import com.example.innstant.ui.RoomHostingActivity;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EditRoomActivity extends AppCompatActivity {
    Button save, cancel;
    EditText location,roomName,roomType,desc,fee,downPayment;
    CheckBox shower,food,wifi,acfan,parking,security;
    ArrayList<Room> tempRoom = new ArrayList<>();
    Room room = new Room();
    Gson gson = new Gson();
    List amenis = new ArrayList<>() ;

    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);
        save =(Button) findViewById(R.id.SaveEdit);
        cancel = (Button) findViewById(R.id.Delete);
        location =(EditText) findViewById(R.id.location);
        roomName =(EditText) findViewById(R.id.roomName);
        roomType = (EditText) findViewById(R.id.roomType);
        desc = (EditText) findViewById(R.id.description);
        fee = (EditText) findViewById(R.id.priceTag);
        downPayment = (EditText) findViewById(R.id.dp);
        shower = (CheckBox) findViewById(R.id.location);
        food =(CheckBox) findViewById(R.id.food);
        wifi =(CheckBox) findViewById(R.id.wifi);
        acfan = (CheckBox) findViewById(R.id.acfan);
        parking= (CheckBox) findViewById(R.id.parking);
        security=(CheckBox) findViewById(R.id.security);

        Bundle bundle = getIntent().getExtras();
        String idUser = bundle.getString("email");
        String dataRoom = bundle.getString("dataRoom");
//       tempRoom =  new Gson().fromJson(dataRoom , Room.class);
        amenis = room.getAmenities();
        //setAllData
        checkAmenities(amenis,shower,food,wifi,acfan,parking,security);
        setFitur(room,location,roomType,roomName,desc,fee,downPayment);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditRoomActivity.this, RoomHostingActivity.class);
                Toast.makeText(EditRoomActivity.this,room.toString(),Toast.LENGTH_LONG).show();
                //startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void checkAmenities(List amenis, CheckBox shower, CheckBox food, CheckBox wifi, CheckBox acfan, CheckBox parking, CheckBox security) {
        for(int x = 0 ; x> amenis.size();x++){
            if(amenis.get(x).equals("Ac/Fan")){
                acfan.setChecked(true);
            }else{
                acfan.setChecked(false);
            }
            if( amenis.get(x) == "Shower"){
               shower.setChecked(true);
            }else{
                shower.setChecked(false);
            }
            if( amenis.get(x) == "Wifi"){
                wifi.setChecked(true);
            }else{
                wifi.setChecked(false);
            }
            if(amenis.get(x) =="Food"){
                food.setChecked(true);
            }else{
                food.setChecked(false);
            }
            if(amenis.get(x)=="Parking"){
                parking.setChecked(true);
            }else{
                parking.setChecked(false);
            }
            if(amenis.get(x) =="Security"){
                security.setChecked(true);
            }else{
                security.setChecked(false);
            }
        }
    }
    private void setFitur(Room room, EditText location, EditText roomType, EditText roomName, EditText desc, EditText fee, EditText downPayment){
     location.setText(room.getLocation());
     roomType.setText(room.getType());
     roomName.setText(room.getName());
     desc.setText(room.getDescription());
     fee.setText(room.getPrice());
     downPayment.setText(room.getDpPercentage());
    }

}
