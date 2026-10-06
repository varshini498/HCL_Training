package com.hcl.placement.placement;

import java.time.LocalDate;

public class DriveRepositoryTest {

    public static void main(String[] args) {

        DriveRepository repository = new DriveRepository();

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

        repository.save(drive);

        Drive foundDrive =
                repository.findByDriveId(5001L);

        if (foundDrive != null) {

            System.out.println("Drive found!");

            foundDrive.displayDrive();

        } else {

            System.out.println("Drive not found.");
        }
    }
}