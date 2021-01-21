package enumerations;

import android.content.Context;
import com.tonyhack.haircut.R;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * AccountPlan enumeration
 *
 * Author: Antonino Razeti
 * Created: 04/01/2021
 * Version: 1.0
 **********************************************************************
 */
public enum AccountPlan {

    ////////////////////
    // Enumerations
    DEMO("Demo", 0),
    MONTHLY("Monthly", 1),
    BIMONTHLY("Bimonthly", 2),
    QUARTERLY("Quarterly", 3),
    SEMIANNUAL("Semi annual", 4),
    ANNUAL("Annual", 5),
    LIMITED("Limited", 6),
    UNLIMITED("Unlimited", 7);
    ////////////////////

    ////////////////////
    // Private declarations
    private final String stringValue;
    private final int intValue;
    ////////////////////

    ////////////////////
    // Constructor
    /**
    * Creates a new instance of AccountPlan enumeration given the string value and int value
    */
    AccountPlan(String stringValue, int intValue) {
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
    public static AccountPlan getAccountPlan(int value) {
        AccountPlan res = null;
        switch(value) {
            case 0:
                res = DEMO;
                break;
            case 1:
                res = MONTHLY;
                break;
            case 2:
                res = BIMONTHLY;
                break;
            case 3:
                res = QUARTERLY;
                break;
            case 4:
                res = SEMIANNUAL;
                break;
            case 5:
                res = ANNUAL;
                break;
            case 6:
                res = LIMITED;
                break;
            case 7:
                res = UNLIMITED;
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
            case DEMO:
                res = context.getString(R.string.demo);
                break;
            case MONTHLY:
                res = context.getString(R.string.monthly);
                break;
            case BIMONTHLY:
                res = context.getString(R.string.bimonthly);
                break;
            case QUARTERLY:
                res = context.getString(R.string.quarterly);
                break;
            case SEMIANNUAL:
                res = context.getString(R.string.semi_annual);
                break;
            case ANNUAL:
                res = context.getString(R.string.annual);
                break;
            case LIMITED:
                res = context.getString(R.string.limited);
                break;
            case UNLIMITED:
                res = context.getString(R.string.unlimited);
                break;
        }
        return res;
    }

    ////////////////////


}
