package classes;

import android.os.Bundle;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import interfaces.IDatabase;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * Database class
 *
 * Author: Antonino Razeti
 * Created: 31/12/2020
 * Version: 1.0
 **********************************************************************
 */
public class Database implements IDatabase {

    /////////////////////////////
    // Private declarations
    private int id;
    private int idParent;
    private JSONObject response;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the id number associated with current object into database
     * @return int
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the id number associated with the parent of current object into database
     * @return int
     */
    @Override
    public int getIdParent() {
        return idParent;
    }

    /**
     * Gets the response of the server request
     * @return JSONObject
     */
    @Override
    public JSONObject getResponse() {
        return response;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the id number associated with current object into database
     * @param id int
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the id number associated with the parent of current object into database
     * @param idParent int
     */
    @Override
    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of Database class
     */
    public Database() {}

    /**
     * Creates a new instance of Database class given a json object that contains current database object properties information
     * @param json JSONObject
     * @see JSONObject
     */
    public Database(JSONObject json) {
        fromJson(json);
    }

    /**
     * Creates a new instance of Database class given a bundle object that contains current database object properties information
     * @param bundle Bundle
     * @see Bundle
     */
    public Database(Bundle bundle) {
        fromBundle(bundle);
    }

    /**
     * Creates a new instance of Database class given the id number associated with the database object into database and
     * the id number associated with the parent of current database object into database
     * @param id int
     * @param idParent int
     */
    public Database(int id, int idParent) {
        this.id = id;
        this.idParent = idParent;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents current object
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("id_parent", idParent);
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "toJson: " + e.getMessage());
        }
        return json;
    }

    /**
     * Returns a bundle object that represents current object
     * @return Bundle
     * @see Bundle
     */
    @Override
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putInt("id_parent", idParent);
        return bundle;
    }

    /**
     * Returns a string that represents arguments to query the database
     * @return String
     */
    @Override
    public String toPost() {
        return Utility.stringToPost("id", String.valueOf(id)) + "&" +
                Utility.stringToPost("id_parent", String.valueOf(idParent));
    }

    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current database object
     */
    @Override
    public void initialize() {
        id = 0;
        idParent = 0;
    }

    /**
     * Sets the properties of current database object given a json object that contains properties information
     * @param json JSONObject
     * @see JSONObject
     */
    @Override
    public void fromJson(JSONObject json) {
        if (json != null) {
            try {
                id = json.has("id") ? json.getInt("id") : 0;
                idParent = json.has("id_parent") ? json.getInt("id_parent") : 0;
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
            }
        }
    }

    /**
     * Sets the properties of current database object given a bundle object that contains properties information
     * @param bundle Bundle
     * @see Bundle
     */
    @Override
    public void fromBundle(Bundle bundle) {
        if (bundle != null) {
            id = bundle.get("id") != null ? bundle.getInt("id") : 0;
            idParent = bundle.get("id_parent") != null ? bundle.getInt("id_parent") : 0;
        }
    }

    /////////////////////////////
}
