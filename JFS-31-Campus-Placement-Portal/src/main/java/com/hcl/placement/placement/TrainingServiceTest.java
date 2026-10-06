package com.hcl.placement.placement;

import java.time.LocalDate;

public class TrainingServiceTest {

    public static void main(String[] args) {

        TrainingSessionRepository sessionRepository =
                new TrainingSessionRepository();

        TrainingRegistrationRepository registrationRepository =
                new TrainingRegistrationRepository();

        TrainingService trainingService =
                new TrainingService(
                        sessionRepository,
                        registrationRepository
                );

        TrainingSession session =
                new TrainingSession(
                        10001L,
                        "Java Interview Preparation",
                        "HCL Trainer",
                        LocalDate.of(2026, 10, 15),
                        30
                );

        boolean sessionCreated =
                trainingService.createSession(session);

        System.out.println(
                "Session created: " + sessionCreated
        );

        boolean registered =
                trainingService.registerStudent(
                        11001L,
                        2001L,
                        10001L
                );

        System.out.println(
                "Student registered: " + registered
        );

        TrainingRegistration registration =
                registrationRepository
                        .findByRegistrationId(11001L);

        if (registration != null) {

            System.out.println("\nRegistration Details:");

            registration.displayRegistration();
        }
    }
}