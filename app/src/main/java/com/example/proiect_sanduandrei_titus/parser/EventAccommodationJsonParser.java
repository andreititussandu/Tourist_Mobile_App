package com.example.proiect_sanduandrei_titus.parser;

import com.example.proiect_sanduandrei_titus.EventAccommodation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EventAccommodationJsonParser {
    public static final String EVENT_NAME = "event_name";
    public static final String HOTEL_NAME = "hotel_name";
    public static final String RESTAURANT_NAME = "restaurant_name";
    public static final String LOCATIONS = "locations";
    public static final String LOCATION = "location";
    public static final String TYPE = "type";
    public static final String RATINGS = "ratings";
    public static final String EVENT_ATMOSPHERE = "event_atmosphere";
    public static final String HOTEL_SERVICE = "hotel_service";
    public static final String RESTAURANT_FOOD = "restaurant_food";

    public static Collection<? extends EventAccommodation> fromJson(String json){
        try {
            JSONArray array=new JSONArray(json);
            return readEventAccommodationsFromJson(array);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<EventAccommodation> readEventAccommodationsFromJson(JSONArray array) throws JSONException {
        List<EventAccommodation> result=new ArrayList<>();
        for(int i=0;i< array.length();i++) {
            JSONObject object = array.getJSONObject(i);
            EventAccommodation eventAccommodation=readEventAccommodationFromJson(object);
            result.add(eventAccommodation);
        }
        return result;
    }

    private static EventAccommodation readEventAccommodationFromJson(JSONObject object) throws JSONException {
        String eventName = object.getString(EVENT_NAME);
        String hotelName = object.getString(HOTEL_NAME);
        String restaurantName = object.getString(RESTAURANT_NAME);

        List<EventAccommodation.Location> locations = new ArrayList<>();
        JSONArray locationsArray = object.getJSONArray(LOCATIONS);

        for (int i = 0; i < locationsArray.length(); i++) {
            JSONObject locationObject = locationsArray.getJSONObject(i);
            String locationName = locationObject.getString(LOCATION);
            String locationType = locationObject.getString(TYPE);

            JSONObject ratingsObject = locationObject.getJSONObject(RATINGS);
            double eventAtmosphere = ratingsObject.getDouble(EVENT_ATMOSPHERE);
            double hotelService = ratingsObject.getDouble(HOTEL_SERVICE);
            double restaurantFood = ratingsObject.getDouble(RESTAURANT_FOOD);

            EventAccommodation.Ratings ratings = new EventAccommodation.Ratings(eventAtmosphere, hotelService, restaurantFood);
            EventAccommodation.Location location = new EventAccommodation.Location(locationName, locationType, ratings);

            locations.add(location);
        }
        return new EventAccommodation(eventName, hotelName, restaurantName, locations);
    }
}
