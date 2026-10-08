package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class M5IntegrationTest {

    public static void main(String[] args) {

        System.out.println("===== M5 TRAINING & ANALYTICS TEST =====");

        // Training

        TrainingSessionRepository sessionRepository =
                new TrainingSessionRepository();

        TrainingRegistrationRepository registrationRepository =
                new TrainingRegistrationRepository();

        TrainingService trainingService =
                new TrainingService(
                        sessionRepository,
                        registrationRepository
                );

        TrainingSession session = new TrainingSession(
                10001L,
                "Java Full Stack Training",
                "HCL Trainer",
                LocalDate.of(2026, 10, 15),
                50
        );

        boolean sessionCreated =
                trainingService.createSession(session);

        System.out.println(
                "\nTraining session created: "
                        + sessionCreated
        );

        boolean registered =
                trainingService.registerStudent(
                        11001L,
                        2001L,
                        10001L
                );

        System.out.println(
                "Student registered: "
                        + registered
        );

        // Statistics

        List<Student> students = new ArrayList<>();

        students.add(
                new Student(
                        2001L,
                        1001L,
                        "23AIML001",
                        "AIML",
                        3,
                        8.8,
                        0
                )
        );

        students.add(
                new Student(
                        2002L,
                        1002L,
                        "23AIML002",
                        "AIML",
                        3,
                        8.2,
                        0
                )
        );

        students.add(
                new Student(
                        2003L,
                        1003L,
                        "23AIML003",
                        "AIML",
                        3,
                        7.9,
                        0
                )
        );

        OfferRepository offerRepository =
                new OfferRepository();

        Offer offer = new Offer(
                9001L,
                2001L,
                4001L,
                5001L,
                "REGULAR",
                6.0
        );

        offerRepository.save(offer);

        StatisticsService statisticsService =
                new StatisticsService();

        double placementPercentage =
                statisticsService.calculatePlacementPercentage(
                        students,
                        offerRepository,
                        "AIML"
                );

        System.out.println(
                "\nAIML Placement Percentage: "
                        + placementPercentage + "%"
        );

        System.out.println(
                "\n===== M5 COMPLETED ====="
        );
    }
}