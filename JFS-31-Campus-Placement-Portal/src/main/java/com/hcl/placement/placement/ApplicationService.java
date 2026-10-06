package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

import java.time.LocalDate;

public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private DriveRepository driveRepository;
    private EligibilityService eligibilityService;

    public ApplicationService(
            ApplicationRepository applicationRepository,
            DriveRepository driveRepository,
            EligibilityService eligibilityService) {

        this.applicationRepository = applicationRepository;
        this.driveRepository = driveRepository;
        this.eligibilityService = eligibilityService;
    }

    public boolean apply(
            long applicationId,
            Student student,
            long driveId) {

        if (student == null) {
            return false;
        }

        Drive drive =
                driveRepository.findByDriveId(driveId);

        if (drive == null) {
            return false;
        }

        boolean eligible =
                eligibilityService.isEligible(
                        student,
                        drive
                );

        if (!eligible) {
            return false;
        }

        if (LocalDate.now()
                .isAfter(drive.getApplicationDeadline())) {

            return false;
        }

        Application existingApplication =
                applicationRepository.findByStudentAndDrive(
                        student.getStudentId(),
                        driveId
                );

        if (existingApplication != null) {
            return false;
        }

        Application application =
                new Application(
                        applicationId,
                        student.getStudentId(),
                        driveId,
                        LocalDate.now()
                );

        applicationRepository.save(application);

        return true;
    }
}