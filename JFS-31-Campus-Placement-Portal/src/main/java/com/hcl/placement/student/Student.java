
package com.hcl.placement.student;

public class Student {
    private int id;
    private String name;
    private String registerNumber;
    private String branch;
    private double cgpa;
    private int backlogs;

    public Student(int id, String name, String registerNumber,
                   String branch, double cgpa, int backlogs) {
        this.id = id;
        this.name = name;
        this.registerNumber = registerNumber;
        this.branch = branch;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
    }

    public int getId() {
        return id;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }
    public String getBranch() {
    return branch;
}

public double getCgpa() {
    return cgpa;
}

public int getBacklogs() {
    return backlogs;
}

    public void display() {
        System.out.println("\n--- Student Details ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Register Number: " + registerNumber);
        System.out.println("Branch: " + branch);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Backlogs: " + backlogs);
    }
}
