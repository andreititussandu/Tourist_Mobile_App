package com.example.proiect_sanduandrei_titus;

import java.util.Date;

public class Event {
    String location;
    String name;
    String date;

    public Event(String location, String name, String date) {
        this.location = location;
        this.name = name;
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
