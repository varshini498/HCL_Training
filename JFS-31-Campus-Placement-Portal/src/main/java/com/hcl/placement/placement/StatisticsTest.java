package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {

    public static void main(String[] args) {

        List<Student> students =
                new ArrayList<>();

        Student student1 = new Student(
                2001L,
                1001L,
                "23AIML001",
                "AIML",
                3,
                8.8,
                0
        );

        Student student2 = new Student(
                2002L,
                1002L,
                "23AIML002",
                "AIML",
                3,
                8.2,
                0
        );

        Student student3 = new Student(
                2003L,
                1003L,
                "23AIML003",
                "AIML",
                3,
                7.9,
                1
        );

        students.add(student1);
        students.add(student2);
        students.add(student3);

        OfferRepository offerRepository =
                new OfferRepository();

        Offer offer = new Offer(
                9001L,
                2001L,
                4001L,
                5001L,
                "REGULAR",
                6.0
        );

        offerRepository.save(offer);

        StatisticsService statisticsService =
                new StatisticsService();

        double percentage =
                statisticsService
                        .calculatePlacementPercentage(
                                students,
                                offerRepository,
                                "AIML"
                        );

        System.out.println(
                "AIML Placement Percentage: "
                        + percentage + "%"
        );
    }
}