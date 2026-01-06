package mypackage.version.enhancement.java16;


public class RecordRunner {
    record Person(String name, int rolln0){}
    public static void main(String[] args) {
        Person p = new Person("Rony",1);
        Person p1 = new Person("Rony",1);
        Person p2 = new Person("Rony1",1);
        System.out.println(p.rolln0);
        System.out.println(p.equals(p1));
        System.out.println(p.equals(p2));
    }
}
