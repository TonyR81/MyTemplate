package dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tonyhack.haircut.R;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ProgressDialog class
 *
 * Author: Antonino Razeti
 * Created: 21/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class ProgressDialog extends Dialog {

    /////////////////////////////
    // Private Declarations
    private ProgressBar progressBar;
    private TextView txtMessage;
    private String message;
    /////////////////////////////

    /////////////////////////////
    // Getters
    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the message
     * @param message String
     */
    public void setMessage(String message) {
        this.message = message;
        if (txtMessage != null) {
            txtMessage.setText(message);
        }
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new instance of ProgressDialog class given context
     * @param context Context
     */
    public ProgressDialog(@NonNull Context context) {
        super( context );
    }

    /**
     * Creates a new instance of ProgressDialog class given the context and the message to view
     * @param context Context
     * @param message String
     */
    public ProgressDialog(@NonNull Context context, String message) {
        super(context);
        this.message = message;
    }
    /////////////////////////////

    /////////////////////////////
    // Overrides

    /**
     * Overrides onCreate method
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.progress_dialog );
        txtMessage = findViewById(R.id.progress_message);
        if (!message.isEmpty()) {
            setMessage(message);
        }
    }
    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Dismiss this dialog
     */
    public void dismiss() {
        super.dismiss();
    }
    /////////////////////////////
}
