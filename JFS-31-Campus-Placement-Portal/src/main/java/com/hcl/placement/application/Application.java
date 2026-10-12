
package com.hcl.placement.application;

public class Application {
    private int applicationId;
    private int studentId;
    private int driveId;
    private String status;

    public Application(int applicationId, int studentId, int driveId) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.driveId = driveId;
        this.status = "APPLIED";
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getDriveId() {
        return driveId;
    }

    public String getStatus() {
        return status;
    }

    public void display() {
        System.out.println("\n--- Application Details ---");
        System.out.println("Application ID: " + applicationId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Drive ID: " + driveId);
        System.out.println("Status: " + status);
    }
}
