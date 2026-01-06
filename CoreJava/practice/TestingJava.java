package practice;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class TestingJava {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Pen", 10.0),
                new Item("Book", 30.5),
                new Item("Book", 36.5),
                new Item("Pencil", 5.25),
                new Item("Abs", 5.25)
        );
    items.stream().map(Item::getPrice).reduce(Double::sum).ifPresent(System.out::println);
    System.out.println(items.stream().map(Item::getPrice).reduce((double) 0,Double::sum));
    System.out.println(items.stream().reduce((double) 0, (sum, item)->sum+item.getPrice(),(item1, item2)->item1+item2));
        System.out.println((double)
    items.stream().collect(Collector.of(
            ()->new double[]{0},
            (acc, item) -> acc[0]+=item.getPrice(),
            (item1, item2)->{item1[0]+=item2[0];return item1;},
             acc->acc[0]
    )));
    HashMap<String, Double> ma=items.stream().collect(Collector.of(
            ()->new double[]{0},
            (acc, item)->acc[0]+=item.getPrice(),
            (item1,item2)->{item1[0]+=item2[0];return item1;},
            (acc)->{
                HashMap<String, Double> map = new HashMap<>();
                map.put("Total",acc[0]);
                return map;
            }

    ));
        System.out.println(ma);
        items.stream().reduce(BinaryOperator.minBy(Comparator.comparing(Item::getPrice))).ifPresent(System.out::println);
        OptionalDouble minPriceOpt = items.stream()
                .mapToDouble(Item::getPrice)
                .min();
        System.out.println(minPriceOpt);
        minPriceOpt.ifPresentOrElse(System.out::println, ()->System.out.println("No Value Present"));
        List<Item> minItems = new ArrayList<>();
        // Step 2: Filter all items with that min price
        minPriceOpt.ifPresent(minPrice -> {
            minItems.addAll(
                    items.stream()
                            .filter(i -> i.getPrice() == minPrice)
                            .collect(Collectors.toList())
            );
        });
        System.out.println(minItems);
        List<String> list1 = Arrays.asList("1","2","3","4");
        list1.stream().mapToInt(Integer::parseInt).max().ifPresentOrElse(System.out::println,()->System.out.println("It is Empty"));
        list1.stream().map(Integer::parseInt).reduce(BinaryOperator.maxBy(Integer::compareTo)).ifPresent(System.out::println);
        Map<String, Optional<Item>> map = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.maxBy(Comparator.comparing(Item::getPrice))));
        System.out.println(map);

        // I want Name whose price is Maximum
        List<Item> items2 = Arrays.asList(
                new Item("Pen", 10.0),
                new Item("Pen", 40.0),
                new Item("Book", 30.5),
                new Item("Book", 36.5),
                new Item("Pencil", 5.25),
                new Item("Abs", 5.25)
        );
        String name = items2.stream().collect(Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(Item::getPrice)),
                optional -> optional.map(Item::getName).map(String::toUpperCase).orElse("No Element")
        ));
        System.out.println(name);

    }
}
