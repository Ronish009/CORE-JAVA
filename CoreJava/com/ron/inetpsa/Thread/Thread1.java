package com.ron.inetpsa.Thread;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class ThreadRunner implements Runnable{

    String name;

    public ThreadRunner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
        List<String> list= null;
        //System.out.println(list.size());
        int size = Objects.requireNonNullElse(list, List.of()).size(); // Safe alternative
        System.out.println("Size: " + size); // Output: 0
        List<String> list2 = Arrays.asList("Ronish", null, "Apple","Sumit");
        list2.sort((s1,s2)->Objects.compare(s1,s2,Comparator.nullsLast(String::compareTo)));
        System.out.println(list2);
        List<List<Integer>> l1 = List.of(List.of(1,2,3));
        List<List<Integer>> l2 = List.of(List.of(1,2,3));
        System.out.println(Objects.deepEquals(l1,l2));



    }
}
public class Thread1 {
    public static void main(String[] args) {
           ThreadRunner th = new ThreadRunner("Ronish");
            Thread t = new Thread(th);
            t.start();
        }
    }

