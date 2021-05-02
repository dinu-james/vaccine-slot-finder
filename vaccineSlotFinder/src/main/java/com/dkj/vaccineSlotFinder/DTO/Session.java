package com.dkj.vaccineSlotFinder.DTO;

public class Session {
    String min_age_limit;
    int  available_capacity;
    String date;

    public String getMin_age_limit() {
        return min_age_limit;
    }

    public void setMin_age_limit(String min_age_limit) {
        this.min_age_limit = min_age_limit;
    }

    public int getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(int available_capacity) {
        this.available_capacity = available_capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
