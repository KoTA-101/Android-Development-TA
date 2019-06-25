package com.example.innstant.ui.Auth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.innstant.R;
import com.example.innstant.data.PreferenceHelper;
import com.example.innstant.data.model.User;
import com.example.innstant.data.model.user2;
import com.example.innstant.viewmodel.SignUpViewModel;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
    private SignUpViewModel mViewModel;
    EditText firstname ;
    EditText lastname ;
    EditText idCardNumber;
    EditText phoneNumber;
    EditText emailAddress;
    EditText password;

    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        mViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
       firstname =(EditText) findViewById(R.id.firstName);
       lastname =(EditText) findViewById(R.id.lastName);
       idCardNumber=(EditText) findViewById(R.id.idCardNumber);
       phoneNumber =(EditText) findViewById(R.id.phoneNumber);
       emailAddress =(EditText) findViewById(R.id.email);
       password = (EditText) findViewById(R.id.password);

       SignUp = (Button) findViewById(R.id.next);
       SignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               postData();
           }
       });
    }


    public void postData()  {
        mViewModel.openServerConnection();
        RequestQueue requstQueue = Volley.newRequestQueue(this);
        String url = PreferenceHelper.getBaseUrl() + "/users";
        User user1 =new User();
        user2 user = new user2();
        user.setFirstName(firstname.getText().toString());
        user.setLastName(lastname.getText().toString());
        user.setIdCardNumber(idCardNumber.getText().toString());
        user.setEmail(emailAddress.getText().toString());
        user.setPassword(password.getText().toString());
        user.setPin("12345");
        String paramString = new GsonBuilder().create().toJson(user);
        try {
            JSONObject param = new JSONObject(paramString);

            JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url,param,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }

                    }
            ){
                //here I want to post data to sever
            };
            requstQueue.add(jsonobj);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
