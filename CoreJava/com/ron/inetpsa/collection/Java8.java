package com.ron.inetpsa.collection;


import java.util.*;
import java.util.stream.Collectors;

class Person{
    Integer Id;
    String Name;
    String City;

    public Person(Integer id, String name, String city) {
        Id = id;
        Name = name;
        City = city;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(Id, person.Id) && Objects.equals(Name, person.Name) && Objects.equals(City, person.City);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, City);
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
public class Java8 {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person(1,"Ronish","Jhs"), new Person(2, "Preeti","NDLS"),new Person(3,"Rachit Shandilya","JHS"), new Person(4,"Nayan","JHS"), new Person(5,"Sannu","JHS"));
        list.forEach(System.out::println);
        Map<String, Set<String>> map = list.stream().peek(System.out::println).
                collect(Collectors.groupingBy(a->a.getCity().toUpperCase(), Collectors.mapping(Person::getName, Collectors.toSet())));
       map.entrySet().stream().forEach(System.out::println);
       String a = "/server/events/alarmEvent/123/";
       System.out.println(a);
       Object b = a.substring(0,a.indexOf("/"));
       System.out.println(b);
       String beginId = "0.0.0.1";
        System.out.println(beginId.length());
        System.out.println(beginId.lastIndexOf("."));

    }
}
