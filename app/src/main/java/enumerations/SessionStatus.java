package enumerations;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * SessionStatus enumeration
 *
 * Author: Antonino Razeti
 * Created: 12/01/2021
 * Version: 1.0
 **********************************************************************
 */
public enum SessionStatus {

    ////////////////////
    // Enumerations
    OFFLINE("Offline", 0),
    ONLINE("Online", 1);
    ////////////////////

    ////////////////////
    // Private declarations
    private final String stringValue;
    private final int intValue;
    ////////////////////

    ////////////////////
    // Constructor
    /**
    * Creates a new instance of SessionStatus enumeration given the string value and int value
    */
    SessionStatus(String stringValue, int intValue) {
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
    public static SessionStatus getSessionStatus(int value) {
        SessionStatus res = null;
        switch(value) {
            case 0:
                res = OFFLINE;
                break;
            case 1:
                res = ONLINE;
                break;
        }
        return res;
    }

    /**
     * Returns a string that represents current enumeration
     * @return String
     */
    public String toString() {
        return stringValue;
    }

    ////////////////////


}
