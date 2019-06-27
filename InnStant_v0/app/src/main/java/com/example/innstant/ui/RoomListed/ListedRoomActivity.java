package com.example.innstant.ui.RoomListed;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innstant.R;
import com.example.innstant.data.model.Room;
import com.example.innstant.ui.HostRoom.Adapter.AdapterRoomHosting;
import com.example.innstant.ui.HostRoom.Model.ModelHost;
import com.example.innstant.ui.RoomListed.Adapter.adapterListedRoom;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ListedRoomActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterRoomHosting.OnItemClickListener, adapterListedRoom.OnItemClickListener {
    RecyclerView recyclerView;
    adapterListedRoom adapter;
    ArrayList<Room> list;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listed_room);

        list = new ArrayList<>();
        recyclerView = findViewById(R.id.listroom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //fetching data

        for(int x=1 ; x<=20 ;x++){
            Room p = new Room();
            p.setName("asique" + x);
            p.setLocation("garut");
            list.add(p);
        }

        //get adapter
        adapter = new adapterListedRoom(ListedRoomActivity.this,list, ListedRoomActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(ModelHost item) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onItemClick(Room item) {

    }
}
