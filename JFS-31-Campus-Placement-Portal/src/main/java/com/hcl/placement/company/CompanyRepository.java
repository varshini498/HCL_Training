
package com.hcl.placement.company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();

    public boolean addCompany(Company company) {
        for (Company c : companies) {
            if (c.getCompanyId() == company.getCompanyId()) {
                return false;
            }
        }

        companies.add(company);
        return true;
    }

    public void displayCompanies() {
        if (companies.isEmpty()) {
            System.out.println("No companies registered.");
            return;
        }

        for (Company company : companies) {
            company.display();
        }
    }
    public Company findCompany(int companyId) {
    for (Company company : companies) {
        if (company.getCompanyId() == companyId) {
            return company;
        }
    }
    return null;
}
public int getCompanyCount() {
    return companies.size();
}
}
