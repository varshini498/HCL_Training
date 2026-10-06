package com.hcl.placement.placement;

import java.time.LocalDate;

public class DriveTest {

    public static void main(String[] args) {

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

        drive.displayDrive();
    }
}