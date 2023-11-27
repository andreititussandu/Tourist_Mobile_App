package com.example.proiect_sanduandrei_titus;
import java.util.List;

public class EventAccommodation {
    private String eventName;
    private String hotelName;
    private String restaurantName;
    private List<Location> locations;

    public EventAccommodation(String eventName, String hotelName, String restaurantName, List<Location> locations) {
        this.eventName = eventName;
        this.hotelName = hotelName;
        this.restaurantName = restaurantName;
        this.locations = locations;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String event_name) {
        this.eventName = event_name;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotel_name) {
        this.hotelName = hotel_name;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurant_name) {
        this.restaurantName = restaurant_name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public static class Location {
        private String location;
        private String type;
        private Ratings ratings;

        public Location(String location, String type, Ratings ratings) {
            this.location = location;
            this.type = type;
            this.ratings = ratings;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Ratings getRatings() {
            return ratings;
        }

        public void setRatings(Ratings ratings) {
            this.ratings = ratings;
        }
    }

    public static class Ratings {
        private double eventAtmosphere;
        private double hotelService;
        private double restaurantFood;

        public Ratings(double eventAtmosphere, double hotelService, double restaurantFood) {
            this.eventAtmosphere = eventAtmosphere;
            this.hotelService = hotelService;
            this.restaurantFood = restaurantFood;
        }

        public double getEventAtmosphere() {
            return eventAtmosphere;
        }

        public void setEventAtmosphere(double event_atmosphere) {
            this.eventAtmosphere = event_atmosphere;
        }

        public double getHotelService() {
            return hotelService;
        }

        public void setHotelService(double hotel_service) {
            this.hotelService = hotel_service;
        }

        public double getRestaurantFood() {
            return restaurantFood;
        }

        public void setRestaurantFood(double restaurant_food) {
            this.restaurantFood = restaurant_food;
        }
    }
}
