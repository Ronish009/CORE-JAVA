package model;

public record Employee(
        String employeeId,
        String firstname,
        String lastname,
        String email,
        String gender,
        boolean newJoiner,
        boolean learningPending,
        double salary,
        double rating
) {}