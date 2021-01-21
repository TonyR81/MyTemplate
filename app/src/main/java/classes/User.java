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
import interfaces.IUser;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * User class
 *
 * Author: Antonino Razeti
 * Created: 02/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class User extends Database implements IUser {

    /////////////////////////////
    // Private declarations
    private GeoLocation location;
    private String fiscalCode;
    private String phone;
    private Credentials credentials;
    private Date registration;
    private Date subscription;
    private boolean newsletters;
    private AccountType accountType;
    private AccountPlan accountPlan;
    private SessionStatus sessionStatus;
    private String referralCode;
    private String idToken;
    private boolean verified;
    private Image image;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the location of current user
     * @return GeoLocation
     * @see GeoLocation
     */
    @Override
    public GeoLocation getLocation() {
        return location;
    }

    /**
     * Gets the fiscal code of current user
     * @return String
     */
    @Override
    public String getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Gets the phone of current user
     * @return String
     */
    @Override
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the credentials of current user
     * @return Credentials
     * @see Credentials
     */
    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Gets the registration day of current user
     * @return java.util.Date
     * @see Date
     */
    @Override
    public Date getRegistration() {
        return registration;
    }

    /**
     * Gets the subscription day of current user
     * @return java.util.Date
     * @see Date
     */
    @Override
    public Date getSubscription() {
        return subscription;
    }

    /**
     * Gets if newsletters of current user are enabled
     * @return boolean
     */
    @Override
    public boolean getNewsletters() {
        return newsletters;
    }

    /**
     * Gets the type of account of current user
     * @return AccountType
     * @see AccountType
     */
    @Override
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Gets the plan of account of current user
     * @return AccountPlan
     * @see AccountPlan
     */
    @Override
    public AccountPlan getAccountPlan() {
        return accountPlan;
    }

    /**
     * Gets the session status of current user
     * @return SessionStatus
     */
    @Override
    public SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    /**
     * Gets the referral code of current user
     * @return String
     */
    @Override
    public String getReferralCode() {
        return referralCode;
    }

    /**
     * Gets the id token of current user to receive notification
     * @return String
     */
    @Override
    public String getIdToken() {
        return idToken;
    }

    /**
     * Gets the boolean value that indicates if current user is verified
     * @return boolean
     */
    @Override
    public boolean isVerified() {
        return verified;
    }

    /**
     * Gets the image of current user
     * @return Image
     * @see Image
     */
    @Override
    public Image getImage() {
        return image;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the location of current user
     * @param location GeoLocation
     * @see GeoLocation
     */
    @Override
    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    /**
     * Sets the fiscal code of current user
     * @param fiscalCode String
     */
    @Override
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    /**
     * Sets the phone of current user
     * @param phone String
     */
    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the credentials of current user
     * @param credentials Credentials
     * @see Credentials
     */
    @Override
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Sets the registration day of current user
     * @param registration java.util.Date
     * @see Date
     */
    @Override
    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    /**
     * Sets the subscription day of current user
     * @param subscription java.util.Date
     * @see Date
     */
    @Override
    public void setSubscription(Date subscription) {
        this.subscription = subscription;
    }

    /**
     * Sets the boolean value that indicates if newsletters are enabled for current user
     * @param newsletters boolean
     */
    @Override
    public void setNewsletters(boolean newsletters) {
        this.newsletters = newsletters;
    }

    /**
     * Sets the type of account of current user
     * @param accountType AccountType
     * @see AccountType
     */
    @Override
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * Sets the plan of the account of current user
     * @param accountPlan AccountPlan
     * @see AccountPlan
     */
    @Override
    public void setAccountPlan(AccountPlan accountPlan) {
        this.accountPlan = accountPlan;
    }

    /**
     * Sets the session status of current user
     * @param sessionStatus SessionStatus
     */
    @Override
    public void setSessionStatus(SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    /**
     * Sets the referral code of current user
     * @param referralCode String
     */
    @Override
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    /**
     * Sets the id token of current user to receive notification
     * @param idToken String
     */
    @Override
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    /**
     * Sets the boolean value that indicates if current user is verified
     * @param verified boolean
     */
    @Override
    public void isVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * Sets the image of current user
     * @param image Image
     * @see Image
     */
    public void setImage(Image image) {
        this.image = image;
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of User class
     */
    public User() {
    }

    /**
     * Creates a new instance of User class given a json object that contains current user properties information
     * @param json JSONObject
     * @see JSONObject
     */
    public User(JSONObject json) {
        super(json);
    }

    /**
     * Creates a new instance of User class given a bundle object that contains current User properties information
     * @param bundle Bundle
     * @see Bundle
     */
    public User(Bundle bundle) {
        super(bundle);
    }

    /**
     * Creates a new instance of User class given the id number associated with the user into database,
     * the id number associated with the parent of current user into database, the location (address, street number, city, country, zip code, latitude and longitude), fiscal code, phone, credentials (email, username and password),
     * the registration and subscription day, the boolean value that indicates if newsletters are enabled for current user, the account type and plan,
     * session status (offline or online), the referral code, the id token to receive notification, the boolean value that indicates if current user is verified and
     * the image of current user
     * @param id int
     * @param idParent int
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
    public User(int id, int idParent, GeoLocation location, String fiscalCode, String phone, Credentials credentials, Date registration, Date subscription, boolean newsletters, AccountType accountType, AccountPlan accountPlan, SessionStatus sessionStatus, String referralCode, String idToken, boolean verified, Image image) {
        super(id, idParent);
        this.location = location;
        this.fiscalCode = fiscalCode;
        this.phone = phone;
        this.credentials = credentials;
        this.registration = registration;
        this.subscription = subscription;
        this.newsletters = newsletters;
        this.accountType = accountType;
        this.accountPlan = accountPlan;
        this.sessionStatus = sessionStatus;
        this.referralCode = referralCode;
        this.idToken = idToken;
        this.verified = verified;
        this.image = image;
    }

    /**
     * Creates a new instance of User class given the credentials
     * This constructor can be used to login
     * @param credentials Credentials
     * @see Credentials
     */
    protected User(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Creates a new instance of User class given username and password.
     * This constructor can be used to login
     * @param username String
     * @param password String
     */
    public User(String username, String password) {
        credentials = new Credentials("", username,password);
    }
    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents current user
     * @return JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            if (location != null) {
                json.put("address", location.getAddress());
                json.put("street_number", location.getStreetNumber());
                json.put("city", location.getCity());
                json.put("country", location.getCountry());
                json.put("zip_code", location.getZipCode());
                json.put("latitude", location.getLatitude());
                json.put("longitude", location.getLongitude());
                json.put("formatted_address", location.getFormattedAddress());
            }
            json.put("phone", phone);
            if (credentials != null) {
                json.put("email", credentials.getEmail());
                json.put("username", credentials.getUsername());
                json.put("password", credentials.getPassword());
            }
            json.put("registration", Utility.dateToString(registration));
            json.put("subscription", subscription != null ? Utility.dateToString(subscription) : "null");
            json.put("newsletters", newsletters ? 1 : 0);
            json.put("account_type", accountType.getInt());
            json.put("account_plan", accountPlan.getInt());
            json.put("session_status", sessionStatus.getInt());
            json.put("referral_code", referralCode);
            json.put("verified", verified ? 1 : 0);
            json.put("id_token", idToken);
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "toJson: " + e.getMessage());
        }
        return json;
    }

    /**
     * Returns a bundle object that represents current user
     * @return Bundle
     */
    @Override
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        if (location != null) {
            bundle.putString("address", location.getAddress());
            bundle.putString("street_number", location.getStreetNumber());
            bundle.putString("city", location.getCity());
            bundle.putString("country", location.getCountry());
            bundle.putString("zip_code", location.getZipCode());
        }
        bundle.putString("phone", phone);
        if (credentials != null) {
            bundle.putString("email", credentials.getEmail());
            bundle.putString("username", credentials.getUsername());
            bundle.putString("password", credentials.getPassword());
        }
        bundle.putString("registration", Utility.dateToString(registration));
        bundle.putString("subscription", subscription != null ? Utility.dateToString(subscription) : "null");
        bundle.putBoolean("newsletters", newsletters);
        bundle.putInt("account_type", accountType.getInt());
        bundle.putInt("account_plan", accountPlan.getInt());
        bundle.putInt("session_status", sessionStatus.getInt());
        bundle.putString("referral_code", referralCode);
        bundle.putBoolean("verified", verified);
        bundle.putString("id_token", idToken);
        return bundle;
    }

    /**
     * Returns a string that represents the arguments to query server database
     * @return String
     */
    @Override
    public String toPost() {
        return location.toPost() + "&" +
                Utility.stringToPost("phone", phone) + "&" +
                credentials.toPost() + "&" +
                Utility.stringToPost("registration", Utility.dateToString(registration)) + "&" +
                Utility.stringToPost("subscription", subscription != null ? Utility.dateToString(subscription) : "null") + "&" +
                Utility.stringToPost("newsletters", newsletters ? "1" : "0") +"&" +
                Utility.stringToPost("account_type", String.valueOf(accountType.getInt())) + "&" +
                Utility.stringToPost("account_plan", String.valueOf(accountPlan.getInt())) + "&" +
                Utility.stringToPost("session_status", String.valueOf(sessionStatus.getInt())) + "&" +
                Utility.stringToPost("referral_code", referralCode) + "&" +
                Utility.stringToPost("id_token", idToken) + "&" +
                Utility.stringToPost("verified", verified ? "1" : "0");
    }

    /**
     * Returns a string that represents current user
     * @return String
     */
    @Override
    public String toString() {
        return credentials.toString();
    }

    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current user
     */
    @Override
    public void initialize() {
        super.initialize();
        location = new GeoLocation();
        phone = "";
        credentials = new Credentials();
        registration = new Date();
        subscription = null;
        newsletters = false;
        accountType = AccountType.USER;
        accountPlan = AccountPlan.DEMO;
        sessionStatus = SessionStatus.OFFLINE;
        referralCode = "";
        idToken = "";
        verified = false;
    }

    /**
     * Sets the properties of current user object given a json object that contains properties information
     * @param json JSONObject
     * @see JSONObject
     */
    @Override
    public void fromJson(JSONObject json) {
        if (json != null) {
            try {
                super.fromJson(json);
                location = new GeoLocation(json);
                phone = json.has("phone") ? json.getString("phone") : "";
                credentials = new Credentials(json);
                registration = json.has("registration") ? Utility.stringToDate(json.getString("registration")) : new Date();
                subscription = json.has("subscription") &&
                        !json.getString("subscription").equals("null") &&
                        !json.getString("subscription").isEmpty() ?
                        Utility.stringToDate(json.getString("subscription")) : null;
                newsletters = json.has("newsletters") && json.getInt("newsletters") == 1;
                accountType = json.has("account_type") ? AccountType.getAccountType(json.getInt("account_type")) : AccountType.USER;
                accountPlan = json.has("account_plan") ? AccountPlan.getAccountPlan(json.getInt("account_plan")) : AccountPlan.DEMO;
                sessionStatus = json.has("session_status") ? SessionStatus.getSessionStatus(json.getInt("session_status")) : SessionStatus.OFFLINE;
                referralCode = json.has("referral_code") ? json.getString("referral_code") : "";
                idToken = json.has("id_token") ? json.getString("id_token") : "";
                verified = json.has("verified") && json.getInt("verified") == 1;
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
            }
        }

    }

    /**
     * Sets the properties of current user given a bundle object that contains properties information
     * @param bundle Bundle
     * @see Bundle
     */
    @Override
    public void fromBundle(Bundle bundle) {
        if (bundle != null) {
            super.fromBundle(bundle);
            location = new GeoLocation(bundle);
            phone = bundle.get("phone") != null ? bundle.getString("phone") : "";
            credentials = new Credentials(bundle);
            registration = bundle.get("registration") != null ? Utility.stringToDate(bundle.getString("registration")) : new Date();
            subscription = bundle.get("subscription") != null &&
                    !bundle.getString("subscription").equals("null") &&
                    !bundle.getString("subscription").isEmpty() ?
                    Utility.stringToDate("subscription") : null;
            newsletters = bundle.get("newsletters") != null && bundle.getBoolean("newsletters");
            accountType = bundle.get("account_type") != null ? AccountType.getAccountType(bundle.getInt("account_type")) : AccountType.USER;
            accountPlan = bundle.get("account_plan") != null ? AccountPlan.getAccountPlan(bundle.getInt("account_plan")) : AccountPlan.DEMO;
            sessionStatus = bundle.get("session_status") != null ? SessionStatus.getSessionStatus(bundle.getInt("session_status")) : SessionStatus.OFFLINE;
            referralCode = bundle.get("referral_code") != null ? bundle.getString("referral_code") : "";
            idToken = bundle.get("id_token") != null ? bundle.getString("id_token") : "";
            verified = bundle.get("verified") != null && bundle.getBoolean("newsletters");
        }

    }
    /////////////////////////////
}
