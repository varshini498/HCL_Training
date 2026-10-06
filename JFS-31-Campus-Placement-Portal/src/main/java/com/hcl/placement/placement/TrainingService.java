package com.hcl.placement.placement;

public class TrainingService {

    private TrainingSessionRepository sessionRepository;
    private TrainingRegistrationRepository registrationRepository;

    public TrainingService(
            TrainingSessionRepository sessionRepository,
            TrainingRegistrationRepository registrationRepository) {

        this.sessionRepository = sessionRepository;
        this.registrationRepository = registrationRepository;
    }

    public boolean createSession(
            TrainingSession session) {

        if (session == null) {
            return false;
        }

        if (sessionRepository.findBySessionId(
                session.getSessionId()) != null) {

            return false;
        }

        sessionRepository.save(session);

        return true;
    }

    public boolean registerStudent(
            long registrationId,
            long studentId,
            long sessionId) {

        TrainingSession session =
                sessionRepository.findBySessionId(sessionId);

        if (session == null) {
            return false;
        }

        TrainingRegistration existingRegistration =
                registrationRepository
                        .findByStudentAndSession(
                                studentId,
                                sessionId
                        );

        if (existingRegistration != null) {
            return false;
        }

        TrainingRegistration registration =
                new TrainingRegistration(
                        registrationId,
                        sessionId,
                        studentId
                );

        registrationRepository.save(registration);

        return true;
    }
}