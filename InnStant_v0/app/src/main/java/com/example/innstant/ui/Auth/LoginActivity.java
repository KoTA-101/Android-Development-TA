package com.example.innstant.ui.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.innstant.R;
import com.example.innstant.data.PreferenceHelper;
import com.example.innstant.viewmodel.LoginViewModel;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel mViewModel;
    Button login ;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        login =(Button) findViewById(R.id.login);
        signUp =(Button) findViewById(R.id.signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

    }
    private void Login() {
        mViewModel.openServerConnection();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = PreferenceHelper.getBaseUrl() + "/users";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Toast.makeText(LoginActivity.this, "Users: " + response, Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show());
        queue.add(stringRequest);
    }
}
