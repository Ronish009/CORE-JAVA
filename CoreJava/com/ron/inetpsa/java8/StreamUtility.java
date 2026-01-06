package com.ron.inetpsa.java8;


import java.util.*;
import java.util.stream.Collectors;


public class StreamUtility {
    public static void main(String[] args) {
        record Person(String name, int rollno){}
        List<Person> list = Arrays.asList(new Person("Ronish",5), new Person("Preeti",35));
        Optional<Person> c = list.stream().max(Comparator.comparing(Person::rollno));
        c.ifPresentOrElse(person -> System.out.println(person.name),()-> System.out.println("Not Present"));
        String a = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::name)),(Optional<Person> o) -> o.isPresent() ?o.get().name():"none"));
        System.out.println(a);
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<String> finalList = names.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                l->l.stream().sorted(Comparator.comparingInt(String::length)).toList()
        ));
        System.out.println(finalList);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, Optional<Integer>> maxInGroup = numbers.stream()
                .collect(Collectors.groupingBy(
                        num -> num % 2 == 0 ? "Even" : "Odd",
                        Collectors.maxBy(Integer::compareTo)
                ));
        System.out.println(maxInGroup);
        Map<String, Integer> maxInGroup1 = numbers.stream()
                .collect(Collectors.groupingBy(
                        num -> num % 2 == 0 ? "Even" : "Odd",
                        Collectors.collectingAndThen(Collectors.maxBy(Integer::compareTo),a1->a1.orElse(0))
                ));
        System.out.println(maxInGroup1);
    }
}
