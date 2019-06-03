package com.example.innstant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.fragment.app.FragmentActivity;

import com.example.innstant.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    @BindView(R.id.setloc)
    Button setloc;
    @BindView(R.id.findloc)
    SearchView findloc;
    @BindView(R.id.location)
    EditText location;
    @BindView(R.id.nextinput)
    Button nextinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_location);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @OnClick({R.id.setloc, R.id.nextinput})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setloc:
                break;
            case R.id.nextinput:
                Intent intent = new Intent(SetLocationActivity.this, GeneralDescriptionActivity.class);
                startActivity(intent);
                break;
        }
    }
}
