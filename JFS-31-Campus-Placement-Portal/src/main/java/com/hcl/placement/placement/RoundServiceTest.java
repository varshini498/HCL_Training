package com.hcl.placement.placement;

public class RoundServiceTest {

    public static void main(String[] args) {

        RoundRepository roundRepository =
                new RoundRepository();

        RoundResultRepository resultRepository =
                new RoundResultRepository();

        RoundService roundService =
                new RoundService(
                        roundRepository,
                        resultRepository
                );

        Round round = new Round(
                7001L,
                5001L,
                1,
                "Online Assessment"
        );

        boolean roundCreated =
                roundService.createRound(round);

        System.out.println(
                "Round created: " + roundCreated
        );

        boolean resultUploaded =
                roundService.uploadResult(
                        8001L,
                        7001L,
                        2001L,
                        true
                );

        System.out.println(
                "Result uploaded: " + resultUploaded
        );

        RoundResult result =
                resultRepository.findByResultId(8001L);

        if (result != null) {

            System.out.println("\nRound Result:");

            result.displayResult();
        }
    }
}