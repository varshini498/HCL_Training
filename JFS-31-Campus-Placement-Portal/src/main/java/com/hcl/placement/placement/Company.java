package com.hcl.placement.placement;

public class Company {

    private long companyId;
    private String companyName;
    private String industry;
    private String website;

    public Company(long companyId,
                   String companyName,
                   String industry,
                   String website) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.industry = industry;
        this.website = website;
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public String getWebsite() {
        return website;
    }

    public void displayCompany() {

        System.out.println("Company ID: " + companyId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Industry: " + industry);
        System.out.println("Website: " + website);
    }
}