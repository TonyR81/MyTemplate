package collections;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONArray;
import org.json.JSONException;
import classes.Employee;
import interfaces.IEmployeesCollection;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * EmployeesCollection class
 *
 * Author: Antonino Razeti
 * Created: 13/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class EmployeesCollection extends PersonsCollection implements IEmployeesCollection {

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
    public EmployeesCollection() {
    }

    /**
     * Creates a new instance of UsersCollection class given a json array that contains users in json object format
     * @param array JSONArray
     * @see JSONArray
     */
    public EmployeesCollection(JSONArray array) {
        super(array);
    }

    /**
     * Creates a new instance of Employees Collection class given a parcelable array of employees
     * @param employees Parcelable[]
     * @see Parcelable
     */
    public EmployeesCollection(Parcelable[] employees) {
        addRange(employees);
    }

    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns current employees collection as an array of employees in bundle object format
     * @return Bundle[]
     */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        Bundle[] bundles = new Bundle[items.size()];
        for (int i = 0; i < items.size(); i++) {
            bundles[i].putBundle("employee", items.get(i).toBundle());
        }
        bundle.putParcelableArray("employee", bundles);
        return bundle;
    }
    /////////////////////////////

    /////////////////////////////
    // Methods
    /**
     * Add an array of employees given in specified json array that contains employees in json object format
     * @param array JSONArray
     * @see JSONArray
     */
    @Override
    public void addRange(JSONArray array) {
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                try {
                    if (array.getJSONObject(i).has("employee")) {
                        items.add(new Employee(array.getJSONObject(i).getJSONObject("employee")));
                    }
                } catch (JSONException e) {
                    Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Add an array of employees given in specified parcelable array that contains employees in bundle object format
     * @param parcelables Parcelable[]
     * @see Parcelable
     */
    public void addRange(Parcelable[] parcelables) {
        if (parcelables != null) {
            for (int i = 0; i < parcelables.length; i++) {
                Bundle bundle = (Bundle) parcelables[i];
                items.add(new Employee(bundle.getBundle("employee")));
            }
        }
    }
    /////////////////////////////
}
