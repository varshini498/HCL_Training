
package com.hcl.placement;

import java.util.Scanner;

import com.hcl.placement.student.Student;
import com.hcl.placement.student.StudentRepository;
import com.hcl.placement.company.Company;
import com.hcl.placement.company.CompanyRepository;
import com.hcl.placement.drive.Drive;
import com.hcl.placement.drive.DriveRepository;
import com.hcl.placement.application.Application;
import com.hcl.placement.application.ApplicationRepository;
import com.hcl.placement.interview.InterviewResult;
import com.hcl.placement.interview.InterviewRepository;
import com.hcl.placement.offer.Offer;
import com.hcl.placement.offer.OfferRepository;
import com.hcl.placement.training.Training;
import com.hcl.placement.training.TrainingRepository;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentRepository studentRepository = new StudentRepository();
        CompanyRepository companyRepository = new CompanyRepository();
        DriveRepository driveRepository = new DriveRepository();
ApplicationRepository applicationRepository =
        new ApplicationRepository();
        InterviewRepository interviewRepository = new InterviewRepository();
        OfferRepository offerRepository = new OfferRepository();
        TrainingRepository trainingRepository = new TrainingRepository();
        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println(" CAMPUS PLACEMENT & INTERNSHIP PORTAL");
            System.out.println("======================================");
            System.out.println("1. Student Registration");
            System.out.println("2. View All Students");
            System.out.println("3. Company Registration");
            System.out.println("4. View All Companies");
            System.out.println("5. Create Placement Drive");
            System.out.println("6. View Placement Drives");
            System.out.println("7. Check Eligibility");
            System.out.println("8. Apply for a Drive");
            System.out.println("9. Interview Results");
            System.out.println("10. Offer Management");
            System.out.println("11. Training Registration");
            System.out.println("12. Placement Analytics");
            System.out.println("13. View Applications");
            System.out.println("14. View Interview Results");
            System.out.println("15. View Offers");
            System.out.println("16. View Training Registrations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: {
                    System.out.println("\n--- Student Registration ---");

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Register Number: ");
                    String regNo = scanner.nextLine();

                    System.out.print("Enter Branch: ");
                    String branch = scanner.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = scanner.nextDouble();

                    System.out.print("Enter Backlogs: ");
                    int backlogs = scanner.nextInt();
                    scanner.nextLine();

                    if (id <= 0 || name.trim().isEmpty()
                            || regNo.trim().isEmpty()
                            || branch.trim().isEmpty()
                            || cgpa < 0 || cgpa > 10
                            || backlogs < 0) {
                        System.out.println("Invalid student details.");
                        break;
                    }

                    Student student = new Student(
                            id, name, regNo, branch, cgpa, backlogs
                    );

                    if (studentRepository.addStudent(student)) {
                        System.out.println(
                                "Student registered successfully!"
                        );
                        student.display();
                    } else {
                        System.out.println(
                                "Duplicate Student ID or Register Number!"
                        );
                    }
                    break;
                }

                case 2:
                    System.out.println("\n--- Registered Students ---");
                    studentRepository.displayStudents();
                    break;

                case 3: {
                    System.out.println("\n--- Company Registration ---");

                    System.out.print("Enter Company ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Company Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Industry: ");
                    String industry = scanner.nextLine();

                    if (id <= 0 || name.trim().isEmpty()
                            || industry.trim().isEmpty()) {
                        System.out.println("Invalid company details.");
                        break;
                    }

                    Company company = new Company(id, name, industry);

                    if (companyRepository.addCompany(company)) {
                        System.out.println(
                                "Company registered successfully!"
                        );
                        company.display();
                    } else {
                        System.out.println("Company ID already exists!");
                    }
                    break;
                }

                case 4:
                    System.out.println("\n--- Registered Companies ---");
                    companyRepository.displayCompanies();
                    break;

                case 5: {
                    System.out.println("\n--- Create Placement Drive ---");

                    System.out.print("Enter Drive ID: ");
                    int driveId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Company ID: ");
                    int companyId = scanner.nextInt();
                    scanner.nextLine();

                    Company company =
                            companyRepository.findCompany(companyId);

                    if (company == null) {
                        System.out.println(
                                "Company not found. Register it first."
                        );
                        break;
                    }

                    System.out.print("Enter Job Role: ");
                    String role = scanner.nextLine();

                    System.out.print("Enter Minimum CGPA: ");
                    double minCgpa = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter Eligible Branch: ");
                    String branch = scanner.nextLine();

                    System.out.print("Enter Maximum Backlogs: ");
                    int maxBacklogs = scanner.nextInt();
                    scanner.nextLine();

                    if (driveId <= 0 || role.trim().isEmpty()
                            || minCgpa < 0 || minCgpa > 10
                            || branch.trim().isEmpty()
                            || maxBacklogs < 0) {
                        System.out.println("Invalid drive details.");
                        break;
                    }

                    Drive drive = new Drive(
                            driveId, companyId, role, minCgpa,
                            branch, maxBacklogs
                    );

                    if (driveRepository.addDrive(drive)) {
                        System.out.println(
                                "Placement drive created successfully!"
                        );
                        drive.display();
                    } else {
                        System.out.println("Drive ID already exists!");
                    }
                    break;
                }

                case 6:
                    System.out.println("\n--- Available Placement Drives ---");
                    driveRepository.displayDrives();
                    break;

                
case 7: {
    System.out.println("\n--- Check Student Eligibility ---");

    System.out.print("Enter Student ID: ");
    int studentId = scanner.nextInt();

    System.out.print("Enter Drive ID: ");
    int driveId = scanner.nextInt();
    scanner.nextLine();

    Student student = studentRepository.findStudent(studentId);
    Drive drive = driveRepository.findDrive(driveId);

    if (student == null) {
        System.out.println("Student not found!");
    } else if (drive == null) {
        System.out.println("Placement drive not found!");
    } else if (drive.checkEligibility(
            student.getBranch(),
            student.getCgpa(),
            student.getBacklogs())) {
        System.out.println(
                "Congratulations! Student is eligible for this drive."
        );
    } else {
        System.out.println(
                "Student is not eligible for this drive."
        );
    }

    break;
}


                
case 8: {
    System.out.println("\n--- Apply for a Placement Drive ---");

    System.out.print("Enter Application ID: ");
    int applicationId = scanner.nextInt();

    System.out.print("Enter Student ID: ");
    int studentId = scanner.nextInt();

    System.out.print("Enter Drive ID: ");
    int driveId = scanner.nextInt();
    scanner.nextLine();

    Student student = studentRepository.findStudent(studentId);
    Drive drive = driveRepository.findDrive(driveId);

    if (student == null) {
        System.out.println("Student not found!");
        break;
    }

    if (drive == null) {
        System.out.println("Placement drive not found!");
        break;
    }

    if (!drive.checkEligibility(
            student.getBranch(),
            student.getCgpa(),
            student.getBacklogs())) {
        System.out.println(
                "Application rejected: Student is not eligible."
        );
        break;
    }

    Application application = new Application(
            applicationId, studentId, driveId);

    if (applicationRepository.addApplication(application)) {
        System.out.println("Application submitted successfully!");
        application.display();
    } else {
        System.out.println(
                "Duplicate Application ID or student already applied."
        );
    }

    break;
}


                

case 9: {
    System.out.println("\n--- Record Interview Result ---");

    System.out.print("Enter Result ID: ");
    int resultId = scanner.nextInt();

    System.out.print("Enter Application ID: ");
    int applicationId = scanner.nextInt();
    scanner.nextLine();

    // Check whether the application exists
    Application application =
            applicationRepository.findApplication(applicationId);

    if (application == null) {
        System.out.println("Application not found!");
        break;
    }

    System.out.print("Enter Round Name (Aptitude/Technical/HR): ");
    String roundName = scanner.nextLine().trim();

    System.out.print("Enter Result (PASS/FAIL): ");
    String result = scanner.nextLine().trim().toUpperCase();

    if (resultId <= 0 || roundName.isEmpty()
            || (!result.equals("PASS") && !result.equals("FAIL"))) {
        System.out.println("Invalid interview result details.");
        break;
    }

    InterviewResult interviewResult = new InterviewResult(
            resultId, applicationId, roundName, result
    );

    if (interviewRepository.addResult(interviewResult)) {
        System.out.println("Interview result recorded successfully!");
        interviewResult.display();
    } else {
        System.out.println("Result ID already exists!");
    }

    break;
}


                
case 10: {
    System.out.println("\n--- Create Job Offer ---");

    System.out.print("Enter Offer ID: ");
    int offerId = scanner.nextInt();

    System.out.print("Enter Application ID: ");
    int applicationId = scanner.nextInt();
    scanner.nextLine();
Application application =
        applicationRepository.findApplication(applicationId);

if (application == null) {
    System.out.println("Application not found.");
    break;
}

if (!interviewRepository.hasPassedResult(applicationId)) {
    System.out.println(
        "Offer cannot be created. Student has no PASS interview result."
    );
    break;
}
    System.out.print("Enter Company Name: ");
    String companyName = scanner.nextLine();

    System.out.print("Enter Annual Salary (LPA): ");
    double salary = scanner.nextDouble();
    scanner.nextLine();

    if (offerId <= 0 || applicationId <= 0
            || companyName.trim().isEmpty() || salary <= 0) {
        System.out.println("Invalid offer details.");
        break;
    }

    Offer offer = new Offer(
        offerId, applicationId, companyName, salary
    );

    if (offerRepository.addOffer(offer)) {
        System.out.println("Offer created successfully!");
        offer.display();
    } else {
        System.out.println("Duplicate Offer ID or Application ID!");
    }

    break;
}


                
case 11: {
    System.out.println("\n--- Training Registration ---");

    System.out.print("Enter Training ID: ");
    int trainingId = scanner.nextInt();

    System.out.print("Enter Student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine();

    Student student = studentRepository.findStudent(studentId);

    if (student == null) {
        System.out.println("Student not found. Register the student first.");
        break;
    }

    System.out.println("Available Sessions:");
    System.out.println("1. Aptitude Training");
    System.out.println("2. Technical Interview Preparation");
    System.out.println("3. Communication Skills");

    System.out.print("Choose a session: ");
    int sessionChoice = scanner.nextInt();
    scanner.nextLine();

    String sessionName;

    switch (sessionChoice) {
        case 1:
            sessionName = "Aptitude Training";
            break;
        case 2:
            sessionName = "Technical Interview Preparation";
            break;
        case 3:
            sessionName = "Communication Skills";
            break;
        default:
            System.out.println("Invalid session choice.");
            break;
    }

    if (sessionChoice < 1 || sessionChoice > 3) {
        break;
    }

    sessionName = sessionChoice == 1
            ? "Aptitude Training"
            : sessionChoice == 2
                ? "Technical Interview Preparation"
                : "Communication Skills";

    Training training = new Training(
            trainingId, studentId, sessionName
    );

    if (trainingRepository.register(training)) {
        System.out.println("Training registration successful!");
        training.display();
    } else {
        System.out.println("Training ID already exists!");
    }

    break;
}


                case 12:
    System.out.println("\n===== PLACEMENT ANALYTICS =====");
    System.out.println("Total Students: "
            + studentRepository.getStudentCount());
    System.out.println("Total Companies: "
            + companyRepository.getCompanyCount());
    System.out.println("Total Placement Drives: "
            + driveRepository.getDriveCount());
    System.out.println("Total Applications: "
            + applicationRepository.getApplicationCount());
    System.out.println("Total Interview Results: "
            + interviewRepository.getInterviewCount());
    System.out.println("Total Offers: "
            + offerRepository.getOfferCount());
    System.out.println("Total Training Registrations: "
            + trainingRepository.getTrainingCount());
    break;

                case 13:
    System.out.println("\n--- Submitted Applications ---");
    applicationRepository.displayApplications();
    break;

                case 14:
    System.out.println("\n--- Interview Results ---");
    interviewRepository.displayResults();
    break;

                case 15:
    System.out.println("\n--- All Job Offers ---");
    offerRepository.displayOffers();
    break;

                case 16:
    System.out.println("\n--- Training Registrations ---");
    trainingRepository.displayRegistrations();
    break;
                case 0:
                    System.out.println("Thank you for using the portal!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
