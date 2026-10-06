package com.hcl.placement.auth;

public class RoleTest {

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

        if (authService.hasRole(user, UserRole.STUDENT)) {
            System.out.println("Student access allowed.");
        }

        if (authService.hasRole(user, UserRole.PLACEMENT_OFFICER)) {
            System.out.println("Placement Officer access allowed.");
        } else {
            System.out.println("Placement Officer access denied.");
        }
    }
}