package mypackage.version.enhancement.java16;

import java.util.Objects;

class Record1{
    private final String name;
    private final int rollno;

    public Record1(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record1 record1 = (Record1) o;
        return rollno == record1.rollno && Objects.equals(name, record1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollno);
    }

    @Override
    public String toString() {
        return "Record1{" +
                "name='" + name + '\'' +
                ", rollno=" + rollno +
                '}';
    }
}
record Record2(String name, int rollno){
public String getUpperCaseName(){
    return name.toUpperCase();
}

public static void Method(){
    System.out.println("Static Method Testing");
}

}
public class RecordExample {
    public static void main(String[] args) {
        Record1 r = new Record1("Ronish",1);
        System.out.println(r);
        Record2 r2 = new Record2("ronish",2);
        System.out.println(r2.getUpperCaseName());
        Record2.Method();
        Object a1=null;
        Number n =(Number) a1;
        System.out.println(n);

    }
}
