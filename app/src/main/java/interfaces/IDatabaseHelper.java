package interfaces;

import org.json.JSONObject;

import classes.Credentials;
import classes.User;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IDatabaseHelper interface
 * This interface contains properties and methods of IDatabaseHelper class
 * Author: Antonino Razeti
 * Created: 20/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface IDatabaseHelper {

    /////////////////////////////
    // Getters
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    boolean logout();

    JSONObject getResponse();

    boolean login(Credentials credentials);

    boolean loginFromServer(Credentials credentials);

    boolean logoutToServer();

    boolean logoutToLocal();
    /////////////////////////////
}
