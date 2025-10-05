package com.smartopd.model;

import java.time.LocalDate;
import java.util.logging.Logger;

//Represents the details of an Out-Patient (OP) appointment.
public class OPdetails {
    private static final Logger LOGGER = Logger.getLogger(OPdetails.class.getName());
    private int ticketID;
    private String doctorName;
    private String department;
    private LocalDate date;
    private AvailabilitySlot availabilitySlot;
    private String patientID;
    private int durationMins;

    public OPdetails(int ticketID, String doctorName, String department, LocalDate date, AvailabilitySlot availabilitySlot, String patientID, int durationMins) {
        this.ticketID = ticketID;
        this.doctorName = doctorName;
        this.department = department;
        this.date = date;
        this.availabilitySlot = availabilitySlot;
        this.patientID = patientID;
        this.durationMins = durationMins;
    }

    // Displays the OP details (logged at FINE level).
    public void viewOP() {
    LOGGER.fine("Ticket ID: " + ticketID +
        " | Doctor: " + doctorName +
        " | Dept: " + department +
        " | Date: " + date +
        " | Time: " + (availabilitySlot == null ? "(none)" : availabilitySlot.toString()));
    }

    @Override
    public String toString() {
     return "  Date: " + date +
         ", Time: " + (availabilitySlot == null ? "(none)" : availabilitySlot.toString()) +
               ", Duration: " + durationMins + " mins" +
               ", Doctor: '" + doctorName + '\'' +
               ", Department: '" + department + '\'' +
               ", Ticket ID: " + ticketID;
    }
    
    public String getTicketID() {
        return "T" + String.format("%03d", ticketID);
    }
    
    public String getPatientID() {
        return patientID;
    }
    
    public AvailabilitySlot getTimeSlot() {
        return availabilitySlot;
    }

    public java.time.LocalDate getDate() {
        return date;
    }

    public int getDurationMins() {
        return durationMins;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDepartment() {
        return department;
    }
}
