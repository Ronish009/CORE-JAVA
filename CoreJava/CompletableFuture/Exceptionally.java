package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exceptionally {
    public static void gracefully(String apiName){
        throw new RuntimeException(apiName + "Service temporary Closed !!!");
    }
    static void main(String[] args) throws ExecutionException, InterruptedException {
      /*  CompletableFuture.supplyAsync(()->{
            gracefully("");
            return "welcome"
        }).thenApply(a->{
            return "Proceed Result";
        }).thenApply(res->{
            return "Result after further processing";
        }).thenAccept(res->{

        });*/

        CompletableFuture<String> c5 = CompletableFuture.supplyAsync(()->{
            gracefully("");
            return "Welcome Ronish !!!";
        })/*.exceptionally(exc->{
            System.out.println("Error is in First Completable Future");
            return "Service is down fro first";
        })*/;

        CompletableFuture<String> c6 = CompletableFuture.supplyAsync(()->{
            return "Welcome Preeti !!!";
        });
        CompletableFuture<String> com = c5.thenCombine(c6, (r,s)->{
            return r + " : "+s;
        }).handle((res, exe)->{
              if(exe!=null){
                  System.out.println("Error Occurred during data processing"+exe);
              }
              return res;
        });
        System.out.println(com.get());

    }
}
