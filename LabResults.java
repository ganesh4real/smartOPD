package com.smartopd.model;

import java.util.logging.Logger;

/**
 * Represents the lab results for a patient.
 */
public class LabResults {
    private static final Logger LOGGER = Logger.getLogger(LabResults.class.getName());
    private String doctorName;
    private String testName;
    private String resultValue; 
    public LabResults(String doctorName, String testName, String resultValue) {
        this.doctorName = doctorName;
        this.testName = testName;
        this.resultValue = resultValue;
    }

    /**
     * Updates the result value.
     */
    public void updateResults(String newValue) {
        this.resultValue = newValue;
    }

    /**
     * Displays the lab result.
     */
    public void viewResult() {
        LOGGER.fine("Test: " + testName + ", Result: " + resultValue + ", Authorized by: " + doctorName);
    }
    
    @Override
    public String toString() {
        return "  Test: '" + testName + '\'' +
               ", Result: '" + resultValue + '\'' +
               ", Authorized by Dr.: '" + doctorName + '\'';
    }
}
