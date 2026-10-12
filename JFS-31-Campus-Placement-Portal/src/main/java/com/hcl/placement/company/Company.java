
package com.hcl.placement.company;

public class Company {
    private int companyId;
    private String name;
    private String industry;

    public Company(int companyId, String name, String industry) {
        this.companyId = companyId;
        this.name = name;
        this.industry = industry;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("\n--- Company Details ---");
        System.out.println("Company ID: " + companyId);
        System.out.println("Company Name: " + name);
        System.out.println("Industry: " + industry);
    }
}
