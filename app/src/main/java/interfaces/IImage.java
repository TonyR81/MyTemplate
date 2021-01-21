package interfaces;

import android.graphics.Bitmap;

import org.json.JSONObject;

import enumerations.ImageType;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IImage interface
 * This interface contains properties and methods of IImage class
 * Author: Antonino Razeti
 * Created: 31/12/2020
 * Version: 1.0
 **********************************************************************
 */
public interface IImage {

    /////////////////////////////
    // Getters
    String getName();
    Bitmap getBitmap();
    ImageType getType();
    /////////////////////////////

    /////////////////////////////
    // Setters
    void setName(String name);
    void setBitmap(Bitmap bitmap);
    void setType(ImageType imageType);
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
