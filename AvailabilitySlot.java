package com.smartopd.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an availability time range (start - end) for doctors or booked slots.
 * This allows flexible, dynamic slot ranges instead of a fixed enum.
 */
public class AvailabilitySlot {
    private final LocalTime start;
    private final LocalTime end;
    private static final DateTimeFormatter TF = DateTimeFormatter.ofPattern("h:mm a");

    public AvailabilitySlot(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }

    public int getDurationMins() {
        return (int) java.time.Duration.between(start, end).toMinutes();
    }

    @Override
    public String toString() {
        if (start == null || end == null) return "(none)";
        return TF.format(start) + " - " + TF.format(end);
    }
}
