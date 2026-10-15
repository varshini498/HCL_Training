
import java.io.*;
import java.nio.file.*;

public class EmployeeCsvSeeder {

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

        @Override
        public String toString() {
            return id + " - " + name;
        }
    }

    public static void main(String[] args) throws IOException {

        CrudRepository<Employee, Integer> repository =
                new InMemoryRepository<>(Employee::getId);

        Path file = Paths.get("employees.csv");

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;

            while ((line = reader.readLine()) != null) {

                // Skip blank lines
                if (line.isBlank()) {
                    continue;
                }

                // Skip the CSV header
                if (line.trim().equalsIgnoreCase("id,name")) {
                    continue;
                }

                String[] parts = line.split(",", -1);

                if (parts.length != 2
                        || parts[0].isBlank()
                        || parts[1].isBlank()) {
                    throw new IOException("Invalid CSV row: " + line);
                }

                int id;
                try {
                    id = Integer.parseInt(parts[0].trim());
                } catch (NumberFormatException e) {
                    throw new IOException(
                            "Invalid employee ID: " + line, e);
                }

                String name = parts[1].trim();

                repository.save(new Employee(id, name));
            }
        }

        System.out.println("Seeded employees:");

        for (Employee employee : repository.findAll()) {
            System.out.println(employee);
        }

        System.out.println("Total employees: "
                + repository.findAll().size());
    }
}
