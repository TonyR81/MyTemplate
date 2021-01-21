package classes;


import android.os.Bundle;
import android.util.Log;
import com.tonyhack.haircut.R;
import org.json.JSONException;
import org.json.JSONObject;
import interfaces.IGeoLocation;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * GeoLocation class
 *
 * Author: Antonino Razeti
 * Created: 02/01/2021
 * Version: 1.0
 **********************************************************************
 */
public class GeoLocation implements IGeoLocation {

    /////////////////////////////
    // Enumerations
    /*
     **********************************************************************
     * Copyright (c) 2021, TonyHack81
     * All Rights Reserved.
     **********************************************************************
     * Status enumeration
     *
     * Author: Antonino Razeti
     * Created: 07/01/2021
     * Version: 1.0
     **********************************************************************
     */
    private enum Status {
        ////////////////////
        // Enumerations
        ZERO_RESULTS("ZERO_RESULTS", 0),
        OK("OK", 1),
        REQUEST_DENIED("REQUEST_DENIED", 2);
        ////////////////////

        ////////////////////
        // Private declarations
        private final String stringValue;
        private final int intValue;
        ////////////////////

        ////////////////////
        // Constructor
        /**
        * Creates a new instance of Status enumeration given the string value and int value
        */
        Status(String stringValue, int intValue) {
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
        public static Status getStatus(int value) {
            Status res = null;
            switch(value) {
                case 0:
                    res = ZERO_RESULTS;
                    break;
                case 1:
                    res = OK;
                    break;
                case 2:
                    res = REQUEST_DENIED;
                    break;
            }
            return res;
        }

        /**
         * Returns the enumeration given the string value
         * @param value String
         * @return Status
         */
        public static Status getStatus(String value) {
            Status res;
            switch (value) {
                case "OK":
                    res = OK;
                    break;
                case "REQUEST_DENIED":
                    res = REQUEST_DENIED;
                case "ZERO_RESULTS":
                default:
                    res = ZERO_RESULTS;
                    break;
            }
            return res;
        }

        /**
         * Returns a string that represents current status
         * @return String
         */
        @Override
        public String toString() {
            return stringValue;
        }

        ////////////////////


    }
    /////////////////////////////


    /////////////////////////////
    // Private declarations
    private String address;
    private String streetNumber;
    private String city;
    private String country;
    private String zipCode;
    private String latitude;
    private String longitude;
    private String formattedAddress;
    private String placeId;
    private Status status;
    private boolean coordinatesFound;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the address of current location
     * @return String
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Gets the street number of current location
     * @return String
     */
    @Override
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Gets the city of current location
     * @return String
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * Gets the country of current location
     * @return String
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * Gets the zip code of current location
     * @return String
     */
    @Override
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Gets the latitude of current location
     * @return String
     */
    @Override
    public String getLatitude() {
        return latitude;
    }

    /**
     * Gets the longitude of current location
     * @return String
     */
    @Override
    public String getLongitude() {
        return longitude;
    }

    /**
     * Gets the formatted address of current location
     * @return String
     */
    @Override
    public String getFormattedAddress() {
        return formattedAddress;
    }

    /**
     * Gets the place id of current location
     * @return String
     */
    @Override
    public String getPlaceId() {
        return placeId;
    }

    /**
     * Gets a boolean value that indicates if coordinates, latitude and longitude, are found
     * @return boolean
     */
    @Override
    public boolean isCoordinatesFound() {
        return coordinatesFound;
    }

    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the address of current location
     * @param address String
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the street number of current location
     * @param streetNumber String
     */
    @Override
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Sets the city of current location
     * @param city String
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the country of current location
     * @param country String
     */
    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets the zip code of current location
     * @param zipCode String
     */
    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Sets the latitude of current location
     * @param latitude String
     */
    @Override
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets the longitude
     * @param longitude String
     */
    @Override
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets the formatted address of current geolocation
     * @param formattedAddress String
     */
    @Override
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    /**
     * Sets the place id of current geolocation
     * @param placeId String
     */
    @Override
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new empty instance of GeoLocation class
     */
    public GeoLocation() {

    }

    /**
     * Creates a new instance of GeoLocation class given address, street number, city, country, zip code, latitude and longitude
     * @param address String
     * @param streetNumber String
     * @param city String
     * @param country String
     * @param zipCode String
     * @param latitude String
     * @param longitude String
     */
    public GeoLocation(String address, String streetNumber, String city, String country, String zipCode, String latitude, String longitude) {
        this.address = address;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.formattedAddress = String.format("%s, %s, %s, %s, %s", address, streetNumber, zipCode, city, country);
        if (latitude.isEmpty() || longitude.isEmpty()) {
            if (!address.isEmpty() && !streetNumber.isEmpty() && !city.isEmpty()) {
                this.coordinatesFound = findCoordinates();
            }
        } else {
            this.coordinatesFound = true;
        }
    }

    /**
     * Creates a new instance of GeoLocation class given a json object that contains geolocation properties information
     * @param json JSONObject
     */
    public GeoLocation(JSONObject json) {
        fromJson(json);
    }

    /**
     * Creates a new instance of GeoLocation class given a bundle object that contains geolocation properties information
     * @param bundle Bundle
     */
    public GeoLocation(Bundle bundle) {
        fromBundle(bundle);
    }

    /////////////////////////////

    /////////////////////////////
    // Functions

    /**
     * Returns a json object that represents current geolocation
     * @return JSONObject
     * @see JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("address", address);
            json.put("street_number", streetNumber);
            json.put("city", city);
            json.put("country", country);
            json.put("zip_code", zipCode);
            json.put("latitude", latitude);
            json.put("longitude", longitude);
            json.put("formatted_address", formattedAddress);
            json.put("place_id", placeId);
        } catch (JSONException e) {
            Log.d(String.valueOf(R.string.app_name), "toJson: " + e.getMessage());
        }
        return json;
    }

    /**
     * Returns a bundle object that represents current location
     * @return Bundle
     * @see Bundle
     */
    @Override
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("address", address);
        bundle.putString("street_number", streetNumber);
        bundle.putString("city", city);
        bundle.putString("country", country);
        bundle.putString("zip_code", zipCode);
        bundle.putString("latitude", latitude);
        bundle.putString("longitude", longitude);
        bundle.putString("formatted_address", formattedAddress);
        bundle.putString("place_id", placeId);
        return bundle;
    }

    /**
     * Returns a string that represents the arguments of current geolocation to query database
     * @return String
     */
    @Override
    public String toPost() {
        return Utility.stringToPost("address", address) + "&" +
                Utility.stringToPost("street_number", streetNumber) + "&" +
                Utility.stringToPost("city", city) + "&" +
                Utility.stringToPost("country", country) + "&" +
                Utility.stringToPost("zip_code", zipCode) + "&" +
                Utility.stringToPost("latitude", latitude) + "&" +
                Utility.stringToPost("longitude", longitude) + "&" +
                Utility.stringToPost("formatted_address", formattedAddress) + "&" +
                Utility.stringToPost("place_id", placeId);
    }

    /**
     * Returns a string that represents current geolocation
     * @return String
     */
    @Override
    public String toString() {
        return formattedAddress;
    }

    /**
     * Find the coordinates of current geolocation
     * @return boolean
     */
    @Override
    public boolean findCoordinates() {
        return findCoordinates(address, streetNumber, city, country, zipCode);
    }

    /**
     * Find coordinates, latitude and longitude, given address, street number, city, country and zip code
     * @param address String
     * @param streetNumber String
     * @param city String
     * @param country String
     * @param zipCode String
     * @return boolean
     */
    @Override
    public boolean findCoordinates(String address, String streetNumber, String city, String country, String zipCode) {
        boolean res = false;
        String post = Utility.stringToPost("address", address) + "&" +
                Utility.stringToPost("street_number", streetNumber) + "&" +
                Utility.stringToPost("city", city) + "&" +
                Utility.stringToPost("country", country) + "&" +
                Utility.stringToPost("zip_code", zipCode);
        ServerRequest request = new ServerRequest("location.php");

        JSONObject result = request.getResponse(post);
        if (result.has("status")) {
            try {
                status = Status.getStatus(result.getString("status"));
                if (status == Status.OK) {
                    if (result.length() > 0 && result.has("results")) {
                        JSONObject json = result.getJSONArray("results").getJSONObject(0);
                        formattedAddress = json.has("formatted_address") ? json.getString("formatted_address"): "";
                        placeId = json.has("place_id") ? json.getString("place_id") : "";
                        if (json.has("location")) {
                            JSONObject location = json.getJSONObject("location");
                            longitude = location.has("latitude") ? location.getString("latitude") : "";
                            longitude = location.has("longitude") ? location.getString("longitude") : "";
                        }
                    }
                    res = !latitude.isEmpty() && !longitude.isEmpty();
                }
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "findCoordinates: " + e.getMessage());
            }
        }
        coordinatesFound = res;
        return res;
    }

    /**
     * Find coordinates of current geolocation given the arguments, address, street number, city, country and zip code
     * @param args String[]
     * @return boolean
     */
    @Override
    public boolean findCoordinates(String... args) {
        return findCoordinates(args[0], args[1], args[2], args[3], args[4]);
    }

    /////////////////////////////

    /////////////////////////////
    // Methods

    /**
     * Initialize current geolocation
     */
    @Override
    public void initialize() {
        address = "";
        streetNumber = "";
        city = "";
        country = "";
        zipCode = "";
        latitude = "";
        longitude = "";
        formattedAddress = "";
        placeId = "";
        status = Status.ZERO_RESULTS;
    }

    /**
     * Sets the geolocation properties given a json object that contains geolocation properties information
     * @param json JSONObject
     * @see JSONObject
     */
    @Override
    public void fromJson(JSONObject json) {
        if (json != null) {
            try {
                address = json.has("address") ? json.getString("address") : "";
                streetNumber = json.has("street_number") ? json.getString("street_number") : "";
                city = json.has("city") ? json.getString("city") : "";
                country = json.has("country") ? json.getString("country") : "";
                zipCode = json.has("zip_code") ? json.getString("zip_code") : "";
                latitude = json.has("latitude") ? json.getString("latitude") : "";
                longitude = json.has("longitude") ? json.getString("longitude") : "";
                formattedAddress = json.has("formatted_address") ? json.getString("formatted_address") : "";
                placeId = json.has("place_id") ? json.getString("place_id") : "";
                if (latitude.isEmpty() || longitude.isEmpty()) {
                    if (!address.isEmpty() && !streetNumber.isEmpty() && !city.isEmpty()) {
                        this.coordinatesFound = findCoordinates();
                    }
                } else {
                    this.coordinatesFound = true;
                }
            } catch (JSONException e) {
                Log.d(String.valueOf(R.string.app_name), "fromJson: " + e.getMessage());
            }

        }
    }

    /**
     * Sets the geolocation properties given a bundle object that contains geolocation properties information
     * @param bundle Bundle
     * @see Bundle
     */
    @Override
    public void fromBundle(Bundle bundle) {
        if (bundle != null) {
            address = bundle.get("address") != null ? bundle.getString("address") : "";
            streetNumber = bundle.get("street_number") != null ? bundle.getString("street_number") : "";
            city = bundle.get("city") != null ? bundle.getString("city") : "";
            country = bundle.get("country") != null ? bundle.getString("country") : "";
            zipCode = bundle.get("zip_code") != null ? bundle.getString("zip_code") : "";
            latitude = bundle.get("latitude") != null ? bundle.getString("latitude") : "";
            longitude = bundle.get("longitude") != null ? bundle.getString("longitude") : "";
            formattedAddress = bundle.get("formatted_address") != null ? bundle.getString("formatted_address") : "";
            placeId = bundle.get("place_id") != null ? bundle.getString("place_id") : "";
            if (latitude.isEmpty() || longitude.isEmpty()) {
                if (!address.isEmpty() && !streetNumber.isEmpty() && !city.isEmpty()) {
                    this.coordinatesFound = findCoordinates();
                }
            } else {
                this.coordinatesFound = true;
            }
        }
    }

    /////////////////////////////
}
