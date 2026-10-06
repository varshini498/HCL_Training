package com.hcl.placement.student;

import java.util.ArrayList;
import java.util.List;

public class ResumeRepository {

    private List<Resume> resumes = new ArrayList<>();

    public void save(Resume resume) {
        resumes.add(resume);
    }

    public Resume findByStudentId(long studentId) {

        for (Resume resume : resumes) {

            if (resume.getStudentId() == studentId) {
                return resume;
            }
        }

        return null;
    }
}