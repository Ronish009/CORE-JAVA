package mypackage.version.enhancement.java24;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.IntStream;

public class Gathers1 {

    public static String FetchUserProfile(Integer i){
        try{
            TimeUnit.SECONDS.sleep(i);
        }catch (InterruptedException e){}
        return "id : " +i+" , Processed by : "+Thread.currentThread().getName();
    }
    void main(){
        //Gatherers.fold ->  Collapse elements into single unit

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer total = list.stream().reduce(0,(a,b)->a+b);
        System.out.println(total);
        Gatherer<Integer, ?, Integer> g= Gatherers.fold(()->0,Integer::sum);
        Integer gtotal = list.stream().gather(g).findFirst().orElse(0);
        System.out.println(gtotal);
        System.out.println(list.stream().gather(g).toList());
        //Gatherers.scan(seed,op) ->  running total accumulation(like reduce, for every itertaion, it will produce the result)
       List<Integer> transaction =Arrays.asList(1000,-200,300,-400,500);
        AtomicInteger at = new AtomicInteger(0);
        List<Integer> lt = transaction.stream().map(at::addAndGet).toList();
        System.out.println(lt);
        List<Integer> lt1 = transaction.stream().gather(Gatherers.scan(()->0,Integer::sum)).toList();
        System.out.println(lt1);

        //Gathers.windowFixed(size) split the Stream into fixed size
        List<List<Integer>> lt2 = transaction.stream().gather(Gatherers.windowFixed(2)).toList();
        System.out.println(lt2);
        //Gathers.windowSliding(size) Create Overlapping sliding window
        List<List<Integer>> lt3 = transaction.stream().gather(Gatherers.windowSliding(2)).toList();
        System.out.println(lt3);
        //Gathers.mapConcurrent(size) run mapping function concurrently
        List<Integer> userId = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        System.out.println(userId);
       List<CompletableFuture<String>> future = userId.stream().map(id->CompletableFuture.supplyAsync(()->FetchUserProfile(id))).toList();
        System.out.println(future);
        List<String> list5 = future.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(list5);
        List<String> list6 = userId.stream().gather(Gatherers.mapConcurrent(3,Gathers1::FetchUserProfile)).toList();
        System.out.println(list6);


    }
}
