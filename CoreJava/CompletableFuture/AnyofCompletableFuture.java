package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AnyofCompletableFuture {

    public static void SimulateDelay(int num){
        try{
            TimeUnit.SECONDS.sleep(num);
        }catch (InterruptedException e){

        }
    }
    public CompletableFuture<Double> fetchStockDataAPI1(String stockName){
        return CompletableFuture.supplyAsync(()->{
            SimulateDelay(2);
            return 100.09;
        });
    }

    public CompletableFuture<Double> fetchStockDataAPI2(String stockName){
        return CompletableFuture.supplyAsync(()->{
            SimulateDelay(10);
            return 456.78;
        });
    }
    static void main(String[] args) {
     AnyofCompletableFuture v = new AnyofCompletableFuture();
     String s = "Adani Power";
     CompletableFuture<Double> c1 =  v.fetchStockDataAPI1(s);
     CompletableFuture<Double> c2 =  v.fetchStockDataAPI2(s);

     CompletableFuture<Object> c3 = CompletableFuture.anyOf(c1,c2);

     c3.thenAccept(System.out::println).join();

     System.out.println("Main Thread Completed");
    }
}
