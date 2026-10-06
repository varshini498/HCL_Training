package com.hcl.placement.student;

public class Student {

    private long studentId;
    private long userId;
    private String registerNumber;
    private String branch;
    private int year;
    private double cgpa;
    private int backlogs;

    public Student(long studentId, long userId,
                   String registerNumber, String branch,
                   int year, double cgpa, int backlogs) {

        this.studentId = studentId;
        this.userId = userId;
        this.registerNumber = registerNumber;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getUserId() {
        return userId;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getBranch() {
        return branch;
    }

    public int getYear() {
        return year;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public void displayStudent() {

        System.out.println("Student ID: " + studentId);
        System.out.println("User ID: " + userId);
        System.out.println("Register Number: " + registerNumber);
        System.out.println("Branch: " + branch);
        System.out.println("Year: " + year);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Backlogs: " + backlogs);
    }
    public void updateProfile(
        String registerNumber,
        String branch,
        int year,
        double cgpa,
        int backlogs) {

    this.registerNumber = registerNumber;
    this.branch = branch;
    this.year = year;
    this.cgpa = cgpa;
    this.backlogs = backlogs;
}
}