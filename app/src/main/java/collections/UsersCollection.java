package collections;

import android.os.Bundle;
import org.json.JSONArray;
import interfaces.IUsersCollection;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * UsersCollection class
 *
 * Author: Antonino Razeti
 * Created: 13/01/2021
 * Version: 1.0
 **********************************************************************
 */
public abstract class UsersCollection extends CollectionBase implements IUsersCollection {

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
     * Creates a new empty instance of UsersCollection class
     */
    public UsersCollection() {
    }

    /**
     * Creates a new instance of Users Collection Base class given an array of users in json object format
     * @param array JSONArray
     * @see JSONArray
     */
    public UsersCollection(JSONArray array) {
        super(array);
    }

    /**
     * Creates a new instance of UsersCollection class given a bundle object that contains users in bundle object
     * @param bundle Bundle
     */
    public UsersCollection(Bundle[] bundle) {
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
