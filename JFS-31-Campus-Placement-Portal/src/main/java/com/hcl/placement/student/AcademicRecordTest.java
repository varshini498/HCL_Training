package com.hcl.placement.student;

public class AcademicRecordTest {

    public static void main(String[] args) {

        AcademicRecord record = new AcademicRecord(
                3001L,
                2001L,
                91.5,
                89.0,
                8.5,
                0
        );

        record.displayAcademicRecord();
    }
}