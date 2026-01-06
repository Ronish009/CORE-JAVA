package mypackage.version.enhancement.java14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwitchRunner {
    public static void main(String[] args) {
        record Person(String name, int Age){};
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n1. Add Person");
            System.out.println("2. Show All Persons");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 ->{

                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    people.add(new Person(name, age));
                    System.out.println("✅ Person added successfully!");
                }
                case 2 ->{
                    if (people.isEmpty()) {
                        System.out.println("⚠️ No persons available!");
                    } else {
                        System.out.println("\n📜 List of Persons:");
                        people.forEach(person -> System.out.println(person.name() + " (Age: " + person.Age + ")"));
                    }
                }
                case 3 -> {
                    System.out.println("🚀 Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice! Please enter 1, 2, or 3.");
            }
        }

    }
}
