package com.hcl.placement.auth;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(long userId, String name, String email,
                            String password, UserRole role) {

        if (name == null || name.isBlank()
                || email == null || email.isBlank()
                || password == null || password.isBlank()
                || role == null) {

            throw new AuthenticationException(
                    "Registration details cannot be empty."
            );
        }

        User existingUser = userRepository.findByEmail(email);

        if (existingUser != null) {
            throw new AuthenticationException(
                    "Email is already registered."
            );
        }

        User user = new User(
                userId,
                name,
                email,
                password,
                role
        );

        userRepository.save(user);

        return true;
    }

    public User login(String email, String password) {

        if (email == null || email.isBlank()
                || password == null || password.isBlank()) {

            throw new AuthenticationException(
                    "Email and password are required."
            );
        }

        User user = userRepository.findByEmail(email);

        if (user != null && user.checkPassword(password)) {
            return user;
        }

        throw new AuthenticationException(
                "Invalid email or password."
        );
    }

    public boolean hasRole(User user, UserRole requiredRole) {

        if (user == null || requiredRole == null) {
            return false;
        }

        return user.getRole() == requiredRole;
    }
}