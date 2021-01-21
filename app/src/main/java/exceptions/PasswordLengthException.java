package exceptions;

import android.content.Context;
import com.tonyhack.haircut.R;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * PasswordLengthException class
 *
 * Author: Antonino Razeti
 * Created: 31/12/2020
 * Version: 1.0
 **********************************************************************
 */
public class PasswordLengthException extends ExceptionBase {

    /////////////////////////////
    // Private declarations
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the message of current exception
     * @return String
     */
    @Override
    public String getMessage() {
        return getMessage(R.string.exception_password_length);
    }
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Constructors
    /**
     * Creates a new instance of ExceptionBase class given the context
     *
     * @param context Context
     */
    public PasswordLengthException(Context context) {
        super(context);
    }
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
