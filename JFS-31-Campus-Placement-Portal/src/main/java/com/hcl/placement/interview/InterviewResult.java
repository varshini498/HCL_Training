
package com.hcl.placement.interview;

public class InterviewResult {

    private int resultId;
    private int applicationId;
    private String roundName;
    private String result;

    public InterviewResult(int resultId, int applicationId,
                           String roundName, String result) {
        this.resultId = resultId;
        this.applicationId = applicationId;
        this.roundName = roundName;
        this.result = result;
    }

    public int getResultId() {
        return resultId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public String getResult() {
        return result;
    }

    public void display() {
        System.out.println("\n--- Interview Result ---");
        System.out.println("Result ID: " + resultId);
        System.out.println("Application ID: " + applicationId);
        System.out.println("Round: " + roundName);
        System.out.println("Result: " + result);
    }
}
