package com.hcl.placement.student;

public class StudentService {

    private StudentRepository studentRepository;
    private ResumeRepository resumeRepository;
    public StudentService(
        StudentRepository studentRepository,
        ResumeRepository resumeRepository) {

    this.studentRepository = studentRepository;
    this.resumeRepository = resumeRepository;
}

    public boolean createStudent(Student student) {

        if (student == null) {
            return false;
        }

        Student existingStudent =
                studentRepository.findByStudentId(student.getStudentId());

        if (existingStudent != null) {
            return false;
        }

        studentRepository.save(student);

        return true;
    }

    public Student getStudent(long studentId) {

        return studentRepository.findByStudentId(studentId);
    }

    public boolean updateStudentProfile(
            long studentId,
            String registerNumber,
            String branch,
            int year,
            double cgpa,
            int backlogs) {

        Student student =
                studentRepository.findByStudentId(studentId);

        if (student == null) {
            return false;
        }

        student.updateProfile(
                registerNumber,
                branch,
                year,
                cgpa,
                backlogs
        );

        return true;
    }
    public boolean uploadResume(
        long studentId,
        String fileName,
        String filePath) {

    Student student =
            studentRepository.findByStudentId(studentId);

    if (student == null) {
        return false;
    }

    Resume resume = new Resume(
            System.currentTimeMillis(),
            studentId,
            fileName,
            filePath
    );

    resumeRepository.save(resume);

    return true;
}
}