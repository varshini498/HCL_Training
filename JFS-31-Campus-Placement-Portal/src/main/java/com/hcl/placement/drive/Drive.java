
package com.hcl.placement.drive;

public class Drive {
    private int driveId;
    private int companyId;
    private String role;
    private double minimumCgpa;
    private String eligibleBranch;
    private int maximumBacklogs;

    public Drive(int driveId, int companyId, String role,
                 double minimumCgpa, String eligibleBranch,
                 int maximumBacklogs) {
        this.driveId = driveId;
        this.companyId = companyId;
        this.role = role;
        this.minimumCgpa = minimumCgpa;
        this.eligibleBranch = eligibleBranch;
        this.maximumBacklogs = maximumBacklogs;
    }

    public int getDriveId() {
        return driveId;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public String getEligibleBranch() {
        return eligibleBranch;
    }

    public int getMaximumBacklogs() {
        return maximumBacklogs;
    }

    public void display() {
        System.out.println("\n--- Placement Drive ---");
        System.out.println("Drive ID: " + driveId);
        System.out.println("Company ID: " + companyId);
        System.out.println("Job Role: " + role);
        System.out.println("Minimum CGPA: " + minimumCgpa);
        System.out.println("Eligible Branch: " + eligibleBranch);
        System.out.println("Maximum Backlogs: " + maximumBacklogs);
    }
    public boolean checkEligibility(
        String branch, double cgpa, int backlogs) {

    return this.eligibleBranch.equalsIgnoreCase(branch)
            && cgpa >= this.minimumCgpa
            && backlogs <= this.maximumBacklogs;
}
}
