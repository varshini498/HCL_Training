package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

import java.time.LocalDate;

public class ApplicationServiceTest {

    public static void main(String[] args) {

        DriveRepository driveRepository =
                new DriveRepository();

        EligibilityService eligibilityService =
                new EligibilityService();

        ApplicationRepository applicationRepository =
                new ApplicationRepository();

        ApplicationService applicationService =
                new ApplicationService(
                        applicationRepository,
                        driveRepository,
                        eligibilityService
                );

        Drive drive = new Drive(
                5001L,
                4001L,
                "Software Developer",
                7.5,
                0,
                "AIML",
                3,
                LocalDate.of(2026, 10, 20)
        );

        driveRepository.save(drive);

        Student student = new Student(
                2001L,
                1001L,
                "23AIML001",
                "AIML",
                3,
                8.8,
                0
        );

        boolean applied =
                applicationService.apply(
                        6001L,
                        student,
                        5001L
                );

        System.out.println(
                "Application successful: " + applied
        );

        Application application =
                applicationRepository.findByApplicationId(6001L);

        if (application != null) {

            System.out.println("\nApplication Details:");

            application.displayApplication();
        }
    }
}