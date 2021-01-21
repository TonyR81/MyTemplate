package interfaces;

import android.os.Bundle;

import org.json.JSONObject;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IGeoLocation interface
 * This interface contains properties and methods of IGeoLocation class
 * Author: Antonino Razeti
 * Created: 02/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface IGeoLocation {

    /////////////////////////////
    // Getters
    String getAddress();
    String getStreetNumber();

    String getCity();

    String getCountry();

    String getZipCode();

    String getLatitude();
    String getLongitude();
    String getFormattedAddress();
    String getPlaceId();
    boolean isCoordinatesFound();
    /////////////////////////////

    /////////////////////////////
    // Setters
    void setAddress(String address);
    void setStreetNumber(String streetNumber);
    void setCity(String city);
    void setCountry(String country);
    void setZipCode(String zipCode);
    void setLatitude(String latitude);
    void setLongitude(String longitude);
    void setFormattedAddress(String formattedAddress);
    void setPlaceId(String placeId);
    /////////////////////////////

    /////////////////////////////
    // Functions
    JSONObject toJson();
    Bundle toBundle();
    String toPost();
    boolean findCoordinates();
    boolean findCoordinates(String address, String streetNumber, String city, String country, String zipCode);
    boolean findCoordinates(String... args);
    /////////////////////////////

    /////////////////////////////
    // Methods
    void initialize();
    void fromJson(JSONObject json);
    void fromBundle(Bundle bundle);
    /////////////////////////////

}
