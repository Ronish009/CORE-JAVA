package com.ron.inetpsa.java8;

import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        record Employee(String name, int salary){}
        List<String> words = List.of("Hello", "World", "Java");
        List<Employee> employees = Arrays.asList(new Employee("Ronish",400), new Employee("Preeti", 300), new Employee("Salman",800));
        BinaryOperator<Employee> e = BinaryOperator.maxBy(Comparator.comparingInt(Employee::salary));
        /* Maximum Salary of Employee*/
        Employee e1 = employees.stream().reduce(e).orElse(null);
        Integer salary = (e1 != null) ? e1.salary : 0;
        System.out.println(salary);
        /* Maximum Salary of Employee */
        int maxSalary = employees.stream().map(Employee::salary).max(Integer::compareTo).orElse(0);
        System.out.println("Max Salary: " + maxSalary);
        /* Maximum Salary of Employee*/
        Employee maxSalaryEmployee = employees.stream().collect(Collectors.collectingAndThen(
               Collectors.maxBy(Comparator.comparingInt(Employee::salary)),
                        optional->optional.orElse(null)));

        int max = employees.stream().collect(Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(Employee::salary)),
                optional->optional.map(Employee::salary).orElse(0)));
        System.out.println("Max Salary : "+max);

        /* Maximum Salary*/
        int max1 = employees.stream().mapToInt(Employee::salary).max().orElse(0);
        System.out.println("Max Salary  : "+max1);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 1, 2, 3);

        List<Integer> result = numbers.stream()
                .takeWhile(n -> n < 5) // Take elements while less than 5
                .toList();

        System.out.println(result);
        System.out.println(numbers);
       long s =24;
       List<Long> countList = Arrays.asList(s);
        int count = (int) (long) countList.get(0);
        System.out.println(count);
        int i=24;
        long count1=i;
        if(count1>0){
            System.out.println("Ronish");
        }


    }
}
