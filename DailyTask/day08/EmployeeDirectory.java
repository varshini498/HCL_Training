
import java.util.*;

public class EmployeeDirectory {

    static class Employee implements Comparable<Employee> {
        int id;
        String name, department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        // Natural sorting: employee ID in ascending order
        public int compareTo(Employee e) {
            return Integer.compare(this.id, e.id);
        }

        // Employees are equal when their IDs are equal
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Employee)) return false;
            Employee e = (Employee) obj;
            return id == e.id;
        }

        public int hashCode() {
            return Objects.hash(id);
        }

        public String toString() {
            return id + " | " + name + " | " + department
                    + " | Rs." + salary;
        }
    }

    // Demonstrates the bug: equals() without hashCode()
    static class EmployeeBug {
        int id;

        EmployeeBug(int id) {
            this.id = id;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof EmployeeBug)) return false;
            return id == ((EmployeeBug) obj).id;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(104, "Priya", "IT", 65000),
            new Employee(101, "Arun", "HR", 45000),
            new Employee(103, "Kumar", "IT", 80000),
            new Employee(102, "Divya", "Finance", 70000),
            new Employee(105, "Ravi", "HR", 50000),
            new Employee(106, "Meena", "Finance", 90000),
            new Employee(107, "Karthik", "IT", 75000)
        ));

        // 1. HashMap: employee lookup by ID
        System.out.println("=== EMPLOYEE LOOKUP ===");

        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee e : employees)
            employeeMap.put(e.id, e);

        System.out.println("Employee 103: " + employeeMap.get(103));
        System.out.println("Employee 999: " + employeeMap.get(999));

        // 2. LinkedHashMap + merge(): department frequency
        System.out.println("\n=== DEPARTMENT FREQUENCY ===");

        Map<String, Integer> frequency = new LinkedHashMap<>();

        for (Employee e : employees)
            frequency.merge(e.department, 1, Integer::sum);

        System.out.println(frequency);

        // 3. TreeMap: sorted department report
        System.out.println("\n=== DEPARTMENT REPORT ===");

        Map<String, List<Employee>> report = new TreeMap<>();

        for (Employee e : employees)
            report.computeIfAbsent(
                e.department, k -> new ArrayList<>()
            ).add(e);

        for (Map.Entry<String, List<Employee>> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Employee e : entry.getValue())
                System.out.println("  " + e);
        }

        // 4. Comparable: sort employees by ID
        System.out.println("\n=== SORT BY EMPLOYEE ID ===");

        List<Employee> byId = new ArrayList<>(employees);
        Collections.sort(byId);

        for (Employee e : byId)
            System.out.println(e);

        // 5. Comparator 1: salary descending, then name ascending
        System.out.println("\n=== TOP 5 SALARIES ===");

        Comparator<Employee> salaryOrder =
            Comparator.comparingDouble((Employee e) -> e.salary)
                .reversed()
                .thenComparing(e -> e.name);

        employees.stream()
            .sorted(salaryOrder)
            .limit(5)
            .forEach(System.out::println);

        // 6. Comparator 2: department, then salary descending
        System.out.println("\n=== DEPARTMENT AND SALARY ORDER ===");

        Comparator<Employee> departmentOrder =
            Comparator.comparing((Employee e) -> e.department)
                .thenComparing(
                    Comparator.comparingDouble(
                        (Employee e) -> e.salary
                    ).reversed()
                );

        employees.stream()
            .sorted(departmentOrder)
            .forEach(System.out::println);

        // 7. equals() / hashCode() contract bug
        System.out.println("\n=== HASHCODE BUG DEMO ===");

        Set<EmployeeBug> buggySet = new HashSet<>();
        buggySet.add(new EmployeeBug(101));
        buggySet.add(new EmployeeBug(101));

        System.out.println("Buggy set size: " + buggySet.size()
                + " (often 2 because hashCode is missing)");

        // Fixed Employee implements both equals() and hashCode()
        Set<Employee> fixedSet = new HashSet<>();
        fixedSet.add(new Employee(101, "Arun", "HR", 45000));
        fixedSet.add(new Employee(101, "Arun", "HR", 45000));

        System.out.println("Fixed set size: " + fixedSet.size());
    }
}
