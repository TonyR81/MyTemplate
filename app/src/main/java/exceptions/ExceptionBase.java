package exceptions;

import android.content.Context;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ExceptionBase class
 *
 * Author: Antonino Razeti
 * Created: 31/12/2020
 * Version: 1.0
 **********************************************************************
 */
public abstract class ExceptionBase extends Exception {

    /////////////////////////////
    // Private declarations
    private final Context context;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the message of current exception
     * @return String
     */
    public abstract String getMessage();

    /**
     * Returns the message of the exception given the int value of message
     * @param message int
     * @return String
     */
    protected String getMessage(int message) {
        return context.getString(message);
    }
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new instance of ExceptionBase class given the context
     * @param context Context
     */
    public ExceptionBase(Context context) {
        this.context = context;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
