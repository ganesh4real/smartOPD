package com.smartopd.model;

/**
 * Minimal LabTechnician model used by the GUI. Kept small for compilation.
 */
public class LabTechnician extends User {
    private String technicianName;
    private String department;
    private String technicianId;

    public LabTechnician(String userId, String password, String name, String department, String technicianId) {
        super(userId, password);
        this.technicianName = name;
        this.department = department;
        this.technicianId = technicianId;
    }

    public String getTechnicianName() { return technicianName; }
    public String getDepartment() { return department; }
    public String getTechnicianId() { return technicianId; }

    public LabResults createResult(Patient p, String testName, String resultValue) {
        return new LabResults(this.technicianName, testName, resultValue);
    }
}
