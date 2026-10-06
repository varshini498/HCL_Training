package com.hcl.placement.auth;

public class UserTest {

    public static void main(String[] args) {

        User student = new User(
                1001L,
                "Varshini",
                "varshini@example.com",
                "1234",
                UserRole.STUDENT
        );

        student.displayUser();
    }
}