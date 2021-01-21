package enumerations;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ShaType enumeration
 *
 * Author: Antonino Razeti
 * Created: 05/01/2021
 * Version: 1.0
 **********************************************************************
 */
public enum ShaType {

    ////////////////////
    // Enumerations
    SHA1("SHA-1", 0),
    SHA256("SHA-256", 1),
    SHA512("SHA-512", 2),
    MD5("MD5", 3);
    ////////////////////

    ////////////////////
    // Private declarations
    private final String stringValue;
    private final int intValue;
    ////////////////////

    ////////////////////
    // Constructor
    /**
    * Creates a new instance of ShaType enumeration given the string value and int value
    */
    ShaType(String stringValue, int intValue) {
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
    public static ShaType getShaType(int value) {
        ShaType res = null;
        switch(value) {
            case 0:
            res = SHA1;
            break;
            case 1:
                res = SHA256;
                break;
            case 2:
                res = SHA512;
                break;
            case 3:
                res = MD5;
                break;
        }
        return res;
    }

    /**
     * Returns a string that represents current
     * @return String
     */
    @Override
    public String toString() {
        return stringValue;
    }

    ////////////////////


}
