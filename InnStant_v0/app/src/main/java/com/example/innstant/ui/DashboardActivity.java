package com.example.innstant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.innstant.data.PreferenceHelper;
import com.example.innstant.R;
import com.example.innstant.ui.Dashboard.DashboardMessageActivity;
import com.example.innstant.ui.Dashboard.DashboardNotificationActivity;
import com.example.innstant.ui.Rent.RentRoomActivity;
import com.example.innstant.viewmodel.DashboardViewModel;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rent)
    ImageView rent;
    @BindView(R.id.hosting)
    ImageView hosting;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private DashboardViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        testAPI();
    }

    private void testAPI() {
        mViewModel.openServerConnection();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = PreferenceHelper.getBaseUrl() + "/users";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Toast.makeText(DashboardActivity.this, "Users: " + response, Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(DashboardActivity.this, error.getMessage(), Toast.LENGTH_LONG).show());
        queue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notify) {
            Intent intent = new Intent(DashboardActivity.this, DashboardNotificationActivity.class);
            startActivity(intent);
        }
        if (id == R.id.message) {
            Intent intent = new Intent(DashboardActivity.this, DashboardMessageActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.rent, R.id.hosting})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.rent:
                intent = new Intent(DashboardActivity.this, RentRoomActivity.class);
                startActivity(intent);
                break;
            case R.id.hosting:
                intent = new Intent(DashboardActivity.this, RoomHostingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
