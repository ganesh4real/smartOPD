package com.smartopd.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Represents a waiting queue for a specific doctor on a specific date.
 */
public class Queue {
    private static final Logger LOGGER = Logger.getLogger(Queue.class.getName());
    private LocalDate date;
    private java.util.Queue<String> queueList; // Using Java's Queue interface
    private int maxSlots;

    public Queue(LocalDate date, int maxSlots) {
        this.date = date;
        this.maxSlots = maxSlots;
        this.queueList = new LinkedList<>();
    }

    /**
     * Adds a patient to the end of the queue.
     * @param patientID The ID of the patient to add.
     */
    public void enqueue(String patientID) {
        if (queueList.size() < maxSlots) {
            queueList.offer(patientID);
            LOGGER.fine("Patient " + patientID + " added to the queue.");
        } else {
            LOGGER.fine("The queue is full. Cannot add more patients.");
        }
    }

    /**
     * Removes and returns the patient from the front of the queue.
     * @return The ID of the patient at the front of the queue, or null if empty.
     */
    public String dequeue() {
        if (!queueList.isEmpty()) {
            String patientID = queueList.poll();
            LOGGER.fine("Patient " + patientID + " is next.");
            return patientID;
        } else {
            LOGGER.fine("The queue is empty.");
            return null;
        }
    }

    public int getPosition(String patientID) {
        int position = 1;
        for (String id : queueList) {
            if (id.equals(patientID)) {
                return position;
            }
            position++;
        }
        return -1; // Not in queue
    }

    public int size() {
        return queueList.size();
    }
}
