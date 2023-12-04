package com.example.proiect_sanduandrei_titus.parser;

import com.example.proiect_sanduandrei_titus.Hotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataJsonParser {
    public static final String HOTEL_NAME = "hotel_name";
    public static final String LOCATION = "location";
    public static final String RATINGS = "ratings";
    public static final String CLEANLINESS = "cleanliness";
    public static final String SERVICE = "service";
    public static final String AMENITIES = "amenities";
    public static final String POOL = "pool";
    public static final String GYM = "gym";
    public static final String SPA = "spa";

    public static List<Hotel> fromJson(String json) {
        try {
            JSONArray array = new JSONArray(json);
            return readHotelsFromJson(array);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Hotel> readHotelsFromJson(JSONArray array) throws JSONException {
        List<Hotel> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            Hotel hotel = readHotelFromJson(object);
            result.add(hotel);
        }
        return result;
    }

    private static Hotel readHotelFromJson(JSONObject object) throws JSONException {
        String hotelName = object.getString(HOTEL_NAME);
        String location = object.getString(LOCATION);

        JSONObject ratingsObject = object.getJSONObject(RATINGS);
        double cleanliness = ratingsObject.getDouble(CLEANLINESS);
        double service = ratingsObject.getDouble(SERVICE);

        JSONObject amenitiesObject = ratingsObject.getJSONObject(AMENITIES);
        boolean pool = amenitiesObject.getBoolean(POOL);
        boolean gym = amenitiesObject.getBoolean(GYM);
        boolean spa = amenitiesObject.getBoolean(SPA);

        Hotel.Ratings ratings = new Hotel.Ratings(cleanliness, service, new Hotel.Amenities(pool, gym, spa));

        return new Hotel(hotelName, location, ratings);
    }
}
