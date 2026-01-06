package com.ron.inetpsa.java8;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BinaryOperatorUtil {


    public void third(String name){
        System.out.println(this.getClass().getEnclosingMethod());
        Optional<Method> enclosingMethod = StackWalker.getInstance()
                .walk(frames -> frames
                        .findFirst()
                        .flatMap(frame -> {
                            try {
                                // Find method dynamically without specifying parameter types
                                for (Method method : this.getClass().getDeclaredMethods()) {
                                    if (method.getName().equals(frame.getMethodName())) {
                                        return Optional.of(method);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return Optional.empty();
                        })
                );

        enclosingMethod.ifPresent(method -> {
            System.out.println("Method: " + method.getName());
            // requestContext.setParamTypes(method.getParameterTypes());
            for (Class<?> paramType : method.getParameterTypes()) {
                System.out.println("Parameter Type: " + paramType.getName());
            }
        });
    }
    public void second(String name, int num){
        third(name);
    }

    public void First(String name, int num){
        String s = StackWalker.getInstance().walk(f->f.findFirst().get().getMethodName());
        System.out.println(s);
        System.out.println("Ronish");
        Optional<Method> enclosingMethod = StackWalker.getInstance()
                .walk(frames -> frames
                        .skip(1) // Skip the current frame
                        .findFirst()
                .map(frame -> {
                    System.out.println("aaa");
                            try {
                                System.out.println("kk");
                                System.out.println(this.getClass().getDeclaredMethods());
                                return this.getClass().getDeclaredMethod(frame.getMethodName());
                            } catch (NoSuchMethodException e) {
                                return null;
                            }
                        })
                );
        System.out.println("End");
        enclosingMethod.ifPresent(method -> {
            System.out.println("Method: " + method.getName());
            for (Class<?> paramType : method.getParameterTypes()) {
                System.out.println("Parameter Type: " + paramType.getName());
            }
        });



    }
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("R1","A1");
        List<String> list2 = Arrays.asList("D1","B1");
        BinaryOperator<List<String>> bo = (a,b)-> Stream.concat(a.stream(),b.stream())
                .sorted(Comparator.reverseOrder())
                .collect(toList());
        List<String> listCom = bo.apply(list1,list2);
        System.out.println(listCom);
        System.out.println("Example of Merge :"+" Using %s".formatted("BinaryOperator"));
        List<List<Integer>> listofList = Arrays.asList(new ArrayList<>(List.of(10,8)),
                new ArrayList<>(List.of(5,2)),
                new ArrayList<>(List.of(3,9)));
        System.out.println("Before Merge List :"+listofList);
        BinaryOperator<List<Integer>> mergeList = (l1,l2)->{
           l1.addAll(l2);
           return  l1;
        };
        List<Integer> finalList = listofList.stream().reduce(new ArrayList<>(),mergeList);
        System.out.println(finalList);
        System.out.println("reduce(BinaryOperator<T> accumulator)");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce(Integer::sum);
        sum.ifPresent(System.out::println);
        System.out.println("T reduce(T identity, BinaryOperator<T> accumulator)");
        int sum1 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum1);
        System.out.println("reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)");
        List<String> words = Arrays.asList("Hello", "World", "Java", "Streams");
        String result = words.parallelStream()
                .reduce("", (partial, word) -> partial + word + "1", String::concat);
        System.out.println(result);

        String result12 = words.stream()
                .reduce((word1, word2) -> word1 + "1" + word2)
                .map(res -> res + "1") // Append "1" to the last word
                .orElse("");

        System.out.println(result12);

        String result13 = words.stream()
                .map(word -> word + "1")    // Step 1: Append "1" to each word
                .collect(Collectors.joining()); // Step 2: Join all elements into a single String
        System.out.println(result13);

        List<Integer> number14 = Arrays.asList(10, 5, 20, 8, 15);
        System.out.println("Minumum Integer Value :"+Integer.MIN_VALUE);
        int maxValue = number14.parallelStream().reduce(Integer.MIN_VALUE,Integer::max, Integer::max);
        System.out.println("Max Value :"+maxValue);
        System.out.println("Number of Elements : ");
        int sumofElement = number14.parallelStream().reduce(0, (a,b)->a+1, Integer::sum);
        System.out.println(sumofElement);
        List<String> word78 = Arrays.asList("apple", "banana", "cherry", "date");
        int count = word78.parallelStream()
                .reduce(0,
                        (subtotal, word) -> subtotal + 1, // Accumulator
                        Integer::sum);
        System.out.println(count);
       HashMap<String, String> hm = new HashMap<>();

        System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
        //System.out.println(BinaryOperatorUtil.class.getEnclosingMethod().getName());
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        //String s = StackWalker.getInstance().walk(f->f.findFirst().get().getMethodName());
        //System.out.println(s);
       /* Class<?>[] c =  new Object() {}.getClass().getEnclosingMethod().getParameterTypes();
        for (Class t : c){
            System.out.println(t);
        }*/
        System.out.println("======================");
        BinaryOperatorUtil b = new BinaryOperatorUtil();
       // b.First("Ronish",25);
       b.second("sumit",28);

        System.out.println(BinaryOperatorUtil.class.getEnclosingMethod());
    }
}
