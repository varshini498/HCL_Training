package com.hcl.placement;

import com.hcl.placement.student.Student;
import com.hcl.placement.student.StudentRepository;
import com.hcl.placement.student.ResumeRepository;
import com.hcl.placement.student.StudentService;

import com.hcl.placement.placement.Company;
import com.hcl.placement.placement.Drive;
import com.hcl.placement.placement.DriveRepository;
import com.hcl.placement.placement.DriveService;
import com.hcl.placement.placement.EligibilityService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentRepository studentRepository =
                new StudentRepository();

        ResumeRepository resumeRepository =
                new ResumeRepository();

        StudentService studentService =
                new StudentService(
                        studentRepository,
                        resumeRepository
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

        int choice;

        do {

            System.out.println("\n===== JFS-31 CAMPUS PLACEMENT PORTAL =====");
            System.out.println("1. Student Management");
            System.out.println("2. Placement Drives");
            System.out.println("3. Applications");
            System.out.println("4. Round Results");
            System.out.println("5. Offers");
            System.out.println("6. Training");
            System.out.println("7. Placement Statistics");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n===== STUDENT MANAGEMENT =====");

                    Student student = new Student(
                            2001L,
                            1001L,
                            "23AIML001",
                            "AIML",
                            3,
                            8.8,
                            0
                    );

                    boolean created =
                            studentService.createStudent(student);

                    if (created) {
                        System.out.println(
                                "Student created successfully."
                        );
                    } else {
                        System.out.println(
                                "Student already exists."
                        );
                    }

                    Student foundStudent =
                            studentService.getStudent(2001L);

                    if (foundStudent != null) {
                        foundStudent.displayStudent();
                    }

                    break;

                case 2:

                    System.out.println("\n===== PLACEMENT DRIVE =====");

                    Company company = new Company(
                            4001L,
                            "ABC Technologies",
                            "Information Technology",
                            "https://example.com"
                    );

                    Drive drive = new Drive(
                            5001L,
                            company.getCompanyId(),
                            "Software Developer",
                            7.5,
                            0,
                            "AIML",
                            3,
                            LocalDate.of(2026, 10, 20)
                    );

                    boolean driveCreated =
                            driveService.createDrive(drive);

                    if (driveCreated) {
                        System.out.println(
                                "Placement drive created successfully."
                        );
                    } else {
                        System.out.println(
                                "Placement drive already exists."
                        );
                    }

                    System.out.println("\nCompany Details:");
                    company.displayCompany();

                    System.out.println("\nDrive Details:");
                    drive.displayDrive();

                    Student eligibleStudent =
                            studentService.getStudent(2001L);

                    boolean eligible =
                            driveService.checkEligibility(
                                    5001L,
                                    eligibleStudent
                            );

                    if (eligible) {
                        System.out.println(
                                "\nStudent is eligible for this drive."
                        );
                    } else {
                        System.out.println(
                                "\nStudent is not eligible for this drive."
                        );
                    }

                    break;

                case 3:
                    System.out.println("Applications selected.");
                    break;

                case 4:
                    System.out.println("Round Results selected.");
                    break;

                case 5:
                    System.out.println("Offers selected.");
                    break;

                case 6:
                    System.out.println("Training selected.");
                    break;

                case 7:
                    System.out.println("Placement Statistics selected.");
                    break;

                case 8:
                    System.out.println(
                            "Exiting JFS-31 Portal."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }
}