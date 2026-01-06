package mypackage.version.enhancement.java16;

public class RecordUtil {
    public static void main(String[] args) {
        int a=2;
        int b =6;
        EmployeeDetail e = new EmployeeDetail("Ronish",(a+b));
        System.out.println(e.name());
        System.out.println(e.rollno());
        System.out.println(EmployeeDetail.upperName(e.name()));
        System.out.println(e.appendHello());
        new Thread(e).start();
    }
}
