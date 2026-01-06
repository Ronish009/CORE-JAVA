package mypackage.version.enhancement.java10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableCollection {
    public static void main(String[] args) {
        var OrignalMap = Map.of(1,"Ronish", 2, "Aryan");
        System.out.println(OrignalMap);
        //OrignalMap=Map.of(3,"Preeti");
        System.out.println(OrignalMap);
        var immutableMap = Map.copyOf(OrignalMap);
        System.out.println(immutableMap);
        //immutableMap.put(3,"Preeti");
        System.out.println(immutableMap);

        /*
        * Collections.unmodifiableMap creates a wrapper around the same existing
        * Map such that the wrapper cannot be used to modify it.
        * However we can still change original Map.
         * */


        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Geeks");
        map.put(2, "For");
        map.put(3, "Geeks");

        // Create ImmutableMap from Map using copyOf()
        Map<Integer, String> imap = Collections.unmodifiableMap(map);

        // We change map and the changes reflect in imap.
        map.put(4, "Computer");
        map.put(5, "Portal");

        /*
        * List.copyOf(), Set.copyOf(), and Map.copyOf() create unmodifiable views
        * of the original collections, ensuring they cannot be modified
        *
        * */

        System.out.println(imap);

        /*
        * Collectors.toUnmodifiableList(), toUnmodifiableSet(), and toUnmodifiableMap()
        * These collectors are used in conjunction with streams to collect elements into
        * unmodifiable collections.
        * */

        var list = Stream.of("Java", "10", "Features")
                .collect(Collectors.toUnmodifiableList());

        var set = Stream.of("A", "B", "C")
                .collect(Collectors.toUnmodifiableSet());

        var map1 = Stream.of("One", "Two")
                .collect(Collectors.toUnmodifiableMap(
                        s -> s,
                        s -> s.length()
                ));

        System.out.println("Unmodifiable List: " + list);
        System.out.println("Unmodifiable Set: " + set);
        System.out.println("Unmodifiable Map: " + map1);
    }
}
