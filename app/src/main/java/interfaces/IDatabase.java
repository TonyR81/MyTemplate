package interfaces;

import android.os.Bundle;
import org.json.JSONObject;
import classes.Image;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IDatabase interface
 * This interface contains properties and methods of IDatabase class
 * Author: Antonino Razeti
 * Created: 31/12/2020
 * Version: 1.0
 **********************************************************************
 */
public interface IDatabase {

    /////////////////////////////
    // Getters

    /**
     * Gets the id number associated with the object into database
     * @return int
     */
    int getId();

    /**
     * Gets the id number associated with the parent of the object into database
     * @return int
     */
    int getIdParent();
    /////////////////////////////

    /////////////////////////////
    // Setters

    JSONObject getResponse();

    /**
     * Sets the id number associated with the object into database
     * @param id int
     */
    void setId(int id);

    /**
     * Sets the id number associated with the parent of the object into database
     * @param idParent int
     */
    void setIdParent(int idParent);
    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents the object
     * @return JSONObject
     * @see JSONObject
     */
    JSONObject toJson();

    /**
     * Returns a bundle object that represents the object
     * @return Bundle
     * @see Bundle
     */
    Bundle toBundle();

    /**
     * Returns a string that contains the arguments of current object to query database
     * @return String
     */
    String toPost();
    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current object
     */
    void initialize();

    /**
     * Sets the properties of current object given a json object that contains properties information
     * @param json JSONObject
     * @see JSONObject
     */
    void fromJson(JSONObject json);

    /**
     * Sets the properties of current object given a bundle object that contains properties information
     * @param bundle Bundle
     * @see Bundle
     */
    void fromBundle(Bundle bundle);
    /////////////////////////////
}
