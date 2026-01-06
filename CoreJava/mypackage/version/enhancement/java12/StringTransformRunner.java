package mypackage.version.enhancement.java12;

public class StringTransformRunner {
    public static void main(String[] args) {
        String text = "java features";
        int[] arr = {1,2,3,4};
        String transformedText = text.transform(s -> s.toUpperCase() + " - Java 12");
        System.out.println(transformedText);
        String output = text.transform(s->String.join(" ", s.split(" "))).transform(str-> new StringBuilder(str).reverse().toString().toUpperCase());
        System.out.println(output);
    }
}
