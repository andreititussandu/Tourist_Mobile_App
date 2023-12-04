package com.example.proiect_sanduandrei_titus;

import androidx.annotation.NonNull;

public class Hotel {
    private String hotelName;
    private String location;
    private Ratings ratings;

    public Hotel(String hotelName, String location, Ratings ratings) {
        this.hotelName = hotelName;
        this.location = location;
        this.ratings = ratings;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    public static class Ratings {
        private double cleanliness;
        private double service;
        private Amenities amenities;

        public Ratings(double cleanliness, double service, Amenities amenities) {
            this.cleanliness = cleanliness;
            this.service = service;
            this.amenities = amenities;
        }

        public double getCleanliness() {
            return cleanliness;
        }

        public void setCleanliness(double cleanliness) {
            this.cleanliness = cleanliness;
        }

        public double getService() {
            return service;
        }

        public void setService(double service) {
            this.service = service;
        }

        public Amenities getAmenities() {
            return amenities;
        }

        public void setAmenities(Amenities amenities) {
            this.amenities = amenities;
        }
    }

    public static class Amenities {
        private boolean pool;
        private boolean gym;
        private boolean spa;

        public Amenities(boolean pool, boolean gym, boolean spa) {
            this.pool = pool;
            this.gym = gym;
            this.spa = spa;
        }

        public boolean isPool() {
            return pool;
        }

        public void setPool(boolean pool) {
            this.pool = pool;
        }

        public boolean isGym() {
            return gym;
        }

        public void setGym(boolean gym) {
            this.gym = gym;
        }

        public boolean isSpa() {
            return spa;
        }

        public void setSpa(boolean spa) {
            this.spa = spa;
        }

        @NonNull
        @Override
        public String toString() {
            return pool + "\n" + gym + "\n" + spa;
        }
    }
}
