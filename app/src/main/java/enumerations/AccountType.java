package enumerations;

import android.content.Context;
import com.tonyhack.haircut.R;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * AccountType enumeration
 *
 * Author: Antonino Razeti
 * Created: 04/01/2021
 * Version: 1.0
 **********************************************************************
 */
public enum AccountType {

    ////////////////////
    // Enumerations
    USER("User", 0),
    ADMIN("Admin", 1),
    SUPER_ADMIN("Super admin", 2),
    COMPANY("Company", 3),
    EMPLOYEE("Employee", 4),
    CUSTOMER("Customer", 5);
    ////////////////////

    ////////////////////
    // Private declarations
    private final String stringValue;
    private final int intValue;
    ////////////////////

    ////////////////////
    // Constructor
    /**
    * Creates a new instance of AccountType enumeration given the string value and int value
    */
    AccountType(String stringValue, int intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
    }
    ////////////////////

    ////////////////////
    // Functions
    /**
    * Returns the int value of current enumeration
    */
    public int getInt() {
        return intValue;
    }

    /**
    * Returns the enumeration given the int value
    */
    public static AccountType getAccountType(int value) {
        AccountType res = null;
        switch(value) {
            case 0:
                res = USER;
                break;
            case 1:
                res = ADMIN;
                break;
            case 2:
                res = SUPER_ADMIN;
                break;
            case 3:
                res = COMPANY;
                break;
            case 4:
                res = EMPLOYEE;
                break;
        }
        return res;
    }

    /**
     * Returns a string that represents current enumeration
     * @param context Context
     * @return String
     */
    public String toString(Context context) {
        String res = "";
        switch (this) {
            case USER:
                res = context.getString(R.string.user);
                break;
            case ADMIN:
                res = context.getString(R.string.admin);
                break;
            case SUPER_ADMIN:
                res = context.getString(R.string.super_admin);
                break;
            case COMPANY:
                res = context.getString(R.string.company);
                break;
            case EMPLOYEE:
                res = context.getString(R.string.employee);
                break;
            case CUSTOMER:
                res = context.getString(R.string.customer);
                break;
        }
        return res;
    }
    ////////////////////


}
