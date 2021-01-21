package classes;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * PrefConfig class
 * This class is used to store or read system settings
 * Author: Antonino Razeti
 * Created: 19/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class PrefConfig implements interfaces.IPrefConfig {

    /////////////////////////////
    // Private declarations
    private final Context context;
    private final SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    /////////////////////////////

    /////////////////////////////
    // Getters
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Constructors
    /**
     * Creates a new instance of PrefConfig class given the context
     * @param context Context
     */
    public PrefConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences( context.getString( R.string.pref_file ),Context.MODE_PRIVATE );
    }
    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Read the status of login from preferences
     * @return boolean
     */
    @Override
    public boolean readLoginStatus() {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status), false);
    }

    /**
     * Read the login credentials from preferences and return an array that contains email, username and password
     * @return String[]
     */
    @Override
    public String[] readLoginCredentialsArray() {
        String[] credentials = new String[2];
        credentials[0] = sharedPreferences.getString(context.getString(R.string.pref_email), "");
        credentials[1] = sharedPreferences.getString(context.getString(R.string.pref_username), "");
        credentials[2] = sharedPreferences.getString(context.getString(R.string.pref_password), "");
        return credentials;
    }

    /**
     * Read the login credentials from preferences and return a json object that contains email, username and password
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject readLoginCredentialsJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", context.getString(R.string.pref_email));
            jsonObject.put("username", context.getString(R.string.pref_username));
            jsonObject.put("password", context.getString(R.string.pref_password));
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "readLoginCredentialsJson: " + e.getMessage());
        }
        return jsonObject;
    }

    /**
     * Read the email credentials from preferences and returns an array that contains email and password
     * @return String[]
     */
    @Override
    public String[] readEmailCredentialsArray() {
        String[] credentials = new String[2];
        credentials[0] = sharedPreferences.getString(context.getString(R.string.pref_email), "");
        credentials[1] = sharedPreferences.getString(context.getString(R.string.pref_email_password), "");
        return credentials;
    }

    /**
     * Returns the email credentials from preferences and returns a json object that contains email and password
     * @return JSONObject
     * @see JSONObject
     */
    public JSONObject readEmailCredentialsJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("email", context.getString(R.string.pref_email));
            json.put("password", context.getString(R.string.pref_email_password));
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "readEmailCredentialsJson: " + e.getMessage());
        }
        return json;
    }
    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Write the value of the login status into preferences
     * @param value boolean
     */
    @Override
    public void writeLoginStatus(boolean value) {
        editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status), value);
        editor.apply();
    }

    /**
     * Write specified credentials into preferences
     * @param email String
     * @param username String
     * @param password String
     */
    @Override
    public void writeLoginCredentials(String email, String username, String password) {
        editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_email), email);
        editor.putString(context.getString(R.string.pref_username), username);
        editor.putString(context.getString(R.string.pref_password), password);
        editor.apply();
    }

    /**
     * Write credentials given an array of string that contains email, username and password
     * @param credentials String[]
     */
    @Override
    public void writeLoginCredentials(String[] credentials) {
        editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_email), credentials[0]);
        editor.putString(context.getString(R.string.pref_username), credentials[1]);
        editor.putString(context.getString(R.string.pref_password), credentials[2]);
        editor.apply();
    }

    /**
     * Write credentials given a json object that contains email, username and password, into preferences
     * @param json JSONObject
     * @see JSONObject
     */
    public void writeLoginCredentials(JSONObject json) {
        if (json != null) {
            editor = sharedPreferences.edit();
            try {
                editor.putString(json.has("email") ? json.getString("email") : "", "");
                editor.putString(json.has("username") ? json.getString("username") : "", "");
                editor.putString(json.has("password") ? json.getString("password") : "", "");
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "writeLoginCredentials: " + e.getMessage());
            }
            editor.apply();
        }
    }

    /**
     * Write credentials given email, username and password, into preferences
     * @param email String
     * @param password String
     */
    @Override
    public void writeEmailCredentials(String email, String password) {
        editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_email), email);
        editor.putString(context.getString(R.string.pref_email_password), password);
        editor.apply();
    }

    /**
     * Write credentials given an array that contains email and password into preferences
     * @param credentials String[]
     */
    @Override
    public void writeEmailCredentials(String[] credentials) {
        editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_email), credentials[0]);
        editor.putString(context.getString(R.string.pref_email_password), credentials[1]);
        editor.apply();
    }
    /////////////////////////////
}
