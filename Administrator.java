package com.smartopd.model;
import java.util.List;
import java.util.logging.Logger;

/**
 * Represents an Administrator in the system.
 */
public class Administrator extends User {
    private String adminName;
    private String adminRole;

    public Administrator(String userId, String password, String adminName, String adminRole) {
        super(userId, password);
        this.adminName = adminName;
        this.adminRole = adminRole;
    }

    // --- Methods to manage system entities ---

    public void addDoctor(List<Doctor> doctors, Doctor doctor) {
        doctors.add(doctor);
    }

    public void createLabResult(Patient patient, LabResults result) {
       if(patient != null) {
           patient.addLabResult(result);
       } else {
            // Log or handle null patient case
       }
    }

    /**
     * Create and attach a lab result for a patient identified by their patientID.
     * The caller should pass a collection of patients (for example DataStore.getPatients()).
     */
    public void createLabResultByPatientID(java.util.List<Patient> patients, String patientID, String testName, String resultValue) {
        if (patients == null || patientID == null) {


            return;
        }
        Patient p = null;
        for (Patient candidate : patients) {
            if (candidate != null && patientID.equals(candidate.getPatientID())) {
                p = candidate;
                break;
            }
        }
        if (p != null) {
            LabResults lr = new LabResults("", testName, resultValue);
            // If desired, set doctorName later or provide an overload that accepts doctor name
            p.addLabResult(lr);
            
            // Log success
        } else {
            
            // Log patient not found
        }
    }

    /**
     * Create and attach a lab result for a patient identified by their patientID with explicit doctor name.
     */
    public void createLabResultByPatientID(java.util.List<Patient> patients, String patientID, String doctorName, String testName, String resultValue) {
        if (patients == null || patientID == null) {
            
            // Log or handle null case
            return;
        }
        Patient p = null;
        for (Patient candidate : patients) {
            if (candidate != null && patientID.equals(candidate.getPatientID())) {
                p = candidate;
                break;
            }
        }
        if (p != null) {
            LabResults lr = new LabResults(doctorName == null ? "" : doctorName, testName, resultValue);
            p.addLabResult(lr);
            // Log success
        } else {
            // Log patient not found
        }
    }

    public void addAdmin(List<Administrator> admins, Administrator admin) {
        admins.add(admin);
        // Log addition
    }

    
    
    // --- Getters ---

    public String getAdminName() {
        return adminName;
    }
}
