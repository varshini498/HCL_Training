
package com.hcl.placement.training;

public class Training {

    private int trainingId;
    private int studentId;
    private String sessionName;
    private String status;

    public Training(int trainingId, int studentId, String sessionName) {
        this.trainingId = trainingId;
        this.studentId = studentId;
        this.sessionName = sessionName;
        this.status = "REGISTERED";
    }

    public int getTrainingId() {
        return trainingId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void display() {
        System.out.println("\n--- Training Registration ---");
        System.out.println("Training ID: " + trainingId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Session: " + sessionName);
        System.out.println("Status: " + status);
    }
}
