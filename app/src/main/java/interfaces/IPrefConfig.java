package interfaces;

import org.json.JSONObject;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IPrefConfig interface
 * This interface contains properties and methods of IPrefConfig class
 * Author: Antonino Razeti
 * Created: 19/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface IPrefConfig {

    /////////////////////////////
    // Getters
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Functions
    boolean readLoginStatus();
    String[] readLoginCredentialsArray();
    JSONObject readLoginCredentialsJson();
    String[] readEmailCredentialsArray();
    JSONObject readEmailCredentialsJson();
    /////////////////////////////

    /////////////////////////////
    // Methods
    void writeLoginStatus(boolean value);
    void writeLoginCredentials(String email, String username, String password);
    void writeLoginCredentials(String[] credentials);
    void writeLoginCredentials(JSONObject json);
    void writeEmailCredentials(String email, String password);
    void writeEmailCredentials(String[] credentials);
    /////////////////////////////
}
