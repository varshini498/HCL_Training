package com.hcl.placement.placement;

import com.hcl.placement.student.Student;
import java.time.LocalDate;

public class M4IntegrationTest {

    public static void main(String[] args) {

        System.out.println("===== M4 PLACEMENT FLOW TEST =====");

        Student student = new Student(
                2001L,
                1001L,
                "23AIML001",
                "AIML",
                3,
                8.8,
                0
        );

        DriveRepository driveRepository =
                new DriveRepository();

        EligibilityService eligibilityService =
                new EligibilityService();

        DriveService driveService =
                new DriveService(
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

        driveService.createDrive(drive);

        System.out.println("\n1. Eligibility Check");

        boolean eligible =
                driveService.checkEligibility(
                        5001L,
                        student
                );

        System.out.println("Eligible: " + eligible);

        ApplicationRepository applicationRepository =
                new ApplicationRepository();

        ApplicationService applicationService =
                new ApplicationService(
                        applicationRepository,
                        driveRepository,
                        eligibilityService
                );

        System.out.println("\n2. Application");

        boolean applied =
                applicationService.apply(
                        6001L,
                        student,
                        5001L
                );

        System.out.println("Application submitted: " + applied);

        RoundRepository roundRepository =
                new RoundRepository();

        RoundResultRepository resultRepository =
                new RoundResultRepository();

        RoundService roundService =
                new RoundService(
                        roundRepository,
                        resultRepository
                );

        System.out.println("\n3. Round");

        Round round = new Round(
                7001L,
                5001L,
                1,
                "Technical Interview"
        );

        boolean roundCreated =
                roundService.createRound(round);

        System.out.println(
                "Round created: " + roundCreated
        );

        System.out.println("\n4. Round Result");

        boolean resultUploaded =
                roundService.uploadResult(
                        8001L,
                        7001L,
                        2001L,
                        true
                );

        System.out.println(
                "Result uploaded: " + resultUploaded
        );

        OfferRepository offerRepository =
                new OfferRepository();

        OfferService offerService =
                new OfferService(offerRepository);

        System.out.println("\n5. Offer");

        Offer offer = new Offer(
                9001L,
                2001L,
                4001L,
                5001L,
                "REGULAR",
                6.0
        );

        boolean offerRecorded =
                offerService.recordOffer(offer);

        System.out.println(
                "Offer recorded: " + offerRecorded
        );

        System.out.println("\n===== M4 FLOW COMPLETED =====");
    }
}