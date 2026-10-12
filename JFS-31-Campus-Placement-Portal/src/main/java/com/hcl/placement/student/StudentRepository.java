
package com.hcl.placement.student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()
                    || s.getRegisterNumber().equalsIgnoreCase(
                            student.getRegisterNumber())) {
                return false;
            }
        }

        students.add(student);
        return true;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students) {
            student.display();
        }
    }
    public Student findStudent(int id) {
    for (Student student : students) {
        if (student.getId() == id) {
            return student;
        }
    }
    return null;
}
public int getStudentCount() {
    return students.size();
}
}
