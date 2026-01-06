package com.ron.inetpsa;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class City{
    private String name;
    private double temperature;

    public City() {
    }

    public City(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}

class Employee {
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class Java8 {

    private static List<City> prepareTemperature()
    {
        List<City> cities = new ArrayList<>();
        cities.add(new City("New Delhi", 33.5));
        cities.add(new City("Mexico", 14));
        cities.add(new City("New York", 13));
        cities.add(new City("Dubai", 43));
        cities.add(new City("London", 13));
        cities.add(new City("Alaska", 1));
        cities.add(new City("Kolkata", 30));
        cities.add(new City("Sydney", 11));
        cities.add(new City("Mexico", 14));
        cities.add(new City("Dubai", 44));
        cities.add(new City("Jhansi", 33));
        return cities;
    }
    public static void main(String...ronish) {
        System.out.println("/* Demonstration of toList() */");
        System.out.println(prepareTemperature().stream().filter(a->a.getTemperature()>15)
                .map(a->a.getName()).collect(toList()));
        System.out.println("/* Demonstration of toSet() */");
        System.out.println(prepareTemperature().stream().filter(a->a.getTemperature()==13)
                .map(a->a.getName()).collect(Collectors.toSet()));
        System.out.println("/* Demonstration of toCollection() */");
        System.out.println(prepareTemperature().stream()
                        .filter(a->a.getTemperature()>15 && a.getTemperature()<35)
                           .map(a->a.getName()).collect(Collectors.toCollection(()-> new ArrayList<>())));
        System.out.println("/* Demonstration of toMap() */");
        System.out.println(prepareTemperature().stream()
                .filter(a->a.getTemperature()>15 && a.getName().equals("Dubai"))
                .collect(Collectors.toMap(City::getName, City::getTemperature,(a,b)->a, ()-> new HashMap<>())));
        System.out.println("/* Demonstration of GroupinBy() */");
        System.out.println(prepareTemperature().stream()
                .filter(a->a.getTemperature()>15 && a.getTemperature()<35)
                .collect(Collectors.groupingBy(City::getName,Collectors.collectingAndThen(Collectors.counting(),f->f.intValue()))));
        System.out.println("Testing");
        List<String> input =
                List.of("FOO", "FOO", "FOO", "FOO", "FOO", "BAR",
                        "BAR", "BAZ", "BAZ", "BAZ", "DOO", "DOO");
        Map<String, Long> map = input.stream().collect(Collectors
                .groupingBy(a -> a, Collectors.collectingAndThen(
                        Collectors.counting(),
                       /* s -> String.format("%.02f%%", s * 100. / input.size()))));*/
                        s ->s+1)));
       map.entrySet().forEach(System.out::println);
        List<Employee> employeeList
                = Arrays.asList(new Employee("Tom Jones", 45, 15000.00),
                new Employee("Tom Jones", 45, 7000.00),
                new Employee("Ethan Hardy", 65, 8000.00),
                new Employee("Nancy Smith", 22, 10000.00),
                new Employee("Deborah Sprightly", 29, 9000.00),
                new Employee("Ajay", 29, 9000.00),
                new Employee("ajay", 29, 6000.00));
      //employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).ifPresent(a-> System.out.println(a.getName() + ":"+a.getSalary()+":"+a.getAge()));
        System.out.println("Ronish :"+employeeList.subList(0,3));
        employeeList.stream().sorted(Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)).forEach(System.out::println);
        employeeList.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(a-> System.out.println(a.getName() + ":"+a.getSalary()+":"+a.getAge()));
        String maxSalaryEmp = employeeList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        (Optional<Employee> emp)-> emp.isPresent() ? emp.get().getName() : "none") );
        System.out.println("Max salaried employee's name: "+ maxSalaryEmp);
        String avgSalary = employeeList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.averagingDouble(Employee::getSalary),
                        averageSalary -> new DecimalFormat("'$'0.00").format(averageSalary)));
        System.out.println("Average salary in $: " + avgSalary);
        System.out.println("======================================");
        List<Employee> top3 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.collectingAndThen(toList(), a->a.subList(0,3)));
        System.out.println("Top 3 Employee :"+top3);
        List<Employee> emptop3 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .limit(3).toList();
        System.out.println("Top 3 Employee Using Limit:"+top3);
        System.out.println("=========================================");
        DoubleSummaryStatistics c =  employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(c.getSum());
        Stream.iterate(1, (Integer n) -> n + 1)
                .peek(n -> System.out.println("number generated: - " + n))
                .filter(n -> (n % 2 == 0))
                .peek(n -> System.out.println("Even number filter passed for - " + n))
                .limit(5)
                .count();
        List<Integer> list
                = Arrays.asList(0, 2, 4, 6, 8, 10);
        long count =list.stream()
                .peek(System.out::println)
                .collect(Collectors.collectingAndThen(Collectors.counting(),a->a+100));
        System.out.println(count);
    }
}
