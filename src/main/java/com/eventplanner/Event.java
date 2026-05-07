package com.eventplanner;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

enum eventStatus{
    DRAFT,
    PUBLISHED,
    ACTIVE,
    COMPLETED,
    ARCHIVED,
    REJECTED
}

public class Event {
    //Create/Edit/Delete Events (with venue, date, time, type, description, etc.) 
    int capacity;
    Date date;
    int organizerID;
    int venueID;
    String time;
    String type;
    String description;
    eventStatus status;
    List<User> attendees;
    List<User> waitlist;

    public Event(int venueID, Date date, String time, String type, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.time = time;
        this.type = type;
        this.description = "";
        this.capacity = capacity;
        this.status = eventStatus.PUBLISHED;

        this.attendees = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public Event(int venueID, Date date, String time, String type, String description, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.time = time;
        this.type = type;
        this.description = description;
        this.capacity = capacity;
        this.status = eventStatus.PUBLISHED;

        this.attendees = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public Date getDate(){
        return this.date;
    }
    
    public String getTime(){
        return this.time;
    }
    public int getVenueID() {
        return this.venueID;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public eventStatus getStatus() {
        return this.status;
    }

    public void setStatus(eventStatus status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public List<User> getAttendeesList() {
        return this.attendees;
    }

    public List<User> getWaitlistList() {
        return this.waitlist;
    }

    public boolean isFull() {
        return attendees.size() >= capacity;
    }

    public void addAttendee(User user) {
        if (!attendees.contains(user)) {
            attendees.add(user);
        }
    }

    public void removeAttendee(User user) {
        attendees.remove(user);
    }

    public void addToWaitlist(User user) {
        if (!waitlist.contains(user)) {
            waitlist.add(user);
        }
    }

    public void removeFromWaitlist(User user) {
        waitlist.remove(user);
    }

    public User removeFirstFromWaitlist() {
        if (waitlist.isEmpty()) {
            return null;
        }

        return waitlist.remove(0);
    }
}
