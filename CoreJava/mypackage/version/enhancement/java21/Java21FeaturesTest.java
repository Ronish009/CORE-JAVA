package mypackage.version.enhancement.java21;

import java.util.SequencedMap;

public class Java21FeaturesTest {
    public static void main(String[] args) {
        Shape shape = new Rectangle(5, 10);
        printArea(shape);

        shape = new Circle(3);
        printArea(shape);
    }

    // Pattern matching with switch
    static void printArea(Shape shape) {
        double area = switch (shape) {
            case Rectangle r -> r.length() * r.width();
            case Circle c -> Math.PI * c.radius() * c.radius();
            default -> throw new IllegalStateException("Unexpected shape: " + shape);
        };

        System.out.println("Area: " + area);
    }
}

// Sealed interface and records
sealed interface Shape permits Rectangle, Circle {}

record Rectangle(int length, int width) implements Shape {}
record Circle(int radius) implements Shape {}

