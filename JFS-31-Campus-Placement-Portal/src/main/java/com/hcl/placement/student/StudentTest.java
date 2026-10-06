package com.hcl.placement.student;

public class StudentTest {

    public static void main(String[] args) {

        Student student = new Student(
                2001L,
                1001L,
                "23AIML001",
                "AIML",
                3,
                8.5,
                0
        );

        student.displayStudent();
    }
}