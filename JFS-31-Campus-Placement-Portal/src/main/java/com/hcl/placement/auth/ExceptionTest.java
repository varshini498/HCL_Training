package com.hcl.placement.auth;

public class ExceptionTest {

    public static void main(String[] args) {

        UserRepository repository = new UserRepository();

        AuthService authService = new AuthService(repository);

        try {

            authService.register(
                    1001L,
                    "Varshini",
                    "varshini@example.com",
                    "1234",
                    UserRole.STUDENT
            );

            authService.login(
                    "varshini@example.com",
                    "wrongpassword"
            );

        } catch (AuthenticationException e) {

            System.out.println("Authentication error: "
                    + e.getMessage());
        }
    }
}