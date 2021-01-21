package classes;

import android.os.Bundle;
import org.json.JSONObject;
import java.util.Date;
import enumerations.AccountPlan;
import enumerations.AccountType;
import enumerations.SessionStatus;
import interfaces.ICustomer;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * Customer class
 *
 * Author: Antonino Razeti
 * Created: 19/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class Customer extends Person implements ICustomer {

    /////////////////////////////
    // Private declarations
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
     * Creates a new empty instance of Customer class
     */
    public Customer() {
    }

    /**
     * Creates a new instance of Customer class given a json object that contains customer's properties information
     * @param json JSONObject
     * @see JSONObject
     */
    public Customer(JSONObject json) {
        super(json);
    }

    /**
     * Creates a new instance of Customer class given a bundle object that contains customer's properties information
     * @param bundle Bundle
     * @see Bundle
     */
    public Customer(Bundle bundle) {
        super(bundle);
    }

    /**
     * Creates a new instance of Customer class given the id number associated with the Customer into database,
     * the id number associated with the parent of current Customer into database,
     * last name, first name, the location (address, street number, city, country, zip code, latitude and longitude), fiscal code, phone, credentials (email, username and password),
     * the registration and subscription day, the boolean value that indicates if newsletters are enabled for current Customer, the account type and plan,
     * session status (offline or online), the referral code, the id token to receive notification, the boolean value that indicates if current Customer is verified and
     * the image of current Customer
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
    public Customer(int id, int idParent, String lastName, String firstName, GeoLocation location, String fiscalCode, String phone, Credentials credentials, Date registration, Date subscription, boolean newsletters, AccountType accountType, AccountPlan accountPlan, SessionStatus sessionStatus, String referralCode, String idToken, boolean verified, Image image) {
        super(id, idParent, lastName, firstName, location, fiscalCode, phone, credentials, registration, subscription, newsletters, accountType, accountPlan, sessionStatus, referralCode, idToken, verified, image);
    }
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /**
     * Initialize current Customer
     */
    @Override
    public void initialize() {
        super.initialize();
        setAccountType(AccountType.CUSTOMER);
    }
    /////////////////////////////
}
