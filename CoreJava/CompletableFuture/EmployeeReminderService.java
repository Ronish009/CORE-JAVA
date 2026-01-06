package CompletableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class EmployeeReminderService {

   public CompletableFuture<Void> sendReminderEmployee() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> c= CompletableFuture.supplyAsync(()->{
            System.out.println("Thread : "+Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployees();
        }).thenApply((employee)-> {
            return employee.stream().filter(Emp::newJoiner).collect(Collectors.toList());
        }).thenApply((employee) -> {
            return employee.stream().filter(Emp::learningPending).collect(Collectors.toList());
        }).thenApply((employee)->{
            return employee.stream().map(Emp::email).collect(Collectors.toList());
        }).thenAccept((emails)->{
            emails.forEach(EmployeeReminderService::sendEmail);
        });
    // c.get();
     return c;
    }

   /* public Void sendReminderEmployee() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> c= CompletableFuture.runAsync(()->{
            System.out.println("Thread : "+Thread.currentThread().getName());
            EmployeeDatabase.fetchEmployees().stream().forEach(System.out::println);
        });
        c.get();
        return null;
    }*/

    public static void sendEmail(String email){
        System.out.println("Sending Training reminder to the Email : "+email);
    }
    public static void main(String...args) throws ExecutionException, InterruptedException {
        EmployeeReminderService e1 = new  EmployeeReminderService();
/*       List<Emp> detail =  e1.sendReminderEmployee();
        System.out.println(detail);*/
        e1.sendReminderEmployee().get();
    }
}
