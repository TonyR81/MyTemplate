package classes;

import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONObject;
import java.util.concurrent.ExecutionException;
import interfaces.IServerRequest;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * ServerRequest class
 *
 * Author: Antonino Razeti
 * Created: 07/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class ServerRequest implements IServerRequest {

    /////////////////////////////
    // Private declarations
    private final String url;
    /////////////////////////////

    /////////////////////////////
    // Getters
    /////////////////////////////

    /////////////////////////////
    // Setters
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new instance of ServerRequest class given the url
     * @param url String
     */
    public ServerRequest(String url) {
        this.url = String.format("%s%s", R.string.domain, !url.contains(".php") ? String.format("%s.php", url) : url);
    }
    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns the response, in json object format, from server given the post arguments
     * @param post String
     * @return JSONObject
     */
    @Override
    public JSONObject getResponse(String post) {
        JSONObject res = new JSONObject();
        BackgroundWorker bg = new BackgroundWorker(url);
        try {
            res = bg.execute(post).get();
        } catch (InterruptedException e) {
            Log.d(String.valueOf(R.string.app_name), "getResponse: " + e.getMessage());
        } catch (ExecutionException e) {
            Log.d(String.valueOf(R.string.app_name), "getResponse: " + e.getMessage());
        }
        return res;
    }

    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
