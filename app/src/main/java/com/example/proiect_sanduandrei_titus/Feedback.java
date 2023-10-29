package com.example.proiect_sanduandrei_titus;

import java.io.Serializable;

public class Feedback implements Serializable {
    private String name;
    private String email;
    private String attraction;
    private float rating;

    public Feedback(String name, String email, String attraction, float rating) {
        this.name = name;
        this.email = email;
        this.attraction = attraction;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback: " +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", attraction='" + attraction + '\'' +
                ", rating=" + rating;
    }
}
