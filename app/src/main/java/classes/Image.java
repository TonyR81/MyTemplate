package classes;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import enumerations.ImageType;
import interfaces.IImage;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * Image class
 *
 * Author: Antonino Razeti
 * Created: 31/12/2020
 * Version: 1.0
 **********************************************************************
 */
public class Image extends Database implements IImage {

    /////////////////////////////
    // Private declarations
    private String name;
    private ImageType type;
    private Bitmap bitmap;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the name of current image
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the type of current image
     * @return ImageType
     * @see ImageType
     */
    @Override
    public ImageType getType() {
        return type;
    }

    /**
     * Gets the bitmap of current image
     * @return Bitmap
     * @see Bitmap
     */
    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the name of current image
     * @param name String
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the type of current image
     * @param type ImageType
     * @see ImageType
     */
    @Override
    public void setType(ImageType type) {
        this.type = type;
    }

    /**
     * Sets the bitmap of current image
     * @param bitmap Bitmap
     * @see Bitmap
     */
    @Override
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of Image class
     */
    public Image() {
    }

    /**
     * Creates a new instance of Image class given a json object that contains current image object properties information
     * @param json JSONObject
     * @see JSONObject
     */
    public Image(JSONObject json) {
        super(json);
    }

    /**
     * Creates a new instance of Image class given a bundle object that contains current image object properties information
     * @param bundle Bundle
     * @see Bundle
     */
    public Image(Bundle bundle) {
        super(bundle);
    }

    /**
     * Creates a new instance of Image class given the id number associated with the image into database,
     * the id number associated with the parent of current image into database, the name and the type of the image
     * @param id int
     * @param idParent int
     * @param name String
     * @param type ImageType
     * @see ImageType
     */
    public Image(int id, int idParent, String name, ImageType type) {
        super(id, idParent);
        this.name = name;
        this.type = type;
    }

    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents current image
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            json.put("name", name);
            json.put("type", type.getInt());
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "toJson: " + e.getMessage());
        }
        return json;
    }

    /**
     * Returns a bundle object that represents current image
     * @return Bundle
     * @see Bundle
     */
    @Override
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putString("name", name);
        bundle.putInt("type", type.getInt());
        return bundle;
    }

    /**
     * Returns a string that represents the arguments of current image to query database
     * @return String
     */
    @Override
    public String toPost() {
        return super.toPost() + "&" + Utility.stringToPost("name", name) + "&" +
                Utility.stringToPost("type", String.valueOf(type.getInt()));
    }

    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current image
     */
    @Override
    public void initialize() {
        super.initialize();
        name = "";
        type = ImageType.PNG;
        bitmap = null;
    }

    /**
     * Sets the properties of current image given a json object that contains properties information
     * @param json JSONObject
     * @see JSONObject
     */
    @Override
    public void fromJson(JSONObject json) {
        super.fromJson(json);
        if (json != null) {
            try {
                name = json.has("name") ? json.getString("name") : "";
                type = json.has("type") ? ImageType.getImageType(json.getInt("type")) : ImageType.PNG;
                // TODO: 02/01/2021 Implementare codice per recuperare l'immagine dal dispositivo o da scaricare dal server
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
            }
        }
    }

    /**
     * Sets the properties of current image object given a bundle object that contains properties information
     * @param bundle Bundle
     * @see Bundle
     */
    @Override
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        if (bundle != null) {
            name = bundle.get("name") != null ? bundle.getString("name") : "";
            type = bundle.get("type") != null ? ImageType.getImageType(bundle.getInt("type")) : ImageType.PNG;
            // TODO: 02/01/2021 Implementare codice per recuperare l'immagine dal dispositivo o da scaricare dal server
        }
    }

    /////////////////////////////
}
