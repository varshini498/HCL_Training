package com.hcl.placement.student;

public class Resume {

    private long resumeId;
    private long studentId;
    private String fileName;
    private String filePath;

    public Resume(long resumeId, long studentId,
                  String fileName, String filePath) {

        this.resumeId = resumeId;
        this.studentId = studentId;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public long getResumeId() {
        return resumeId;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void displayResume() {

        System.out.println("Resume ID: " + resumeId);
        System.out.println("Student ID: " + studentId);
        System.out.println("File Name: " + fileName);
        System.out.println("File Path: " + filePath);
    }
}