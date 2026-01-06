package mypackage.version.enhancement.java11;

public class StringNewAPIRunner {
    public static void main(String[] args) {
       /* Java 11*/
        System.out.println("".isBlank());
        System.out.println("  LR  ".replace(" ","@"));
        System.out.println("  LR  ".strip());

        System.out.println("  LR  ".stripLeading());
        System.out.println("  LR  ".stripTrailing());
        "r\no\nn\ni".lines().forEach(System.out::println);
       /* Java 12 */
        String s12 ="UPPER".transform(s->s.substring(3));
        System.out.println(s12);
        System.out.println("My name is %s".formatted("Ronish"));
       /* Java 14 */
       /* String s12_1=null;
        System.out.println(s12_1.isBlank());*/

    }
}
