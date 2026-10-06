package com.hcl.placement.auth;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public User findByEmail(String email) {

        if (email == null) {
            return null;
        }

        String searchEmail = email.trim();

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(searchEmail)) {
                return user;
            }
        }

        return null;
    }
}