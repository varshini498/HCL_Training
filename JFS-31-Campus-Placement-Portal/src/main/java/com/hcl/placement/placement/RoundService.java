package com.hcl.placement.placement;

public class RoundService {

    private RoundRepository roundRepository;
    private RoundResultRepository resultRepository;

    public RoundService(
            RoundRepository roundRepository,
            RoundResultRepository resultRepository) {

        this.roundRepository = roundRepository;
        this.resultRepository = resultRepository;
    }

    public boolean createRound(Round round) {

        if (round == null) {
            return false;
        }

        if (roundRepository.findByRoundId(
                round.getRoundId()) != null) {

            return false;
        }

        roundRepository.save(round);

        return true;
    }

    public boolean uploadResult(
            long resultId,
            long roundId,
            long studentId,
            boolean passed) {

        Round round =
                roundRepository.findByRoundId(roundId);

        if (round == null) {
            return false;
        }

        RoundResult result =
                new RoundResult(
                        resultId,
                        roundId,
                        studentId,
                        passed
                );

        resultRepository.save(result);

        return true;
    }
}