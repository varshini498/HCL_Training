
import java.util.*;

public class RepositoryDemo {

    static class Employee {
        private final int id;
        private final String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int getId() {
            return id;
        }

        public String toString() {
            return id + " - " + name;
        }
    }

    static class Product {
        private final String id;
        private final String name;

        Product(String id, String name) {
            this.id = id;
            this.name = name;
        }

        String getId() {
            return id;
        }

        public String toString() {
            return id + " - " + name;
        }
    }

    public static void main(String[] args) {

        CrudRepository<Employee, Integer> employees =
                new InMemoryRepository<>(Employee::getId);

        employees.save(new Employee(101, "Arun"));
        employees.save(new Employee(102, "Priya"));

        System.out.println("Employees: " + employees.findAll());
        System.out.println("Find employee 101: "
                + employees.findById(101));

        CrudRepository<Product, String> products =
                new InMemoryRepository<>(Product::getId);

        products.save(new Product("P01", "Keyboard"));
        products.save(new Product("P02", "Mouse"));

        System.out.println("Products: " + products.findAll());
        System.out.println("Deleted P01: "
                + products.deleteById("P01"));
        System.out.println("Remaining products: "
                + products.findAll());
    }
}
