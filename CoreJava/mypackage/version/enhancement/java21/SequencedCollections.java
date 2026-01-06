package mypackage.version.enhancement.java21;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class SequencedCollections {
    public static void main(String[] args) {
        /*SequencedMap : firstEntry(), lastEntry(), pollFirstEntry(), pollLastEntry(), reversed()*/
        /*LinkedHashMap : putLast(K,V)  putFirst(K,V) sequencedEntrySet() sequencedKeySet()
        sequencedValue() */
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("A","1");
        linkedHashMap.put("B","2");
        linkedHashMap.forEach((key, value) -> System.out.println("Key :" + key + " Value :" + value));
        System.out.println();linkedHashMap.putIfAbsent("A","3");
        //linkedHashMap.forEach((key, value) -> System.out.println("Key :" + key + " Value :" + value));
        System.out.println(linkedHashMap.entrySet().stream().map((k) -> "Key : "+k.getKey() +" Value : "+k.getValue()).collect(Collectors.joining("\n\n")));
        linkedHashMap.putFirst("C","3");
        linkedHashMap.putFirst("D","4");
        System.out.println();
        linkedHashMap.forEach((key, value) -> System.out.println("Key :" + key + " Value :" + value));
        System.out.println("First :"+linkedHashMap.pollFirstEntry());
        System.out.println("Last :"+linkedHashMap.pollLastEntry());
        linkedHashMap.forEach((key, value) -> System.out.println("Key :" + key + " Value :" + value));
        System.out.println("Last :"+linkedHashMap.firstEntry());
        System.out.println();
        linkedHashMap.forEach((key, value) -> System.out.println("Key :" + key + " Value :" + value));
        System.out.println();
        linkedHashMap.sequencedEntrySet().reversed().forEach((k) -> System.out.println("Key : "+k.getKey() +" Value : "+k.getValue()));

    }
}
