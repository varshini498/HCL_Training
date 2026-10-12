
package com.hcl.placement.training;

import java.util.ArrayList;
import java.util.List;

public class TrainingRepository {

    private List<Training> registrations = new ArrayList<>();

    public boolean register(Training training) {
        for (Training t : registrations) {
            if (t.getTrainingId() == training.getTrainingId()) {
                return false;
            }
        }

        registrations.add(training);
        return true;
    }

    public void displayRegistrations() {
        if (registrations.isEmpty()) {
            System.out.println("No training registrations found.");
            return;
        }

        for (Training training : registrations) {
            training.display();
        }
    }
    public int getTrainingCount() {
    return registrations.size();
}
}
