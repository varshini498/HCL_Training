package com.hcl.placement.student;

public class StudentServiceTest {

    public static void main(String[] args) {

        StudentRepository studentRepository =
                new StudentRepository();

        ResumeRepository resumeRepository =
                new ResumeRepository();

        StudentService studentService =
                new StudentService(
                        studentRepository,
                        resumeRepository
                );

        Student student = new Student(
                2001L,
                1001L,
                "23AIML001",
                "AIML",
                3,
                8.5,
                0
        );

        boolean created =
                studentService.createStudent(student);

        System.out.println(
                "Student created: " + created
        );

        boolean updated =
                studentService.updateStudentProfile(
                        2001L,
                        "23AIML001",
                        "AIML",
                        3,
                        8.8,
                        0
                );

        System.out.println(
                "Profile updated: " + updated
        );

        Student foundStudent =
                studentService.getStudent(2001L);

        if (foundStudent != null) {

            System.out.println("\nUpdated Student Profile:");

            foundStudent.displayStudent();
        }

        boolean resumeUploaded =
                studentService.uploadResume(
                        2001L,
                        "varshini_resume.pdf",
                        "uploads/varshini_resume.pdf"
                );

        System.out.println(
                "\nResume uploaded: " + resumeUploaded
        );

        Resume resume =
                resumeRepository.findByStudentId(2001L);

        if (resume != null) {

            System.out.println("\nResume Details:");

            resume.displayResume();
        }
    }
}