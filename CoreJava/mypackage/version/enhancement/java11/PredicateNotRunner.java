package mypackage.version.enhancement.java11;

import java.util.List;
import java.util.function.Predicate;

public class PredicateNotRunner {

    public static boolean isEven(Integer number){
        return number%2==0;
    }
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,4,7,5,88,33,11,16);
        Predicate<Integer> p = n->n%2==0;
        list.stream().filter(p.negate()).forEach(a->System.out.print(a+ " "));
        System.out.println("===================================");
        list.stream().filter(PredicateNotRunner::isEven).forEach(a->System.out.print(a+ " "));
        System.out.println("====================================");
        list.stream().filter(Predicate.not(PredicateNotRunner::isEven)).forEach(a->System.out.print(a+ " "));
        System.out.println("====================================");
        list.stream().filter(Predicate.not(p)).forEach(a->System.out.print(a+ " "));
    }
}
