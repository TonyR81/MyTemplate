package classes;

import android.os.Bundle;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import enumerations.ShaType;
import interfaces.ICredentials;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * Credentials class
 *
 * Author: Antonino Razeti
 * Created: 05/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class Credentials implements ICredentials {

    /////////////////////////////
    // Private declarations
    private String email;
    private String username;
    private String password;
    private ShaType shaType;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the email of current credentials
     * @return String
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Gets username of current credentials
     * @return String
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of current credentials
     * @return String
     */
    @Override
    public String getPassword() {
        return password;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the email of current credentials
     * @param email String
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the username of current credentials
     * @param username String
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of current credentials
     * @param password String
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of Credentials class
     */
    public Credentials() {
    }

    /**
     * Creates a new instance of Credentials class given a json object that contains credentials properties information
     * @param json JSONObject
     * @see JSONObject
     */
    public Credentials(JSONObject json) {
        fromJson(json);
    }

    /**
     * Creates a new instance of Credentials class given a bundle object that contains credentials properties information
     * @param bundle Bundle
     * @see Bundle
     */
    public Credentials(Bundle bundle) {
        fromBundle(bundle);
    }

    /**
     * Creates a new instance of Credentials class given the email, username and password
     * @param email String
     * @param username String
     * @param password String
     */
    public Credentials(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents current credentials in json object format
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        return json;
    }

    /**
     * Returns a bundle object that represents current credentials in bundle object format
     * @return Bundle
     * @see Bundle
     */
    @Override
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        bundle.putString("username", username);
        bundle.putString("password", password);
        return bundle;
    }
    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current credentials
     */
    @Override
    public void Initialize() {
        email = "";
        username = "";
        password = "";
        shaType = ShaType.SHA1;
    }

    /**
     * Sets the properties of current credentials given a json object that contains credentials properties information
     * @param json JSONObject
     * @see JSONObject
     */
    @Override
    public void fromJson(JSONObject json) {
        if (json != null) {
            try {
                email = json.has("email") ? json.getString("email") : "";
                username = json.has("username") ? json.getString("username") : "";
                password = json.has("password") ? json.getString("password") : "";
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
            }
        }
    }

    /**
     * Sets the properties of current credentials given a bundle object that contains credentials properties information
     * @param bundle Bundle
     * @see Bundle
     */
    @Override
    public void fromBundle(Bundle bundle) {
        if (bundle != null) {
            email = bundle.get("email") != null ? bundle.getString("email") : "";
            username = bundle.get("username") != null ? bundle.getString("username") : "";
            password = bundle.get("password") != null ? bundle.getString("password") : "";
        }
    }

    /**
     * Returns a string that represents the arguments to query server database
     * @return String
     */
    @Override
    public String toPost() {
        return Utility.stringToPost("email", email) + "&" +
                Utility.stringToPost("username", username) + "&" +
                Utility.stringToPost("password", password);
    }

    /**
     * Generate random credentials
     */
    @Override
    public void generate() {
        username = Utility.usernameGenerator();
        String password = encryptPassword(username);
        this.password = password.substring(password.length()-9, password.length()-1);
    }

    /**
     * Encrypt the specified password
     * @param password String
     * @return String
     */
    @Override
    public String encryptPassword(String password) {
        return encryptPassword(password, ShaType.SHA1);
    }

    /**
     * Encrypt the specified password with specified secure hash algorithm
     * @param password String
     * @param type ShaType
     * @return String
     * @see ShaType
     */
    @Override
    public String encryptPassword(String password, ShaType type) {
        String res = null;
        try {
            final MessageDigest digest = MessageDigest.getInstance( type.toString());
            byte[] result = digest.digest(password.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(  );
            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }
            res = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {

        }
        return res;
    }

    /**
     * Check current password with specified confirm password
     * @param confirmPassword String
     * @return boolean
     */
    @Override
    public boolean checkConfirmPassword(String confirmPassword) {
        return password.equals(confirmPassword);
    }

    /**
     * Check specified password with specified confirm password
     * @param password String
     * @param confirmPassword String
     * @return boolean
     */
    @Override
    public boolean checkPasswords(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
    /////////////////////////////
}
