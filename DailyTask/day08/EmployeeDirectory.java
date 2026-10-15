
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

    
        public int compareTo(Employee e) {
            return Integer.compare(this.id, e.id);
        }

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


        System.out.println("=== EMPLOYEE LOOKUP ===");

        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee e : employees)
            employeeMap.put(e.id, e);

        System.out.println("Employee 103: " + employeeMap.get(103));
        System.out.println("Employee 999: " + employeeMap.get(999));


        System.out.println("\n=== DEPARTMENT FREQUENCY ===");

        Map<String, Integer> frequency = new LinkedHashMap<>();

        for (Employee e : employees)
            frequency.merge(e.department, 1, Integer::sum);

        System.out.println(frequency);
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

        System.out.println("\n=== SORT BY EMPLOYEE ID ===");

        List<Employee> byId = new ArrayList<>(employees);
        Collections.sort(byId);

        for (Employee e : byId)
            System.out.println(e);

        System.out.println("\n=== TOP 5 SALARIES ===");

        Comparator<Employee> salaryOrder =
            Comparator.comparingDouble((Employee e) -> e.salary)
                .reversed()
                .thenComparing(e -> e.name);

        employees.stream()
            .sorted(salaryOrder)
            .limit(5)
            .forEach(System.out::println);

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

        System.out.println("\n=== HASHCODE BUG DEMO ===");

        Set<EmployeeBug> buggySet = new HashSet<>();
        buggySet.add(new EmployeeBug(101));
        buggySet.add(new EmployeeBug(101));

        System.out.println("Buggy set size: " + buggySet.size()
                + " (often 2 because hashCode is missing)");

    
        Set<Employee> fixedSet = new HashSet<>();
        fixedSet.add(new Employee(101, "Arun", "HR", 45000));
        fixedSet.add(new Employee(101, "Arun", "HR", 45000));

        System.out.println("Fixed set size: " + fixedSet.size());
    }
}
