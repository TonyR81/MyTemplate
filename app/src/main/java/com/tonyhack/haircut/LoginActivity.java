package com.tonyhack.haircut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import org.json.JSONException;
import org.json.JSONObject;
import classes.DatabaseHelper;
import classes.PrefConfig;
import classes.User;
import dialogs.ProgressDialog;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * LoginActivity class
 *
 * Author: Antonino Razeti
 * Created: 19/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText txtUsername;
    private TextInputEditText txtPassword;
    private AppCompatRadioButton rdStayConnected;
    private User user;
    private PrefConfig prefConfig;
    private ProgressDialog progressDialog;
    private AppCompatButton btnLogin;
    private AppCompatButton btnRegister;
    /////////////////////////////

    /////////////////////////////
    // Getters
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Constructors
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /**
     * Overrides onCreate method
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this, String.valueOf(R.string.progress_login));
        txtUsername = findViewById(R.id.login_txt_username);
        txtPassword = findViewById(R.id.login_txt_password);
        rdStayConnected = findViewById(R.id.login_rd_stay_connected);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        prefConfig = new PrefConfig(this);
        rdStayConnected.setChecked(prefConfig.readLoginStatus());
        JSONObject json = prefConfig.readLoginCredentialsJson();
        try {
            txtUsername.setText(json.has("username") ? json.getString("username") : "");
            txtPassword.setText(json.has("password") ? json.getString("password") : "");
            if (prefConfig.readLoginStatus() && !txtUsername.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty()) {
                progressDialog.show();
                new Handler().postDelayed(this::login, 200);
            }
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "onCreate: " + e.getMessage());
        }
    }

    /**
     * Login
     */
    private void login() {
        user = new User(txtUsername.getText().toString(), txtPassword.getText().toString());
        DatabaseHelper db = new DatabaseHelper(this, user);
        if (db.login(user.getCredentials())) {
            JSONObject response = db.getResponse();
            try {
                if (response != null && response.has("response") && response.getBoolean("response") && response.has("user"))  {
                    if (rdStayConnected.isChecked()) {
                        prefConfig.writeLoginStatus(true);
                        prefConfig.writeLoginCredentials(user.getCredentials().getEmail(), user.getCredentials().getUsername(), user.getCredentials().getPassword());
                    }
                    Intent main = new Intent(LoginActivity.this, MainActivity.class);
                    main.putExtra("user", response.getJSONObject("user").toString());
                    startActivity(main);
                    closeProgress();
                    finish();
                }
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "login: " + R.string.login_failed);
                Utility.message(this, String.valueOf(R.string.login_failed));
                closeProgress();
            }
        } else {
            Utility.message(this, String.valueOf(R.string.login_failed));
            Log.d(String.valueOf(R.string.app_name), "login: " + R.string.login_failed);
            closeProgress();
        }
    }

    /**
     * Overrides onClick method
     * @param view View
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (txtUsername.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()) {
                    Utility.blinkEditText(txtUsername, txtPassword);
                } else {
                    progressDialog = new ProgressDialog(this, String.valueOf(R.string.progress_login));
                    progressDialog.show();
                    new Handler().postDelayed(this::login, 200);
                }
                break;
            case R.id.btn_register:
                // TODO: 21/01/2021 Implementare codice per effettuare la registrazione del nuovo utente
                break;
        }
    }

    /**
     * Close the progress bar
     */
    private void closeProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
    /////////////////////////////

}