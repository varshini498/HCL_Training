package com.hcl.placement.auth;

public class AuthTest {

    public static void main(String[] args) {

        UserRepository repository = new UserRepository();

        AuthService authService = new AuthService(repository);

        boolean firstRegistration = authService.register(
                1001L,
                "Varshini",
                "varshini@example.com",
                "1234",
                UserRole.STUDENT
        );

        System.out.println(
                "First registration: " + firstRegistration
        );

        boolean duplicateRegistration = authService.register(
                1002L,
                "Another User",
                "varshini@example.com",
                "5678",
                UserRole.STUDENT
        );

        System.out.println(
                "Duplicate registration: " + duplicateRegistration
        );

        User user = authService.login(
                "varshini@example.com",
                "1234"
        );

        if (user != null) {
            System.out.println("Login successful!");
            System.out.println("Welcome, " + user.getName());
            System.out.println("Role: " + user.getRole());
        } else {
            System.out.println("Invalid email or password.");
        }
    }
}