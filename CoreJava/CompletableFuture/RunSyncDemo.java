package CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


record Employee(
        int id,
        String name,
        String department,
        int salary
) {}
public class RunSyncDemo {

    public Void createEmployee(File file) throws ExecutionException, InterruptedException {
        ObjectMapper ob = new ObjectMapper();
        CompletableFuture<Void> voidFuture = CompletableFuture.runAsync(()->{
            try {
                System.out.println(Thread.currentThread().getName());
                List<Employee> list25 = ob.readValue(file, new TypeReference<List<Employee>>() {});
                list25.stream().forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
         return voidFuture.get();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    RunSyncDemo demo = new RunSyncDemo();
    demo.createEmployee(new File("emp.json"));
    }
}
