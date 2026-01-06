package mypackage.version.enhancement.java12;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

record Person(int rollno, double salary){}

public class TeeingCollectorRunner {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var result = numbers.stream().collect(Collectors.teeing(
                Collectors.summarizingInt(Integer::intValue),
                Collectors.averagingDouble(Integer::intValue),
                (a,b)->"Sum : "+a+" Averaging : "+b
        ));
        List<Person> ll = Arrays.asList(new Person(1,56.45), new Person(4,32.88), new Person(2,44.45));
        List<Person> list23 = List.copyOf(ll);
        Map<String, Person> map = list23.stream().collect(Collectors.teeing(
                Collectors.maxBy(Comparator.comparing(Person::salary)),
                Collectors.minBy(Comparator.comparing(Person::salary)),
                (e1,e2)->{
                    HashMap<String, Person> maptest = new HashMap<>();
                    maptest.put("Max",e1.get());
                    maptest.put("Min",e2.get());
                    return maptest;
                }
        ));

        System.out.println(map);
    }

}
