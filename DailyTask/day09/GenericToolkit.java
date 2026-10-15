
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GenericToolkit {

    // 1. Generic Pair: stores two values of different types
    static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + " = " + value;
        }
    }

    // 2. Bounded generic class: accepts Number types only
    static class Box<T extends Number> {
        T value;

        Box(T value) {
            this.value = value;
        }

        double square() {
            return value.doubleValue() * value.doubleValue();
        }
    }

    // 3. Generic method: finds the maximum value
    static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // 4. Wildcard: reads Number values
    static double sum(List<? extends Number> numbers) {
        double total = 0;
        for (Number n : numbers)
            total += n.doubleValue();
        return total;
    }

    // 5. Wildcard: adds integers to a suitable list
    static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }

    // 6. AutoCloseable resource
    static class MyResource implements AutoCloseable {
        String name;

        MyResource(String name) {
            this.name = name;
            System.out.println(name + " opened");
        }

        public void close() {
            System.out.println(name + " closed");
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("=== PAIR ===");
        Pair<Integer, String> pair = new Pair<>(101, "Arun");
        System.out.println(pair);

        System.out.println("\n=== BOX ===");
        Box<Integer> box = new Box<>(5);
        System.out.println("Square: " + box.square());

        System.out.println("\n=== MAX ===");
        System.out.println("Maximum: " + max(25, 40));
        System.out.println("Maximum: " + max("Apple", "Mango"));

        System.out.println("\n=== WILDCARD EXTENDS ===");
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        System.out.println("Sum: " + sum(numbers));

        System.out.println("\n=== WILDCARD SUPER ===");
        List<Number> values = new ArrayList<>();
        addNumbers(values);
        System.out.println(values);

        System.out.println("\n=== PRODUCTS CSV ===");
        Path file = Paths.get("products.csv");

        if (Files.exists(file)) {
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null)
                    System.out.println(line);
            }
        } else {
            System.out.println("products.csv not found.");
        }

        System.out.println("\n=== RESOURCE CLOSE ORDER ===");
        try (MyResource first = new MyResource("First");
             MyResource second = new MyResource("Second")) {
            System.out.println("Inside try block");
        }
    }
}
