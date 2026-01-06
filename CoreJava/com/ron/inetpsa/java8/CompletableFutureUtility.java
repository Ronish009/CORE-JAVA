package com.ron.inetpsa.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class CompletableFutureUtility {
    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            Future<String> userFuture = executor.submit(() -> {
                sleep(1000);
                return "User: Rony";
            });

            Future<String> orderFuture = executor.submit(() -> {
                sleep(1500);
                return "Order: Laptop";
            });

            // Blocking calls
            String user = userFuture.get();   // waits until done
            String order = orderFuture.get(); // waits until done

            System.out.println("Result: " + user + ", " + order);

            executor.shutdown();

            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "ronish")
                    .thenApply(name -> name.toUpperCase());

            System.out.println("Processed name: " + future.get());
            System.out.println("Normal Executer Code Completed");
            ExecutorService executorComp = Executors.newFixedThreadPool(3);
            CompletableFuture<String> userFuture1 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Welcome Rony";
            }, executorComp);
            System.out.println(userFuture1.get());

            CompletableFuture<String> orderFuture1 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Laptop";
            }, executorComp);
            System.out.println(orderFuture1.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
