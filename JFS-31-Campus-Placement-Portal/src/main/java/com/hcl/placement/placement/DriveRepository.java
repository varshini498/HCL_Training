package com.hcl.placement.placement;

import java.util.ArrayList;
import java.util.List;

public class DriveRepository {

    private List<Drive> drives = new ArrayList<>();

    public void save(Drive drive) {
        drives.add(drive);
    }

    public Drive findByDriveId(long driveId) {

        for (Drive drive : drives) {

            if (drive.getDriveId() == driveId) {
                return drive;
            }
        }

        return null;
    }
}