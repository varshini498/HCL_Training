package com.hcl.placement.placement;

import java.time.LocalDate;

public class Application {

    private long applicationId;
    private long studentId;
    private long driveId;
    private LocalDate applicationDate;
    private ApplicationStatus status;

    public Application(long applicationId,
                       long studentId,
                       long driveId,
                       LocalDate applicationDate) {

        this.applicationId = applicationId;
        this.studentId = studentId;
        this.driveId = driveId;
        this.applicationDate = applicationDate;
        this.status = ApplicationStatus.APPLIED;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getDriveId() {
        return driveId;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void updateStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void displayApplication() {

        System.out.println("Application ID: " + applicationId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Drive ID: " + driveId);
        System.out.println("Application Date: " + applicationDate);
        System.out.println("Status: " + status);
    }
}