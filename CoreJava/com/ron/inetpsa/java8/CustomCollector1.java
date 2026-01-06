package com.ron.inetpsa.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector1 {
    public static void main(String[] args) {
        Collector<Integer, int[], Double> AveragePrimitive = Collector.of(
               () -> new int[2], //Supplier
                 (a,elem)->{ a[0]+=elem;a[1]++;}, //BiConsumer - accumulator
                (a,b)->{a[0]+=b[0];a[1]+=b[1]; return a;},  //BinaryOpeartor - Combiner
                a->a[1]==0?0:(double)a[0]/a[1] //Finisher
        );
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        Double d = list.parallelStream().collect(AveragePrimitive);
        System.out.println("Average :"+d);
    }
}
