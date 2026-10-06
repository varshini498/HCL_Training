package com.hcl.placement.placement;

public class RoundResult {

    private long resultId;
    private long roundId;
    private long studentId;
    private boolean passed;

    public RoundResult(long resultId,
                       long roundId,
                       long studentId,
                       boolean passed) {

        this.resultId = resultId;
        this.roundId = roundId;
        this.studentId = studentId;
        this.passed = passed;
    }

    public long getResultId() {
        return resultId;
    }

    public long getRoundId() {
        return roundId;
    }

    public long getStudentId() {
        return studentId;
    }

    public boolean isPassed() {
        return passed;
    }

    public void displayResult() {

        System.out.println("Result ID: " + resultId);
        System.out.println("Round ID: " + roundId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Passed: " + passed);
    }
}