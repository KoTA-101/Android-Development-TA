package com.example.innstant.ui.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.innstant.R;
import com.example.innstant.data.PreferenceHelper;
import com.example.innstant.data.model.comment;
import com.example.innstant.data.model.user2;
import com.example.innstant.ui.DashboardActivity;
import com.example.innstant.viewmodel.LoginViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel mViewModel;

    EditText username;
    EditText password;
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
        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
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


    public void Login(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = PreferenceHelper.getBaseUrl() + "/users";
        Gson gson = new GsonBuilder().create();

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       // ArrayList<comment> coment = gson.fromJson(response, new TypeToken<List<comment>>(){}.getType());
                        Toast.makeText( LoginActivity.this,response,Toast.LENGTH_LONG).show();
                       // Toast.makeText( LoginActivity.this,  username.getText().toString() + password.getText().toString(),Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( LoginActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}
