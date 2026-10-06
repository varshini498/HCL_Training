package com.hcl.placement.placement;

import java.util.ArrayList;
import java.util.List;

public class RoundResultRepository {

    private List<RoundResult> results = new ArrayList<>();

    public void save(RoundResult result) {
        results.add(result);
    }

    public RoundResult findByResultId(long resultId) {

        for (RoundResult result : results) {

            if (result.getResultId() == resultId) {
                return result;
            }
        }

        return null;
    }
}