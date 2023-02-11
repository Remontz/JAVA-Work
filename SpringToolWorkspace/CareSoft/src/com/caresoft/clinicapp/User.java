package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    // Implement a constructor that takes an ID
    public User(Integer idValue) {
        id = idValue;
        pin = 0000;
    }
    // TO DO: Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer idValue) {
        id = idValue;
    }

    public int getPin() {
        return pin;
    }
    public void setPin (int newPin) {
        pin = newPin;
    }

    
}
