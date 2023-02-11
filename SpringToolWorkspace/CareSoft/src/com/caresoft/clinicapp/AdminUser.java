package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    // ... imports class definition...

    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    private int pin;
//    private Integer id;

    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer idValue, String adminRole) {
        super(idValue);
        this.role = adminRole;
    }

    // TO DO: Implement HIPAACompliantUser!
    public boolean assignPin(int newPin) {
        if (newPin < 100000 || newPin > 999999) {
            System.out.println("Pin must be 6 digits.");
            return false;
        } else {
            this.setPin(newPin);
            return true;
        }
    }

    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (confirmedAuthID.equals(super.getId())) {
            System.out.println("Authorized. Matching ID!");
            return true;
        } else {
            this.authIncident();
            System.out.println("ID's do not match! Incident Report created.");
            return false;
        }
    }

    // TO DO: Implement HIPAACompliantAdmin!
    public ArrayList<String> reportSecurityIncidents() {
        return getSecurityIncidents();
    }

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes);
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
        securityIncidents.add(report);
    }

    // TO DO: Setters & Getters role, security incidents, pin
    public String getRole() {
        return role;
    }

    public void setRole(String newRole) {
        role = newRole;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> theSecurityIncidents) {
        securityIncidents = theSecurityIncidents;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int newPin) {
        pin = newPin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idValue) {
        id = idValue;
    }

}
