package com.hcl.placement.placement;

public class TrainingRegistration {

    private long registrationId;
    private long sessionId;
    private long studentId;

    public TrainingRegistration(long registrationId,
                                long sessionId,
                                long studentId) {

        this.registrationId = registrationId;
        this.sessionId = sessionId;
        this.studentId = studentId;
    }

    public long getRegistrationId() {
        return registrationId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void displayRegistration() {

        System.out.println(
                "Registration ID: " + registrationId
        );

        System.out.println(
                "Session ID: " + sessionId
        );

        System.out.println(
                "Student ID: " + studentId
        );
    }
}