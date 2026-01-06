package mypackage.version.enhancement.java24;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main() {
       List<String> list  = Arrays.asList("my name", "my name is","my name is ronish","my name is ronish shandilya");
       List<String> finallist = list.stream().flatMap(a->Arrays.stream(a.split(" "))).filter(a->a.length()>3).map(String::toUpperCase).toList();
       finallist.forEach(System.out::println);

    }
}
