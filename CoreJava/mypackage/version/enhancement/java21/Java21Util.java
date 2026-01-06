package mypackage.version.enhancement.java21;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

sealed interface Shape1 permits Circle1, Rectangle1 { }

record Circle1(double radius) implements Shape1 { }

record Rectangle1(double length, double width) implements Shape1 { }

public class Java21Util {
    public static void main(String[] args) {
        List<Shape1> shapes = List.of(
                new Circle1(5),
                new Rectangle1(4, 3),
                new Circle1(7)
        );

        for(Shape1 s: shapes){
            String result = switch (s){
                case Circle1 c -> "Circle Area : " +Math.PI* c.radius()*c.radius();
                case Rectangle1 r->"Rectangle Area : "+r.length()*r.width();
                default -> "Unknown shape: " + s.getClass().getSimpleName();
            };
            System.out.println(result);
        }
        List<String> l = Arrays.asList("a","b","c");
        l.forEach(_ -> System.out.println("Hello"));
        Object s = Boolean.FALSE;
        System.out.println((Boolean)s?1:0);

    }
}
