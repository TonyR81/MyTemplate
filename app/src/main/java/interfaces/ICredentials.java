package interfaces;

import android.os.Bundle;

import org.json.JSONObject;

import enumerations.ShaType;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ICredentials interface
 * This interface contains properties and methods of ICredentials class
 * Author: Antonino Razeti
 * Created: 05/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface ICredentials {

    /////////////////////////////
    // Getters
    String getEmail();
    String getUsername();
    String getPassword();
    /////////////////////////////

    /////////////////////////////
    // Setters
    void setEmail(String email);
    void setUsername(String username);
    void setPassword(String password);
    /////////////////////////////

    /////////////////////////////
    // Functions
    JSONObject toJson();
    Bundle toBundle();
    /////////////////////////////

    /////////////////////////////
    // Methods
    void Initialize();
    void fromJson(JSONObject json);
    void fromBundle(Bundle bundle);

    String toPost();

    void generate();
    String encryptPassword(String password);
    String encryptPassword(String password, ShaType type);

    boolean checkConfirmPassword(String confirmPassword);

    boolean checkPasswords(String password, String confirmPassword);
    /////////////////////////////
}
