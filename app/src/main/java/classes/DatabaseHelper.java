package classes;

import android.content.Context;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import exceptions.InternetConnectionException;
import interfaces.IDatabaseHelper;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * DatabaseHelper class
 *
 * Author: Antonino Razeti
 * Created: 20/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class DatabaseHelper implements IDatabaseHelper {

    /////////////////////////////
    // Private declarations
    private User user;
    private JSONObject response;
    private final Context context;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the response from the database in json object format
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject getResponse() {
        return response;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new instance of DatabaseHelper class given the user who calls actions
     * @param user User
     */
    public DatabaseHelper(Context context, User user) {
        this.user = user;
        this.context = context;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Login of the user with specified credentials from server or local database
     * @param credentials Credentials
     * @return boolean
     * @see Credentials
     */
    @Override
    public boolean login(Credentials credentials) {
        boolean res;
        try {
            if (Utility.isConnected(context)) {
                res = loginFromServer(credentials);
            } else {
                res = loginFromLocal(credentials);
            }
        } catch (InternetConnectionException e) {
            res = loginFromLocal(credentials);
        }
        return res;
    }

    /**
     * Login of the current user given specified credentials from local database
     * @param credentials Credentials
     * @return boolean
     * @see Credentials
     */
    public boolean loginFromLocal(Credentials credentials) {
        // TODO: 20/01/2021 Implementare codice loginFromLocal(Credentials credentials)
        return false;
    }

    /**
     * Login of the current user given specified credentials from server database
     * @param credentials Credentials
     * @return boolean
     */
    @Override
    public boolean loginFromServer(Credentials credentials) {
        boolean res = false;
        String post = Utility.stringToPost("user", user.toPost()) + "&" +
                Utility.stringToPost("credentials", credentials.toPost());
        ServerRequest request = new ServerRequest("login");
        response = request.getResponse(post);
        try {
            res = response.has("response") && response.getBoolean("response");
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "login: " + e.getMessage());
        }
        return res;
    }

    /**
     * Logout of current user into server and local database
     * @return boolean
     */
    @Override
    public boolean logout() {
        boolean res = logoutToServer();
        if (res) {
            logoutToLocal();
        }
        return res;
    }

    /**
     * Logout of current user into server database
     * @return boolean
     */
    @Override
    public boolean logoutToServer() {
        boolean res = false;
        String post = Utility.stringToPost("user", user.toPost());
        ServerRequest request = new ServerRequest("logout");
        response = request.getResponse(post);
        try {
            res = response.has("response") && response.getBoolean("response");
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "logoutToServer: " + R.string.logout_error);
        }
        return res;
    }

    /**
     * Logout of current user into local database
     * @return boolean
     */
    @Override
    public boolean logoutToLocal() {
        // TODO: 20/01/2021 Implementare il codice per effettuare il logout nel database locale
        return false;
    }
    /////////////////////////////
}
