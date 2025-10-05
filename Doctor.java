package com.smartopd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * Represents a Doctor in the system.
 */
public class Doctor extends User {
    private static final Logger LOGGER = Logger.getLogger(Doctor.class.getName());
    private String name;
    private int doctorId;
    private String department;
    private List<String> qualifications;
    private List<AvailabilitySlot> weeklyAvailability;
    private int maxSlots;
    private int timeslotLengthMins = 15; // default timeslot length in minutes
    private List<OPdetails> appointments = new ArrayList<>();

    public Doctor(String userId, String password, String name, int doctorId, String department, List<String> qualifications, int maxSlots) {
        super(userId, password);
        this.name = name;
        this.doctorId = doctorId;
        this.department = department;
        this.qualifications = qualifications;
        this.maxSlots = maxSlots;
    this.weeklyAvailability = new ArrayList<>(); // Default to empty
    }

    // --- Methods ---
    
    public void addAppointment(OPdetails appointment) {
        appointments.add(appointment);
    }

    /**
     * Updates the doctor's schedule.
     */
    public void updateSchedule(List<AvailabilitySlot> newAvailability) {
        this.weeklyAvailability = newAvailability;
        LOGGER.fine("Dr. " + name + "'s schedule has been updated.");
    }

    /**
     * Updates the doctor's personal details.
     */
    public void updateDetails(String department, List<String> qualifications) {
        this.department = department;
        this.qualifications = qualifications;
        LOGGER.fine("Dr. " + name + "'s details have been updated.");
    }
    
    public void viewAppointments() {
        LOGGER.fine("--- Today's Appointments for Dr. " + this.getName() + " ---");
        if (appointments.isEmpty()) {
            LOGGER.fine("No appointments scheduled for today.");
            return;
        }
        for (OPdetails appt : appointments) {
            LOGGER.fine("Ticket: " + appt.getTicketID() + " | Patient ID: " + appt.getPatientID() + " | Time: " + appt.getTimeSlot());
        }
        LOGGER.fine("----------------------------------------------");
    }

    // --- Getters and Setters ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }
    
      public java.util.List<AvailabilitySlot> getWeeklyAvailability() {
          return weeklyAvailability;
    }

    /**
     * Returns the list of appointments for the doctor.
     */
    public java.util.List<OPdetails> getAppointments() {
        return this.appointments;
    }

    // Gets the configured timeslot length in minutes for the doctor.
    public int getTimeslotLengthMins() {
        return this.timeslotLengthMins;
    }

    /**
     * Sets the timeslot length (minutes) for the doctor. This is a preference used by the UI
     * and scheduling logic to understand consult duration. It does not automatically
     * reschedule existing appointments.
     */
    public void setTimeslotLengthMins(int mins) {
        if (mins > 0) {
            this.timeslotLengthMins = mins;
            LOGGER.fine("Dr. " + name + " timeslot length set to " + mins + " minutes.");
        }
    }
}
