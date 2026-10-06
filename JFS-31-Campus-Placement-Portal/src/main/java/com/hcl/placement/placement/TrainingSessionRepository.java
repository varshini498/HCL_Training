package com.hcl.placement.placement;

import java.util.ArrayList;
import java.util.List;

public class TrainingSessionRepository {

    private List<TrainingSession> sessions =
            new ArrayList<>();

    public void save(TrainingSession session) {
        sessions.add(session);
    }

    public TrainingSession findBySessionId(long sessionId) {

        for (TrainingSession session : sessions) {

            if (session.getSessionId() == sessionId) {
                return session;
            }
        }

        return null;
    }
}