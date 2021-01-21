package collections;

import android.os.Bundle;
import org.json.JSONArray;
import interfaces.IPersonsCollection;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * PersonsCollection class
 *
 * Author: Antonino Razeti
 * Created: 13/01/2021
 * Version: 1.0
 **********************************************************************
 */
public abstract class PersonsCollection extends UsersCollection implements IPersonsCollection {

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
     * Creates a new empty instance of PersonsCollection class
     */
    public PersonsCollection() {
    }

    /**
     * Creates a new instance of Persons Collection Base class given an array of items in json object format
     * @param array JSONArray
     * @see JSONArray
     */
    public PersonsCollection(JSONArray array) {
        super(array);
    }

    /**
     * Creates a new instance of PersonsCollection class given a bundle object that contains persons in bundle object format
     * @param bundle Bundle
     */
    public PersonsCollection(Bundle[] bundle) {
        super(bundle);
    }

    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
