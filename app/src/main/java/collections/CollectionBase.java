package collections;

import android.os.Parcelable;
import org.json.JSONArray;
import java.util.ArrayList;
import classes.Database;
import interfaces.ICollectionBase;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * CollectionBase class
 *
 * Author: Antonino Razeti
 * Created: 13/01/2021
 * Version: 1.0
 **********************************************************************
 */
public abstract class CollectionBase implements ICollectionBase {

    /////////////////////////////
    // Private declarations
    protected ArrayList<Database> items;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the object with specified id number from current collection
     * @param id int
     * @return Database
     */
    @Override
    public Database get(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return items.get(id);
            }
        }
        return null;
    }

    /**
     * Gets the list of items of current collection
     * @return List<Database>
     */
    @Override
    public ArrayList<Database> getItems() {
        return items;
    }

    /**
     * Returns the number of element contained into current collection
     * @return int
     */
    @Override
    public int getCount() {
        return items.size();
    }
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of collection base class
     */
    public CollectionBase() {
        initialize();
    }

    /**
     * Creates a new instance of Collection Base class given an array of items in json object format
     * @param array JSONArray
     * @see JSONArray
     */
    public CollectionBase(JSONArray array) {
        addRange(array);
    }

    /**
     * Creates a new instance of CollectionBase class given an array of bundle that contains items in bundle object format
     * @param items Parcelable[]
     * @see Parcelable
     */
    public CollectionBase(Parcelable[] items) {
        addRange(items);
    }
    /////////////////////////////

    /////////////////////////////
    // Functions


    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current collection
     */
    @Override
    public void initialize() {
        this.items = new ArrayList<>();
    }

    /**
     * Add specified array of items given in json array that contains items in json object format
     * @param array JSONArray
     * @see JSONArray
     */
    @Override
    public abstract void addRange(JSONArray array);

    /**
     * Add specified array of items given in bundle array that contains items in bundle object format
     * @param items Parcelable
     * @see Parcelable
     */
    public abstract void addRange(Parcelable[] items);
    /////////////////////////////
}
