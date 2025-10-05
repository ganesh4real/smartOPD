package com.smartopd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Represents a Patient in the system, extending the base User class.
 */
public class Patient extends User {
    private static final Logger LOGGER = Logger.getLogger(Patient.class.getName());
    private String patientName;
    private int age;
    private char gender;
    private String contact;
    private String address;
    private String patientID;
    private List<OPdetails> opHistory = new ArrayList<>();
    private List<LabResults> labResults = new ArrayList<>();

    public Patient(String userId, String password, String patientName, int age, char gender, String contact, String address, String patientID) {
        super(userId, password);
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
        this.patientID = patientID;
    }

    // --- Methods ---
    /**
     * Displays the patient's Out-Patient history (logged at FINE level).
     */
    public void viewOP() {
        LOGGER.fine("--- Viewing OP History for " + patientName + " ---");
        if (opHistory.isEmpty()) {
            LOGGER.fine("No past appointments found.");
        } else {
            for (OPdetails detail : opHistory) {
                LOGGER.fine(detail.toString());
            }
        }
    }
    
    /**
     * Displays the patient's lab results (logged at FINE level).
     */
    public void viewLabResults() {
        LOGGER.fine("--- Viewing Lab Results for " + patientName + " ---");
        if (labResults.isEmpty()) {
            LOGGER.fine("No lab results found.");
        } else {
            for (LabResults result : labResults) {
                LOGGER.fine(result.toString());
            }
        }
    }

    /**
     * Updates the patient's contact information.
     */
    public void updateInfo(String newContact, String newAddress) {
        this.contact = newContact;
        this.address = newAddress;
    }
    
    public void addOpDetail(OPdetails detail) {
        this.opHistory.add(detail);
    }
    
    public void addLabResult(LabResults result) {
        this.labResults.add(result);
    }

    // --- Additional getters required by the GUI ---
    public java.util.List<OPdetails> getOpHistory() {
        return this.opHistory;
    }

    public java.util.List<LabResults> getLabResults() {
        return this.labResults;
    }

    // --- Getters and Setters ---

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientID() {
        return patientID;
    }

    // Expose contact and address for UI use
    public String getContact() {
        return this.contact == null ? "" : this.contact;
    }

    public String getAddress() {
        return this.address == null ? "" : this.address;
    }

    // Additional getters/setters for editable patient fields
    public int getAge() { return this.age; }
    public void setAge(int age) { this.age = age; }

    public char getGender() { return this.gender; }
    public void setGender(char gender) { this.gender = gender; }

    public void setContact(String contact) { this.contact = contact; }
    public void setAddress(String address) { this.address = address; }
}
