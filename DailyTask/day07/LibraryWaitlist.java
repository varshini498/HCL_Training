import java.util.*;

public class LibraryWaitlist {

    static class Book {
        String title;
        boolean overdue;

        Book(String title, boolean overdue) {
            this.title = title;
            this.overdue = overdue;
        }

        public String toString() {
            return title + (overdue ? " (OVERDUE)" : "");
        }
    }

    static class Request {
        String studentId, bookTitle;

        Request(String studentId, String bookTitle) {
            this.studentId = studentId;
            this.bookTitle = bookTitle;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Request)) return false;
            Request r = (Request) obj;
            return studentId.equals(r.studentId)
                    && bookTitle.equalsIgnoreCase(r.bookTitle);
        }

        public int hashCode() {
            return Objects.hash(
                    studentId, bookTitle.toLowerCase()
            );
        }

        public String toString() {
            return studentId + " -> " + bookTitle;
        }
    }

    static class PriorityRequest {
        String name;
        boolean faculty;
        int order;

        PriorityRequest(String name, boolean faculty, int order) {
            this.name = name;
            this.faculty = faculty;
            this.order = order;
        }

        public String toString() {
            return name + (faculty ? " (Faculty)" : " (Student)");
        }
    }

    public static void main(String[] args) {

        // 1. ArrayList: catalogue allows duplicates and preserves order.
        System.out.println("=== BOOK CATALOGUE ===");

        List<Book> catalogue = new ArrayList<>();
        catalogue.add(new Book("Java", false));
        catalogue.add(new Book("Python", false));
        catalogue.add(new Book("SQL", true));
        catalogue.add(new Book("Java", false));

        for (Book b : catalogue)
            System.out.println(b);

        System.out.println("Catalogue size: " + catalogue.size());
        System.out.println("Book at index 1: " +
                catalogue.get(1).title);

        // 2. LinkedHashSet: prevents duplicate requests.
        System.out.println("\n=== UNIQUE WAITLIST ===");

        Set<Request> requests = new LinkedHashSet<>();
        requests.add(new Request("S101", "Java"));
        requests.add(new Request("S102", "Python"));
        requests.add(new Request("S101", "Java"));
        requests.add(new Request("S103", "Java"));

        for (Request r : requests)
            System.out.println(r);

        System.out.println("Unique requests: " + requests.size());

        // HashSet: unique IDs, with no guaranteed iteration order.
        Set<String> ids = new HashSet<>(
                Arrays.asList("S101", "S102", "S101")
        );
        System.out.println("\nUnique student IDs: " + ids);

        // 3. ArrayDeque: regular FIFO waitlist.
        System.out.println("\n=== REGULAR WAITLIST ===");

        Queue<String> waitlist = new ArrayDeque<>();
        waitlist.offer("S201");
        waitlist.offer("S202");
        waitlist.offer("S203");

        System.out.println("Waiting: " + waitlist);
        System.out.println("Served: " + waitlist.poll());
        System.out.println("Remaining: " + waitlist);

        // 4. PriorityQueue: faculty requests first.
        System.out.println("\n=== PRIORITY WAITLIST ===");

        Comparator<PriorityRequest> rule =
                Comparator.comparing((PriorityRequest r) ->
                        !r.faculty)
                .thenComparingInt(r -> r.order);

        PriorityQueue<PriorityRequest> priority =
                new PriorityQueue<>(rule);

        priority.offer(new PriorityRequest("Student A", false, 1));
        priority.offer(new PriorityRequest("Faculty B", true, 2));
        priority.offer(new PriorityRequest("Student C", false, 3));
        priority.offer(new PriorityRequest("Faculty D", true, 4));

        while (!priority.isEmpty())
            System.out.println("Served: " + priority.poll());

        // 5. Iterator.remove(): remove overdue books safely.
        System.out.println("\n=== REMOVE OVERDUE BOOKS ===");

        List<Book> books = new ArrayList<>(catalogue);
        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {
            if (it.next().overdue)
                it.remove();
        }

        System.out.println("Remaining books: " + books);

        // 6. ListIterator: forward, backward and update.
        System.out.println("\n=== LISTITERATOR ===");

        List<String> subjects =
                new ArrayList<>(Arrays.asList(
                        "Java", "SQL", "Python"
                ));

        ListIterator<String> li = subjects.listIterator();

        System.out.print("Forward: ");
        while (li.hasNext())
            System.out.print(li.next() + " ");

        System.out.print("\nBackward: ");
        while (li.hasPrevious())
            System.out.print(li.previous() + " ");

        ListIterator<String> edit = subjects.listIterator();
        edit.next();
        edit.set("Core Java");

        System.out.println("\nUpdated list: " + subjects);

        // 7. Demonstrate unsafe modification and safe removal.
        System.out.println("\n=== MODIFICATION DEMO ===");

        List<String> items = new ArrayList<>(
                Arrays.asList("Java", "Overdue", "SQL")
        );

        try {
            for (String item : items) {
                if (item.equals("Overdue"))
                    items.remove(item); // intentionally unsafe
            }
            System.out.println(
                    "No exception observed in this run."
            );
        } catch (ConcurrentModificationException e) {
            System.out.println(
                    "ConcurrentModificationException caught."
            );
        }

        // Safe alternative.
        Iterator<String> safe = items.iterator();
        while (safe.hasNext()) {
            if (safe.next().equals("Overdue"))
                safe.remove();
        }

        System.out.println("After safe removal: " + items);
    }
}