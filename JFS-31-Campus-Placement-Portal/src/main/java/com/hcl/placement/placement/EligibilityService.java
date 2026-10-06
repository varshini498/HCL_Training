package com.hcl.placement.placement;

import com.hcl.placement.student.Student;

public class EligibilityService {

    public boolean isEligible(Student student, Drive drive) {

        if (student == null || drive == null) {
            return false;
        }

        boolean cgpaEligible =
                student.getCgpa() >= drive.getMinimumCgpa();

        boolean backlogEligible =
                student.getBacklogs() <= drive.getMaximumBacklogs();

        boolean branchEligible =
                student.getBranch()
                        .equalsIgnoreCase(drive.getEligibleBranch());

        boolean yearEligible =
                student.getYear() == drive.getEligibleYear();

        return cgpaEligible
                && backlogEligible
                && branchEligible
                && yearEligible;
    }
}