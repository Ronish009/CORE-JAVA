package com.ron.inetpsa.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerUtil {
    public static void main(String[] args) {
        BiConsumer<String,String> bcon1 = (b1,b2)-> System.out.println("Hello Mr "+b1 + " "+b2);
        BiConsumer<String,String> bcon2 = (b1,b2)-> System.out.println("Good Bye %s %s !!!".formatted(b1,b2) );
        BiConsumer<String, String> comb = bcon1.andThen(bcon2);
        comb.accept("Ronish", "Shandilya");
        Map<String, Integer> map = new HashMap<>();
        map.put("A",2);
        map.put("B",4);
        BiConsumer<String, Integer> bi = (a,b)->map.put(a,map.getOrDefault(a,0)+b);
        map.entrySet().forEach(System.out::println);
        bi.accept("A",4);
        bi.accept("C",7);
        System.out.println(map);

    }
}
