package com.hcl.placement.placement;

public class CompanyTest {

    public static void main(String[] args) {

        Company company = new Company(
                4001L,
                "ABC Technologies",
                "Information Technology",
                "https://example.com"
        );

        company.displayCompany();
    }
}