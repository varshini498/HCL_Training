package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

import java.util.List;

public class StatisticsService {

    public double calculatePlacementPercentage(
            List<Student> students,
            OfferRepository offerRepository,
            String branch) {

        if (students == null
                || students.isEmpty()
                || branch == null) {

            return 0.0;
        }

        int totalStudents = 0;
        int placedStudents = 0;

        for (Student student : students) {

            if (student.getBranch()
                    .equalsIgnoreCase(branch)) {

                totalStudents++;

                Offer offer =
                        offerRepository.findByStudentId(
                                student.getStudentId()
                        );

                if (offer != null) {
                    placedStudents++;
                }
            }
        }

        if (totalStudents == 0) {
            return 0.0;
        }

        return ((double) placedStudents
                / totalStudents) * 100;
    }
}