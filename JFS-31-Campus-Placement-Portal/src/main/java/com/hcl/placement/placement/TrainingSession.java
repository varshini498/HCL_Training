package com.hcl.placement.placement;

import java.time.LocalDate;

public class TrainingSession {

    private long sessionId;
    private String sessionName;
    private String trainerName;
    private LocalDate sessionDate;
    private int maxParticipants;

    public TrainingSession(long sessionId,
                           String sessionName,
                           String trainerName,
                           LocalDate sessionDate,
                           int maxParticipants) {

        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.trainerName = trainerName;
        this.sessionDate = sessionDate;
        this.maxParticipants = maxParticipants;
    }

    public long getSessionId() {
        return sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void displaySession() {

        System.out.println("Session ID: " + sessionId);
        System.out.println("Session Name: " + sessionName);
        System.out.println("Trainer: " + trainerName);
        System.out.println("Session Date: " + sessionDate);
        System.out.println("Maximum Participants: "
                + maxParticipants);
    }
}