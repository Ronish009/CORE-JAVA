package com.ron.inetpsa.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CustomCollector {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ronish", "Preeti");
        System.out.println(list);
        Collector<String, StringBuilder,String> custcollect = Collector.of(
                StringBuilder::new,
                (sb, str) -> sb.append("[").append(str).append("] "), // Accumulator
                StringBuilder::append,    // Combiner (used in parallel streams)
                StringBuilder::toString   // Finisher: converts StringBuilder to String
        );
        String s = list.stream().collect(custcollect);
        System.out.println(s);
        List<String> list1 = Stream.of("A", "B", "C").collect(Collectors.toList());
        System.out.println(list1);
        list1.add("g");
        System.out.println(list1);

    }
}
