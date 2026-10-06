package com.hcl.placement.placement;

import java.util.ArrayList;
import java.util.List;

public class RoundRepository {

    private List<Round> rounds = new ArrayList<>();

    public void save(Round round) {
        rounds.add(round);
    }

    public Round findByRoundId(long roundId) {

        for (Round round : rounds) {

            if (round.getRoundId() == roundId) {
                return round;
            }
        }

        return null;
    }
}