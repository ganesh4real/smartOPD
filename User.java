package com.smartopd.model;

/**
 * Represents a generic user in the SmartOPD system.
 * This is an abstract class that provides a base for specific user types
 * like Patient, Doctor, etc.
 */
public abstract class User {
    private String userId;
    private String password;
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(User.class.getName());

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Verifies the login credentials of the user.
     * @param userId The user ID to check.
     * @param password The password to check.
     * @return true if the credentials match, false otherwise.
     */
    public boolean verifyLogin(String userId, String password) {
        return this.userId.equals(userId) && this.password.equals(password);
    }

    /**
     * A placeholder for a registration method.
     * In a real application, this would handle new user registration.
     */
    public void registerPatient() {
        LOGGER.fine("Registration process would happen here.");
    }
}
