package com.tonyhack.haircut;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * SplashActivity class
 *
 * Author: Antonino Razeti
 * Created: 18/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class SplashActivity extends AppCompatActivity {


    /////////////////////////////
    // Private declarations
    private static final long TIMEOUT = 2000;
    /////////////////////////////

    /////////////////////////////
    // Methods
    /**
     * Overrides OnCreate method
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
            }
        }, TIMEOUT);

    }
    /////////////////////////////

}