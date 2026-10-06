package com.hcl.placement.placement;

import java.util.ArrayList;
import java.util.List;

public class TrainingRegistrationRepository {

    private List<TrainingRegistration> registrations =
            new ArrayList<>();

    public void save(TrainingRegistration registration) {
        registrations.add(registration);
    }

    public TrainingRegistration findByRegistrationId(
            long registrationId) {

        for (TrainingRegistration registration
                : registrations) {

            if (registration.getRegistrationId()
                    == registrationId) {

                return registration;
            }
        }

        return null;
    }

    public TrainingRegistration findByStudentAndSession(
            long studentId,
            long sessionId) {

        for (TrainingRegistration registration
                : registrations) {

            if (registration.getStudentId() == studentId
                    && registration.getSessionId()
                    == sessionId) {

                return registration;
            }
        }

        return null;
    }
}