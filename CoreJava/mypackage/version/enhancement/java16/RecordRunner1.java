package mypackage.version.enhancement.java16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

record Emp(String name, int rollno, String city, double salary){}

public class RecordRunner1 {
    public static void main(String[] args) {

        List<Emp> list = Arrays.asList(new Emp("Ron",1,"Newyork",78.00), new Emp("Ar",2,"Com",56.00));
        String a = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Emp::salary).reversed()),(Optional<Emp> o) -> o.isPresent() ?o.get().name():"none"));
        System.out.println(a);
    }
}
