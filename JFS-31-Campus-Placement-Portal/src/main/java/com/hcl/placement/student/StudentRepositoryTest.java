package com.hcl.placement.student;

public class StudentRepositoryTest {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();

        Student student = new Student(
                2001L,
                1001L,
                "23AIML001",
                "AIML",
                3,
                8.5,
                0
        );

        repository.save(student);

        Student foundStudent =
                repository.findByStudentId(2001L);

        if (foundStudent != null) {
            System.out.println("Student found!");
            foundStudent.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }
}