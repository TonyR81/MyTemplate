package enumerations;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ImageType enumeration
 *
 * Author: Antonino Razeti
 * Created: 31/12/2020
 * Version:
 **********************************************************************
 */
public enum ImageType {

    ////////////////////
    // Enumerations
    PNG("Png", 0),
    BMP("Bitmap", 1),
    JPEG("Jpeg", 2),
    ICO("Icon", 3),
    GIF("GIF", 4);
    ////////////////////

    ////////////////////
    // Private declarations
    private String stringValue;
    private int intValue;
    ////////////////////

    ////////////////////
    // Constructor
    /**
    * Creates a new instance of ImageType enumeration given the string value and int value
    */
    ImageType(String stringValue, int intValue) {
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
    public static ImageType getImageType(int value) {
        ImageType res = null;
        switch(value) {
            case 0:
                res = PNG;
                break;
            case 1:
                res = BMP;
                break;
            case 2:
                res = JPEG;
                break;
            case 3:
                res = ICO;
                break;
            case 4:
                res = GIF;
                break;
        }
        return res;
    }
    ////////////////////


}
