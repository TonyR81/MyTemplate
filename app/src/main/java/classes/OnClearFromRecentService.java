package classes;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import exceptions.InternetConnectionException;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * OnClearFromRecentService class
 * This class is used to check if the app is closed abnormally or differently
 * from manual action and, if the user is already logged in, it logs out
 * Author: Antonino Razeti
 * Created: 19/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class OnClearFromRecentService extends Service {

    /////////////////////////////
    // Private declarations
    private User user = null;
    /////////////////////////////

    /////////////////////////////
    // Getters
    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the user
     * @param user User
     * @see User
     */
    public void setUser(User user) {
        this.user = user;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Overrides onBind method
     * @param intent Intent
     * @return IBinder
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Overrides onDestroy method and logout of the user
     */
    @Override
    public void onDestroy() {
        if (user != null) {
            try {
                if (Utility.hasActiveInternetConnection(getApplicationContext())) {
                    ServerRequest request = new ServerRequest("logout");
                    JSONObject response = request.getResponse(user.toPost());
                    boolean result = response.has("response") && response.getBoolean("response");
                    Log.d(String.valueOf(R.string.app_name),
                            result ? String.valueOf(R.string.logout_successful) : String.valueOf(R.string.logout_error));
                }
            } catch (InternetConnectionException | JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "onDestroy: " + e.getMessage() + ", " + R.string.logout_error);
            }
        }
        super.onDestroy();
    }

    /**
     * Overrides onStartCommand method
     * @param intent Intent
     * @param flags int
     * @param startId int
     * @return int
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
