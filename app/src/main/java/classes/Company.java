package classes;

import android.os.Bundle;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Date;
import collections.EmployeesCollection;
import enumerations.AccountPlan;
import enumerations.AccountType;
import enumerations.SessionStatus;
import interfaces.ICompany;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * Company class
 *
 * Author: Antonino Razeti
 * Created: 12/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class Company extends User implements ICompany {

    /////////////////////////////
    // Private declarations
    private String name;
    private String businessName;
    private String vatNumber;
    private String website;
    private EmployeesCollection employees;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the name of current company
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the business name of current company
     * @return String
     */
    @Override
    public String getBusinessName() {
        return businessName;
    }

    /**
     * Gets the vat number of current company
     * @return String
     */
    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    /**
     * Gets the website of current company
     * @return String
     */
    @Override
    public String getWebsite() {
        return website;
    }

    /**
     * Gets the employees of current company
     * @return EmployeesCollection
     * @see EmployeesCollection
     */
    public EmployeesCollection getEmployees() {
        return employees;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the name of current company
     * @param name String
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the business name of current company
     * @param businessName String
     */
    @Override
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * Sets the vat number of current company
     * @param vatNumber String
     */
    @Override
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    /**
     * Sets the website of current company
     * @param website String
     */
    @Override
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Sets the employees collection of current company
     * @param employees EmployeesCollection
     * @see EmployeesCollection
     */
    public void setEmployees(EmployeesCollection employees) {
        this.employees = employees;
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of Company class
     */
    public Company() {
    }

    /**
     * Creates a new instance of Company class given a json object that contains current company properties information
     * @param json JSONObject
     * @see JSONObject
     */
    public Company(JSONObject json) {
        super(json);
    }

    /**
     * Creates a new instance of Company class given a bundle object that contains current company properties information
     * @param bundle Bundle
     * @see Bundle
     */
    public Company(Bundle bundle) {
        super(bundle);
    }

    /**
     * Creates a new instance of Company class given the id number associated with the company into database,
     * the id number associated with the parent of current company into database, the location (address, street number, city, country, zip code, latitude and longitude), fiscal code, phone, credentials (email, username and password),
     * the registration and subscription day, the boolean value that indicates if newsletters are enabled for current company, the account type and plan,
     * session status (offline or online), the referral code, the id token to receive notification, the boolean value that indicates if current company is verified and
     * the image of current company
     * @param id int
     * @param idParent int
     * @param name String
     * @param businessName String
     * @param vatNumber String
     * @param website String
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
     * @param employees EmployeesCollection
     * @see GeoLocation
     * @see Credentials
     * @see AccountType
     * @see AccountPlan
     * @see SessionStatus
     * @see Image
     * @see EmployeesCollection
     */
    public Company(int id, int idParent, String name, String businessName, String vatNumber, String website, GeoLocation location, String fiscalCode, String phone, Credentials credentials, Date registration, Date subscription, boolean newsletters, AccountType accountType, AccountPlan accountPlan, SessionStatus sessionStatus, String referralCode, String idToken, boolean verified, Image image, EmployeesCollection employees) {
        super(id, idParent, location, fiscalCode, phone, credentials, registration, subscription, newsletters, accountType, accountPlan, sessionStatus, referralCode, idToken, verified, image);
        this.name = name;
        this.businessName = businessName;
        this.vatNumber = vatNumber;
        this.website = website;
        this.employees = employees;
    }

    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents current company
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            json.put("name", name);
            json.put("business_name", businessName);
            json.put("vat_number", vatNumber);
            json.put("website", website);
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "toJson: " + e.getMessage());
        }
        return json;
    }

    /**
     * Returns a bundle object that represents current company
     * @return Bundle
     * @see Bundle
     */
    @Override
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putString("name", name);
        bundle.putString("business_name", businessName);
        bundle.putString("vat_number", vatNumber);
        bundle.putString("website", website);
        if (employees != null) {
            bundle.putBundle("employees", employees.toBundle());
        }
        return bundle;
    }

    /**
     * Returns a string that represents current arguments to query server database
     * @return String
     */
    @Override
    public String toPost() {
        return Utility.stringToPost("name", name) + "&" +
                Utility.stringToPost("business_name", businessName) + "&" +
                Utility.stringToPost("vat_number", vatNumber) + "&" +
                Utility.stringToPost("website", website) + "&" +
                super.toPost();
    }

    /**
     * Returns a string that represents current company
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s, %s", name, super.toPost());
    }

    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current company
     */
    @Override
    public void initialize() {
        super.initialize();
        setAccountType(AccountType.COMPANY);
        employees = new EmployeesCollection();
    }

    /**
     * Sets current company properties given a json object that contains company properties information
     * @param json JSONObject
     * @see JSONObject
     */
    @Override
    public void fromJson(JSONObject json) {
        if (json != null) {
            super.fromJson(json);
            try {
                name = json.has("name") ? json.getString("name") : "";
                name = json.has("business_name") ? json.getString("business_name") : "";
                name = json.has("vat_number") ? json.getString("vat_number") : "";
                name = json.has("website") ? json.getString("website") : "";
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
            }
        }
    }

    /**
     * Sets current company properties given a bundle object that contains company properties information
     * @param bundle Bundle
     * @see Bundle
     */
    @Override
    public void fromBundle(Bundle bundle) {
        if (bundle != null) {
            super.fromBundle(bundle);
            name = bundle.get("name") != null ? bundle.getString("name") : "";
            businessName = bundle.get("business_name") != null ? bundle.getString("business_name") : "";
            vatNumber = bundle.get("vat_number") != null ? bundle.getString("vat_number") : "";
            website = bundle.get("website") != null ? bundle.getString("website") : "";
            if (bundle.getSerializable("employees") != null) {
                employees = new EmployeesCollection(bundle.getParcelableArray("employees"));
            }
        }
    }
    /////////////////////////////
}
