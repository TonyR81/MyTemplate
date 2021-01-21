package interfaces;

import java.util.Date;
import classes.Credentials;
import classes.GeoLocation;
import classes.Image;
import enumerations.AccountPlan;
import enumerations.AccountType;
import enumerations.SessionStatus;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IUser interface
 * This interface contains properties and methods of IUser class
 * Author: Antonino Razeti
 * Created: 02/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface IUser {

    /////////////////////////////
    // Getters
    GeoLocation getLocation();
    String getFiscalCode();
    String getPhone();
    Credentials getCredentials();
    Date getRegistration();
    Date getSubscription();
    boolean getNewsletters();
    AccountType getAccountType();
    AccountPlan getAccountPlan();
    SessionStatus getSessionStatus();
    String getReferralCode();
    String getIdToken();
    boolean isVerified();
    Image getImage();
    /////////////////////////////


    /////////////////////////////
    // Setters
    void setLocation(GeoLocation location);
    void setFiscalCode(String fiscalCode);
    void setPhone(String phone);
    void setCredentials(Credentials credentials);
    void setRegistration(Date registration);
    void setSubscription(Date subscription);
    void setNewsletters(boolean newsletters);
    void setAccountType(AccountType accountType);
    void setAccountPlan(AccountPlan accountPlan);
    void setSessionStatus(SessionStatus sessionStatus);
    void setReferralCode(String referralCode);
    void setIdToken(String idToken);
    void isVerified(boolean verified);

    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
