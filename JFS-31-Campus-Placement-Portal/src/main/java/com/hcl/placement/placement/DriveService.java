package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

public class DriveService {

    private DriveRepository driveRepository;
    private EligibilityService eligibilityService;

    public DriveService(
            DriveRepository driveRepository,
            EligibilityService eligibilityService) {

        this.driveRepository = driveRepository;
        this.eligibilityService = eligibilityService;
    }

    public boolean createDrive(Drive drive) {

        if (drive == null) {
            return false;
        }

        Drive existingDrive =
                driveRepository.findByDriveId(
                        drive.getDriveId()
                );

        if (existingDrive != null) {
            return false;
        }

        driveRepository.save(drive);

        return true;
    }

    public Drive getDrive(long driveId) {

        return driveRepository.findByDriveId(driveId);
    }

    public boolean checkEligibility(
            long driveId,
            Student student) {

        Drive drive =
                driveRepository.findByDriveId(driveId);

        if (drive == null) {
            return false;
        }

        return eligibilityService.isEligible(
                student,
                drive
        );
    }
}
