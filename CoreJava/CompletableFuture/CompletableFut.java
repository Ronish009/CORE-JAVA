package CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

class CompletableFut{
    private static void delay(int time){
       try{
           TimeUnit.MINUTES.sleep(time);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
    void main() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<List<String>> future = executor.submit(()->{
            delay(1);
            return Arrays.asList("a","b","c","d","e","f","g");
        });

        List<String> list = future.get();
        System.out.println(list);

    }
}
