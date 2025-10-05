package com.smartopd.model;

/**
 * Enumeration for predefined appointment time slots.
 */
public enum TimeSlot {
    T0900("09:00"),
    T0915("09:15"),
    T0930("09:30"),
    T0945("09:45"),
    T1000("10:00"),
    T1015("10:15"),
    T1030("10:30"),
    T1045("10:45"),
    T1100("11:00"),
    T1115("11:15"),
    T1130("11:30"),
    T1145("11:45");

    private final String timeRange;

    TimeSlot(String timeRange) {
        this.timeRange = timeRange;
    }

    @Override
    public String toString() {
        return this.timeRange;
    }
}
