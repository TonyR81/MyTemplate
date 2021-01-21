package interfaces;

import android.os.Bundle;
import android.os.Parcelable;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import classes.Database;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ICollectionBase interface
 * This interface contains properties and methods of ICollectionBase class
 * Author: Antonino Razeti
 * Created: 13/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface ICollectionBase {


    Database get(int id);

    /////////////////////////////
    // Getters
    ArrayList<Database> getItems();
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods

    int getCount();

    /**
     * Initialize current collection
     */
    void initialize();
    /**
     * Add specified array of items given in specified json array that contains items in json object format
     * @param array JSONArray
     * @see JSONArray
     */
    void addRange(JSONArray array);

    /**
     * Add specified array of items given in specified bundle array that contains items in bundle object format
     * @param items Parcelable
     * @see Parcelable
     */
    void addRange(Parcelable[] items);
    /////////////////////////////
}
