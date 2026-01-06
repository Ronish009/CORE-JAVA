package mypackage.version.enhancement.java9;

import java.util.List;
import java.util.Optional;

public class StreamUtil {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().takeWhile(n -> n < 4).forEach(System.out::println);
        numbers.stream().dropWhile(n -> n < 4).forEach(System.out::println);
        String value = Math.random() > 0.5 ? "Hello" : null;

        Optional<String> optionalValue = Optional.ofNullable(value);

        optionalValue.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Value is null")
        );
    }
}
