
package com.hcl.placement.interview;

import java.util.ArrayList;
import java.util.List;

public class InterviewRepository {

    private List<InterviewResult> results = new ArrayList<>();

    public boolean addResult(InterviewResult result) {
        for (InterviewResult r : results) {
            if (r.getResultId() == result.getResultId()) {
                return false;
            }
        }

        results.add(result);
        return true;
    }

    public void displayResults() {
        if (results.isEmpty()) {
            System.out.println("No interview results available.");
            return;
        }

        for (InterviewResult result : results) {
            result.display();
        }
    }
    public boolean hasPassedResult(int applicationId) {
    for (InterviewResult result : results) {
        if (result.getApplicationId() == applicationId
                && result.getResult().equalsIgnoreCase("PASS")) {
            return true;
        }
    }
    return false;
}
public int getInterviewCount() {
    return results.size();
}
}
