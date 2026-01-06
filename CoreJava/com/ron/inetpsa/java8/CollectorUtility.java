package com.ron.inetpsa.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorUtility {
    public static Collector<String, List<String>, List<String>> toUpperCaseList(){
        return Collector.of(
                ArrayList::new,
                (list, item)->list.add(item.toUpperCase()),
                (list,list2)->{
                    list.addAll(list2);
                    return list;
                },
                Function.identity(),
                Collector.Characteristics.IDENTITY_FINISH
        );
    }
    public static void main(String[] args) {
        List<String> ll = Arrays.asList("ronish","preeti");
        System.out.println("Intial List: "+ll);
        System.out.println("List after Cutsom Collector:" +ll);
        List<String> fin = ll.stream().collect(toUpperCaseList());
        System.out.println(fin);
        Collector<String, Map<Character, Integer>, Map<Character, Integer>> frequencyCharacterMap = Collector.of(
                HashMap::new, // Supplier: Creates an empty HashMap
                (map,str)->str.chars()
                        .mapToObj(c->(char)c).
                        filter(Character::isLetter) // Consider only alphabets
                        .forEach(c -> map.merge(c, 1, Integer::sum)), // Accumulator: Count occurrences
                (map1, map2) -> {
                    map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
                    return map1;
                },
                Collector.Characteristics.IDENTITY_FINISH // No transformation needed
        );
        ll.stream().collect(frequencyCharacterMap).entrySet().forEach(System.out::println);
        /*HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        String s ="ro";
        String p = "pro";
        System.out.println("Intial String : "+s);
        s.chars().mapToObj(a->(char)a).forEach(a->map.merge(a,1,Integer::sum));
        p.chars().mapToObj(a->(char)a).forEach(a->map1.merge(a,1,Integer::sum));
        System.out.println(map);
        System.out.println(map1);
        System.out.println("Count of Map1 :"+map);
        System.out.println("Count of Map2 :"+map1);
        map1.forEach((key,value)->{
            //System.out.println("Key :"+key + " Value :"+value);
            System.out.println("Map :"+map);
            map.merge(key,value,Integer::sum);
            System.out.println("Map Changes"+map);
        });*/

    }
}
