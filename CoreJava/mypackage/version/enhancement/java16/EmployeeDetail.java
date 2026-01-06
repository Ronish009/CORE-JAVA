package mypackage.version.enhancement.java16;

public record EmployeeDetail(String name, Integer rollno) implements Runnable{

    public EmployeeDetail{
        if(rollno>21){
            throw new IllegalArgumentException("rollno should be less than 20");
        }
    }
    public static String upperName(String name){
        return name.toUpperCase();
    }

    public  String appendHello(){
        return "Hello " +name.toUpperCase();
    }

    @Override
    public void run() {
        System.out.println("Hello"+Thread.currentThread().getName() + name + " : "+rollno);
    }
}