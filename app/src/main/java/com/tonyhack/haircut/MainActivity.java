package com.tonyhack.haircut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import classes.Company;
import classes.Customer;
import classes.Employee;
import classes.PrefConfig;
import classes.ServerRequest;
import classes.User;
import enumerations.AccountType;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * MainActivity class
 *
 * Author: Antonino Razeti
 * Created: 20/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class MainActivity extends AppCompatActivity {

    /////////////////////////////
    // Private declarations
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private static User user;
    private PrefConfig prefConfig;
    private Menu menu;
    private int menuItemSelected = 0;
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
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        prefConfig = new PrefConfig(this);
        drawerLayout = findViewById(R.id.main_drawer);
        navigationView = drawerLayout.findViewById(R.id.main_navigation_view);
        menu = navigationView.getMenu();

        // Add toggle button to the drawer and sync it
        toggle = new ActionBarDrawerToggle( this, drawerLayout, R.string.open, R.string.close );
        setSupportActionBar( toolbar );
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                // TODO: 20/01/2021 Implementare codice per avviare il progressDialog
                Intent intent = null;
                switch (menuItemSelected) {
                    case R.id.menu_settings:
                        // TODO: 20/01/2021 Avviare l'activity settings
                        break;
                    case R.id.menu_logout:

                        break;
                }
                if (intent != null && menuItemSelected != 0) {
                    menuItemSelected = 0;
                    startActivity(intent);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        toggle.syncState();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toggle.getDrawerArrowDrawable().setColor(getApplicationContext().getColor(R.color.white));
        }
        if (getIntent().hasExtra("user")) {
            try {
                JSONObject json = new JSONObject(getIntent().getStringExtra("user"));
                AccountType accountType = json.has("account_type") ? AccountType.getAccountType(json.getInt("account_type")) : AccountType.USER;
                switch (accountType) {
                    case USER:
                    case ADMIN:
                    case SUPER_ADMIN:
                        user = new User(json);
                        logout();
                        break;
                    case COMPANY:
                        user = new Company(json);
                        break;
                    case EMPLOYEE:
                        user = new Employee(json);
                        break;
                    case CUSTOMER:
                        user = new Customer(json);
                        break;
                }
            } catch (JSONException e) {
                logout();
                Log.d(String.valueOf(R.string.app_name), "onCreate: " + e.getMessage());
            }
        } else {
            logout();
        }
    }

    /**
     * Logout and back to login activity
     */
    private void logout() {
        try {
            if (user != null) {
                ServerRequest request = new ServerRequest("logout");
                JSONObject response = request.getResponse(user.toPost());
                if (response.has("response") && response.getBoolean("response")) {
                    // TODO: 20/01/2021 Effettuare il logout anche nel database locale
                }
                user = null;
            }
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "logout: " + e.getMessage());
        } finally {
            Intent login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(login);
        }

    }

    /////////////////////////////

}