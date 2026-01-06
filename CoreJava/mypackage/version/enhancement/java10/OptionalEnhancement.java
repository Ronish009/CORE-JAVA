package mypackage.version.enhancement.java10;

import java.util.NoSuchElementException;
import java.util.Optional;

/*
* Java 10 adds a new method orElseThrow() to the Optional class.
* This method returns the contained value if present or throws a
* NoSuchElementException if not.
* */
public class OptionalEnhancement {
    public static void main(String[] args) {
        var opt = Optional.of("Ronish");
        String value = opt.orElseThrow();
        System.out.println(value);
        Optional<String> emptyOptional = Optional.empty();

        try {
            System.out.println(ProcessHandle.current().pid());
            Thread.sleep(100000);
            // This will throw NoSuchElementException
            emptyOptional.orElseThrow();
        } catch (NoSuchElementException e ) {
            System.out.println("No value present");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
