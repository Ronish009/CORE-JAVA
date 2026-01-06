package mypackage.version.enhancement.java17;


sealed class Employee permits Manager, Engineer, Contractor {
    String name;
    Employee(String name) {
        this.name = name;
    }
}

final class Manager extends Employee {
    int teamSize;

    Manager(String name, int teamSize) {
        super(name);
        this.teamSize = teamSize;
    }

    public String toString() {
        return "Manager " + name + " manages " + teamSize + " people.";
    }
}

// Sealed subclass — restrict who can extend Engineer
sealed class Engineer extends Employee permits SoftwareEngineer {
    Engineer(String name) {
        super(name);
    }
}

final class SoftwareEngineer extends Engineer {
    SoftwareEngineer(String name) {
        super(name);
    }

    public String toString() {
        return "Software Engineer: " + name;
    }
}

// Non-sealed subclass — anyone can extend Contractor
non-sealed class Contractor extends Employee {
    Contractor() {
        super("External Contractor");
    }

    public String toString() {
        return "Contractor: " + name;
    }
}

// Later in another package/class, this is allowed
class FreelanceDeveloper extends Contractor {
    FreelanceDeveloper() {
        super();
    }
}

public class SealedClassHierarchyDemo {
    public static void main(String[] args) {
        Employee emp1 = new Manager("Alice", 5);
        Employee emp2 = new Contractor(); // Can be subclassed further

        System.out.println(emp1);
        System.out.println(emp2);
    }
}
