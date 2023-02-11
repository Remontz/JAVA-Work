package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
    // ... imports class definition...

    // Inside class:
    private ArrayList<String> patientNotes = new ArrayList<String>();

    // TO DO: Constructor that takes an ID
    public Physician(Integer idValue) {
        super(idValue);
    }

    // TO DO: Implement HIPAACompliantUser!
    public boolean assignPin(int newPin) {
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("Pin must be 4 digits.");
            return false;
        } else {
            this.setPin(newPin);
            return true;
        }
    }

    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (confirmedAuthID.equals(id)) {
            System.out.println("Authorized. Matching ID!");
            return true;
        } else {
            System.out.println("id doesnt match.");
            return false;
        }
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
                "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // TO DO: Setters & Getters
    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(String newPatientNote) {
        patientNotes.add(newPatientNote);
    }
}
