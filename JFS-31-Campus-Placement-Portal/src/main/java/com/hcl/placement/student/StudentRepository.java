package com.hcl.placement.student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public Student findByStudentId(long studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    public Student findByRegisterNumber(String registerNumber) {

        if (registerNumber == null) {
            return null;
        }

        String searchRegisterNumber = registerNumber.trim();

        for (Student student : students) {

            if (student.getRegisterNumber()
                    .equalsIgnoreCase(searchRegisterNumber)) {

                return student;
            }
        }

        return null;
    }
}