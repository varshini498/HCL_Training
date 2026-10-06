package com.hcl.placement.student;

public class AcademicRecord {

    private long recordId;
    private long studentId;
    private double tenthPercentage;
    private double twelfthPercentage;
    private double cgpa;
    private int backlogs;

    public AcademicRecord(long recordId, long studentId,
                          double tenthPercentage,
                          double twelfthPercentage,
                          double cgpa,
                          int backlogs) {

        this.recordId = recordId;
        this.studentId = studentId;
        this.tenthPercentage = tenthPercentage;
        this.twelfthPercentage = twelfthPercentage;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
    }

    public long getRecordId() {
        return recordId;
    }

    public long getStudentId() {
        return studentId;
    }

    public double getTenthPercentage() {
        return tenthPercentage;
    }

    public double getTwelfthPercentage() {
        return twelfthPercentage;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public void displayAcademicRecord() {

        System.out.println("Record ID: " + recordId);
        System.out.println("Student ID: " + studentId);
        System.out.println("10th Percentage: " + tenthPercentage);
        System.out.println("12th Percentage: " + twelfthPercentage);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Backlogs: " + backlogs);
    }
}