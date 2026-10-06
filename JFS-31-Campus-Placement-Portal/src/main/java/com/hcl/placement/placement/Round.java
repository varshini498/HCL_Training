package com.hcl.placement.placement;

public class Round {

    private long roundId;
    private long driveId;
    private int roundNumber;
    private String roundName;

    public Round(long roundId,
                 long driveId,
                 int roundNumber,
                 String roundName) {

        this.roundId = roundId;
        this.driveId = driveId;
        this.roundNumber = roundNumber;
        this.roundName = roundName;
    }

    public long getRoundId() {
        return roundId;
    }

    public long getDriveId() {
        return driveId;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public String getRoundName() {
        return roundName;
    }

    public void displayRound() {

        System.out.println("Round ID: " + roundId);
        System.out.println("Drive ID: " + driveId);
        System.out.println("Round Number: " + roundNumber);
        System.out.println("Round Name: " + roundName);
    }
}