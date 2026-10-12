
package com.hcl.placement.offer;

public class Offer {

    private int offerId;
    private int applicationId;
    private String companyName;
    private double salary;
    private String status;

    public Offer(int offerId, int applicationId,
                 String companyName, double salary) {
        this.offerId = offerId;
        this.applicationId = applicationId;
        this.companyName = companyName;
        this.salary = salary;
        this.status = "OFFERED";
    }

    public int getOfferId() {
        return offerId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void display() {
        System.out.println("\n--- Offer Details ---");
        System.out.println("Offer ID: " + offerId);
        System.out.println("Application ID: " + applicationId);
        System.out.println("Company: " + companyName);
        System.out.println("Annual Salary (LPA): " + salary);
        System.out.println("Status: " + status);
    }
}
