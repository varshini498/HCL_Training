package com.hcl.placement.placement;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {

    private List<Application> applications = new ArrayList<>();

    public void save(Application application) {
        applications.add(application);
    }

    public Application findByApplicationId(long applicationId) {

        for (Application application : applications) {

            if (application.getApplicationId() == applicationId) {
                return application;
            }
        }

        return null;
    }

    public Application findByStudentAndDrive(
            long studentId,
            long driveId) {

        for (Application application : applications) {

            if (application.getStudentId() == studentId
                    && application.getDriveId() == driveId) {

                return application;
            }
        }

        return null;
    }
}