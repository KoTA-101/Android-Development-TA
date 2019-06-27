package com.example.innstant.ui.Auth;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.example.innstant.R;
import com.example.innstant.data.PreferenceHelper;
import com.example.innstant.ui.DashboardActivity;
import com.example.innstant.viewmodel.LoginViewModel;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel mViewModel;
    private String baseUrl;

    EditText editText_username;
    EditText editText_password;
    Button login;
    Button signUp;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        baseUrl = PreferenceHelper.getBaseUrl() + "/users/authenticate";
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        login = (Button) findViewById(R.id.login);
        signUp = (Button) findViewById(R.id.signup);
        editText_username = (EditText) findViewById(R.id.username);
        editText_password = (EditText) findViewById(R.id.password);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    username = editText_username.getText().toString();
                    password = editText_password.getText().toString();

                    AuthRequest.ApiAuthenticationClient apiAuthenticationClient =
                            new AuthRequest.ApiAuthenticationClient(
                                    baseUrl
                                    , username
                                    , password
                            );

                    AsyncTask<Void, Void, String> execute = new ExecuteNetworkOperation(apiAuthenticationClient);
                    execute.execute();
                } catch (Exception ex) {
                }
                goToSecondActivity();
            }
        });

    }

    /**
     * This subclass handles the network operations in a new thread.
     * It starts the progress bar, makes the API call, and ends the progress bar.
     */
    public class ExecuteNetworkOperation extends AsyncTask<Void, Void, String> {

        private AuthRequest.ApiAuthenticationClient apiAuthenticationClient;
        private String isValidCredentials;

        /**
         * Overload the constructor to pass objects to this class.
         */
        public ExecuteNetworkOperation(AuthRequest.ApiAuthenticationClient apiAuthenticationClient) {
            this.apiAuthenticationClient = apiAuthenticationClient;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Display the progress bar.
          //  findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                isValidCredentials = apiAuthenticationClient.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // Hide the progress bar.
           // findViewById(R.id.loadingPanel).setVisibility(View.GONE);

            // Login Success
            if (isValidCredentials.equals("true")) {
                goToSecondActivity();
            }
            // Login Failure
            else {
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Open a new activity window.
     */
    private void goToSecondActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("password", password);
        bundle.putString("baseUrl", baseUrl);

        Intent intent = new Intent(this, DashboardActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
