package com.hcl.placement.placement;

import java.time.LocalDate;

public class Drive {

    private long driveId;
    private long companyId;
    private String jobRole;
    private double minimumCgpa;
    private int maximumBacklogs;
    private String eligibleBranch;
    private int eligibleYear;
    private LocalDate applicationDeadline;

    public Drive(long driveId,
                 long companyId,
                 String jobRole,
                 double minimumCgpa,
                 int maximumBacklogs,
                 String eligibleBranch,
                 int eligibleYear,
                 LocalDate applicationDeadline) {

        this.driveId = driveId;
        this.companyId = companyId;
        this.jobRole = jobRole;
        this.minimumCgpa = minimumCgpa;
        this.maximumBacklogs = maximumBacklogs;
        this.eligibleBranch = eligibleBranch;
        this.eligibleYear = eligibleYear;
        this.applicationDeadline = applicationDeadline;
    }

    public long getDriveId() {
        return driveId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public int getMaximumBacklogs() {
        return maximumBacklogs;
    }

    public String getEligibleBranch() {
        return eligibleBranch;
    }

    public int getEligibleYear() {
        return eligibleYear;
    }

    public LocalDate getApplicationDeadline() {
        return applicationDeadline;
    }

    public void displayDrive() {

        System.out.println("Drive ID: " + driveId);
        System.out.println("Company ID: " + companyId);
        System.out.println("Job Role: " + jobRole);
        System.out.println("Minimum CGPA: " + minimumCgpa);
        System.out.println("Maximum Backlogs: " + maximumBacklogs);
        System.out.println("Eligible Branch: " + eligibleBranch);
        System.out.println("Eligible Year: " + eligibleYear);
        System.out.println("Application Deadline: " + applicationDeadline);
    }
}