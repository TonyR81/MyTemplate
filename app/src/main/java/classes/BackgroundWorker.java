/*
 **********************************************************************
 * Copyright (c) 2019, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * Author: Antonino Razeti
 * Created: August 01, 2018
 * Since: 1.0
 **********************************************************************
 */
package classes;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * BackgroundWorker class
 *
 * Author: Antonino Razeti
 * Created: 09/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class BackgroundWorker extends AsyncTask<String, String, JSONObject> {

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
     * Creates a new instance of BackgroundWorker class
     * @param url String
     */
    public BackgroundWorker(String url) {
        this.url = url;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions
    @Override
    protected JSONObject doInBackground(String... params) {
        JSONObject response = new JSONObject(  );
        String post = params[0];
        try {
            // String DOMAIN = params[0]; //"https://www.lavanderialapegreen.it/gpricing/includes/"; // "http://192.168.43.94/gpricing/includes/";
            URL url = new URL( this.url );
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8 ));
                Objects.requireNonNull( bufferedWriter ).write(post);
                Objects.requireNonNull( bufferedWriter ).flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = null;
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1 ));
                String res = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    res += line;
                }
                Log.d(String.valueOf(R.string.app_name), "doInBackground: " + res);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                try {
                    response = new JSONObject( res );
                } catch (Exception e) {
                    response.put( "log", res );
                    Log.d(String.valueOf(R.string.app_name), "doInBackground: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            Log.d(String.valueOf(R.string.app_name), "doInBackground: " + e.getMessage());
        }
        return response;
    }
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////

}
