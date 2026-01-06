package CompletableFuture;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CombineCompletableFuture {

    public CompletableFuture<Emp> getEmpDetails() {
        return CompletableFuture.supplyAsync(()->{
            return EmployeeDatabase.fetchEmployees()
                    .stream()
                    .filter(employee ->employee.employeeId().equals("E1002"))
                    .findAny()
                    .orElse(null);
        });
    }

    public CompletableFuture<Double> getRating(Emp emp) {
        return CompletableFuture.supplyAsync(emp::rating);
    }


    static void main(String[] args) throws ExecutionException, InterruptedException {
    CombineCompletableFuture c =new CombineCompletableFuture();
        CompletableFuture<CompletableFuture<Double>> d = c.getEmpDetails().thenApply(c::getRating);
        System.out.println(d.get().get());
        CompletableFuture<Double> c2 = c.getEmpDetails().thenCompose(c::getRating);

        CompletableFuture<Map<String, Long>> mapCompletableFuture = CompletableFuture.supplyAsync(()->{
           return Objects.requireNonNull(EmployeeDatabase.fetchEmployees()).stream().collect(Collectors.groupingBy(Emp::gender, Collectors.counting()));
        });

        CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.supplyAsync(()->{
            return Objects.requireNonNull(EmployeeDatabase.fetchEmployees()).stream().map(Emp::email).collect(Collectors.toList());
        });


        CompletableFuture<String> k = mapCompletableFuture.thenCombine(listCompletableFuture, (map, list)->{
            return map + " : "+list;
        });
        System.out.println(k.get());


    }

}
