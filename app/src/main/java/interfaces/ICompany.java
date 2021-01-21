package interfaces;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ICompany interface
 * This interface contains properties and methods of ICompany class
 * Author: Antonino Razeti
 * Created: 12/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface ICompany {

    /////////////////////////////
    // Getters
    String getName();
    String getBusinessName();
    String getVatNumber();
    String getWebsite();
    /////////////////////////////

    /////////////////////////////
    // Setters
    void setName(String name);
    void setBusinessName(String businessName);
    void setVatNumber(String vatNumber);
    void setWebsite(String website);
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
