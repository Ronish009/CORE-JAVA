package CompletableFuture;

public record Emp(
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