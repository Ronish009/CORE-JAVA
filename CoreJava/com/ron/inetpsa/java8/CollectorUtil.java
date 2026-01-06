package com.ron.inetpsa.java8;

/***
 *         private final Supplier<A> supplier;
 *         private final BiConsumer<A, T> accumulator;
 *         private final BinaryOperator<A> combiner;
 *         private final Function<A, R> finisher;
 *         private final Set<Characteristics> characteristics;
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CollectorUtil {
    public static void main(String[] args) {
        Supplier<Double> supplier = ()-> Math.random();
        double d =supplier.get();
        System.out.println(d);
        String s ="BiCosmumer";
        System.out.println("Now Example of %s :".formatted(s));
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> lsit2 = Arrays.asList(1,2,4);
        BiConsumer<List<Integer>,List<Integer>> bc = (a,b)->{
            if(a.size()!=b.size())
                System.out.println("List is not same");
            else{
                for(int i=0;i<a.size();i++){
                    if(a.get(i)!=b.get(i)){
                        System.out.println("List is not same");
                        return;
                    }
                }
                System.out.println("List is Same");
            }
        };
        BiConsumer<List<Integer>, List<Integer> > disp = (list11, list21) ->
        {
            list11.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            list21.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };
          bc.andThen(disp).accept(list1,lsit2);
        /* Custom Collector*/



    }
}
