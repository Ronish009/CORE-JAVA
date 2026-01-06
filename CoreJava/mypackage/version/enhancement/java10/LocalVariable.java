package mypackage.version.enhancement.java10;

/*
* Java 10 introduced the var keyword to allow local variable type inference.
* This means that the Java compiler can infer the type of a local variable based
* on the initializer, making the code more concise and readable.
* */

import java.util.ArrayList;
import java.util.HashMap;

public class LocalVariable {
    public static void main(String[] args) {
       var list = new ArrayList<String>();
       list.add("Ronish");
        System.out.println(list);
        var map = new HashMap<String, Integer>();
        map.put("Ronish",1);
        map.entrySet().forEach(a->{
            System.out.println(a.getKey() + ":" +a.getValue());
        });
    }
}
