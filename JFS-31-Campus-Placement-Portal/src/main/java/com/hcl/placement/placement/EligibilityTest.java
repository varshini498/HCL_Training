package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

import java.time.LocalDate;

public class EligibilityTest {

    public static void main(String[] args) {

        Student student = new Student(
                2001L,
                1001L,
                "23AIML001",
                "AIML",
                3,
                8.8,
                0
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

        EligibilityService eligibilityService =
                new EligibilityService();

        boolean eligible =
                eligibilityService.isEligible(
                        student,
                        drive
                );

        if (eligible) {
            System.out.println("Student is eligible for the drive.");
        } else {
            System.out.println("Student is not eligible for the drive.");
        }
    }
}