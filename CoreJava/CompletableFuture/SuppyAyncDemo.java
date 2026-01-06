package CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SuppyAyncDemo {

    public List<Employee> createEmployee(File file) throws ExecutionException, InterruptedException {
        ObjectMapper ob = new ObjectMapper();
        CompletableFuture<List<Employee>> returnFuture = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println(Thread.currentThread().getName());
                List<Employee> list26 = ob.readValue(file, new TypeReference<List<Employee>>() {});
               return list26;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return returnFuture.get();
    }
    static void main(String[] args) throws ExecutionException, InterruptedException {
        SuppyAyncDemo d = new SuppyAyncDemo();
        List<Employee> lk = d.createEmployee(new File("emp.json"));
        lk.forEach(System.out::println);
    }
}
