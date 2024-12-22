
package com.example.eventmanagement;

public class Event {
    private String name;
    private String date;
    private String venue;
    private String time;

    public Event(String name, String date, String venue, String time) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public String getTime() {
        return time;
    }
}
