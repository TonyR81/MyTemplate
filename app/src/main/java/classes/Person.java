package classes;

import android.os.Bundle;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Date;
import enumerations.AccountPlan;
import enumerations.AccountType;
import enumerations.SessionStatus;
import interfaces.IPerson;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * Person class
 *
 * Author: Antonino Razeti
 * Created: 12/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class Person extends User implements IPerson {

    /////////////////////////////
    // Private declarations
    private String lastName;
    private String firstName;
    /////////////////////////////

    /////////////////////////////
    // Getters
    /**
     * Gets the last name of current person
     * @return String
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the first name of current person
     * @return String
     */
    @Override
    public String getFirstName() {
        return firstName;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters
    /**
     * Sets the last name of current person
     * @param lastName String
     */
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the first name of current person
     * @param firstName String
     */
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of Person class
     */
    public Person() {
    }

    /**
     * Creates a new instance of Person class given a json object that contains person properties information
     * @param json JSONObject
     * @see JSONObject
     */
    public Person(JSONObject json) {
        super(json);
    }

    /**
     * Creates a new instance of Person class given a bundle object that contains person properties information
     * @param bundle Bundle
     * @see Bundle
     */
    public Person(Bundle bundle) {
        super(bundle);
    }

    /**
     * Creates a new instance of Person class given the id number associated with the Person into database,
     * the id number associated with the parent of current Person into database,
     * last name, first name, the location (address, street number, city, country, zip code, latitude and longitude), fiscal code, phone, credentials (email, username and password),
     * the registration and subscription day, the boolean value that indicates if newsletters are enabled for current person, the account type and plan,
     * session status (offline or online), the referral code, the id token to receive notification, the boolean value that indicates if current person is verified and
     * the image of current person
     * @param id int
     * @param idParent int
     * @param lastName String
     * @param firstName String
     * @param location GeoLocation
     * @param fiscalCode String
     * @param phone String
     * @param credentials Credentials
     * @param registration java.util.Date
     * @param subscription java.util.Date
     * @param newsletters boolean
     * @param accountType AccountType
     * @param accountPlan AccountPlan
     * @param sessionStatus SessionStatus
     * @param referralCode String
     * @param idToken String
     * @param verified boolean
     * @param image Image
     * @see GeoLocation
     * @see Credentials
     * @see AccountType
     * @see AccountPlan
     * @see SessionStatus
     * @see Image
     */
    public Person(int id, int idParent, String lastName, String firstName, GeoLocation location, String fiscalCode, String phone, Credentials credentials, Date registration, Date subscription, boolean newsletters, AccountType accountType, AccountPlan accountPlan, SessionStatus sessionStatus, String referralCode, String idToken, boolean verified, Image image) {
        super(id, idParent, location, fiscalCode, phone, credentials, registration, subscription, newsletters, accountType, accountPlan, sessionStatus, referralCode, idToken, verified, image);
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents current person
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            json.put("last_name", lastName);
            json.put("first_name", firstName);
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "toJson: " + e.getMessage());
        }
        return json;
    }

    /**
     * Returns a bundle object that represents current person
     * @return Bundle
     */
    @Override
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putString("last_name", lastName);
        bundle.putString("first_name", firstName);
        return bundle;
    }

    /**
     * Returns a string that represents the arguments to query server database
     * @return String
     */
    @Override
    public String toPost() {
        return Utility.stringToPost("last_name", lastName) + "&" +
                Utility.stringToPost("first_name", firstName) + "&" +
                super.toPost();
    }

    /**
     * Returns a string that represents current person
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s", lastName, firstName);
    }

    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current person
     */
    @Override
    public void initialize() {
        super.initialize();
        lastName = "";
        firstName = "";
    }

    /**
     * Sets the person properties given a json object that contains person properties information
     * @param json JSONObject
     * @see JSONObject
     */
    @Override
    public void fromJson(JSONObject json) {
       if (json != null) {
           super.fromJson(json);
           try {
               lastName = json.has("last_name") ? json.getString("last_name") : "";
               firstName = json.has("first_name") ? json.getString("first_name") : "";
           } catch (JSONException e) {
               Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
           }
       }
    }

    /**
     * Sets the person properties given a bundle object that contains person properties information
     * @param bundle Bundle
     * @see Bundle
     */
    @Override
    public void fromBundle(Bundle bundle) {
        if (bundle != null) {
            super.fromBundle(bundle);
            lastName = bundle.get("last_name") != null ? bundle.getString("last_name") : "";
            firstName = bundle.get("first_name") != null ? bundle.getString("first_name") : "";
        }
    }

    /////////////////////////////
}
