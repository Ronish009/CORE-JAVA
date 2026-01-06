package mypackage.version.enhancement.java8;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class CompletableFutureExample {
    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static CompletableFuture<String> fetchUserProfile() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000); // simulate delay
            return "User: Alice";
        });
    }

    static CompletableFuture<List<String>> fetchUserOrders() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1500); // simulate delay
            return List.of("Order1", "Order2", "Order3");
        });
    }

    public static void main(String[] args) {
        CompletableFuture<String> userFuture = fetchUserProfile();
        CompletableFuture<List<String>> ordersFuture = fetchUserOrders();

        CompletableFuture<Void> dashboardFuture = userFuture
                .thenAcceptBoth(ordersFuture, (user, orders) -> {
                    System.out.println("=== Dashboard ===");
                    System.out.println(user);
                    System.out.println("Orders: " + orders);
                })
                .exceptionally(ex -> {
                    System.out.println("Error: " + ex.getMessage());
                    return null;
                });

        dashboardFuture.join(); // wait for completion
    }
}