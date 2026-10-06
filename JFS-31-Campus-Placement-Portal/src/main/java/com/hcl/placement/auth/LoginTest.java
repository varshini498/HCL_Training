package com.hcl.placement.auth;

public class LoginTest {

    public static void main(String[] args) {

        UserRepository repository = new UserRepository();

        AuthService authService = new AuthService(repository);

        authService.register(
                1001L,
                "Varshini",
                "varshini@example.com",
                "1234",
                UserRole.STUDENT
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