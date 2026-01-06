package mypackage.version.enhancement.java16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MultiMapRunner {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("R1","R2");
        Stream<Character> characterStream = words.stream()
                .mapMulti((word, consumer) -> {
                    for (char c : word.toCharArray()) {
                        consumer.accept(c); // Adding multiple values
                    }
                });

        characterStream.forEach(System.out::print);
        List<String> list3 = Arrays.asList("Ronish","1","Preeti","2");
        System.out.println("Map :");
        List<Integer> ll = list3.stream()
                .filter(a->{
                    try{
                        Integer.parseInt(a);
                        return true;
                    }catch (NumberFormatException e){
                        return false;
                    }
                })
                .map(Integer::parseInt).collect(toList());
        System.out.println(ll);
        System.out.println("Flat Map :");
        List<Integer> ll1 = list3.stream()
                .flatMap(a->{
                    try{
                       return Stream.of(Integer.parseInt(a));
                    }catch (NumberFormatException e){
                     return Stream.empty();
                    }
                })
                .collect(toList());
        System.out.println(ll1);
        System.out.println("MultiMap :");
        List<Integer> ll5 = list3.stream()
                .<Integer>mapMulti((string,consumer)->{
                    try{
                        consumer.accept(Integer.parseInt(string));
                    }catch (NumberFormatException e){

                    }
                })
                .collect(toList());
        System.out.println(ll5);
        var s = Stream.of("R1,R2","R3,R4");
        var p = s.mapMulti(
                (s1,consumer)->{
                    for(var d:s1.split(",")){
                        consumer.accept(d);
                    }
                }
        ).toList();
        System.out.println(p);

    }
}
