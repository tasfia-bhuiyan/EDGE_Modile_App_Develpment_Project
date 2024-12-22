package com.example.eventmanagement;

public class Guest {
    private String email;
    private String gender;

    public Guest(String email, String gender) {
        this.email = email;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
