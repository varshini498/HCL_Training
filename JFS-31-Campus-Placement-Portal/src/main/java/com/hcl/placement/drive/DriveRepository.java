
package com.hcl.placement.drive;

import java.util.ArrayList;
import java.util.List;

public class DriveRepository {
    private List<Drive> drives = new ArrayList<>();

    public boolean addDrive(Drive drive) {
        for (Drive d : drives) {
            if (d.getDriveId() == drive.getDriveId()) {
                return false;
            }
        }

        drives.add(drive);
        return true;
    }

    public Drive findDrive(int driveId) {
        for (Drive drive : drives) {
            if (drive.getDriveId() == driveId) {
                return drive;
            }
        }
        return null;
    }

    public void displayDrives() {
        if (drives.isEmpty()) {
            System.out.println("No placement drives available.");
            return;
        }

        for (Drive drive : drives) {
            drive.display();
        }
    }
    public int getDriveCount() {
    return drives.size();
}
}
