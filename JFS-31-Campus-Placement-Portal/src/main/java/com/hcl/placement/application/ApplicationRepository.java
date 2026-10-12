
package com.hcl.placement.application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {

    private List<Application> applications = new ArrayList<>();

    public boolean addApplication(Application application) {

        for (Application existing : applications) {

            if (existing.getApplicationId()
                    == application.getApplicationId()) {
                System.out.println("Application ID already exists.");
                return false;
            }

            if (existing.getStudentId() == application.getStudentId()
                    && existing.getDriveId() == application.getDriveId()) {
                System.out.println(
                        "This student has already applied for this drive."
                );
                return false;
            }
        }

        applications.add(application);
        return true;
    }

    public void displayApplications() {
        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (Application application : applications) {
            application.display();
        }
    }

    public Application findApplication(int applicationId) {
        for (Application application : applications) {
            if (application.getApplicationId() == applicationId) {
                return application;
            }
        }
        return null;
    }
    public int getApplicationCount() {
    return applications.size();
}
}
