
import java.util.*;

public class CollectionPerformance {
    static final int SIZE = 10000;
    static final int REPEATS = 5;
    static volatile long result;

    public static void main(String[] args) {
        System.out.println("Collection Performance Test");
        System.out.println("Elements: " + SIZE);

        test("ArrayList insertion", true, false);
        test("LinkedList insertion", false, false);
        test("ArrayList get(i)", true, true);
        test("LinkedList get(i)", false, true);
    }

   
static void test(String name, boolean array, boolean access) {
    long total = 0;

    for (int r = 0; r < REPEATS; r++) {
        List<Integer> list = array
                ? new ArrayList<>()
                : new LinkedList<>();

        if (access) {
            for (int i = 0; i < SIZE; i++)
                list.add(i);
        }

        long start = System.nanoTime();

        if (access) {
            long sum = 0;
            for (int i = 0; i < SIZE; i++)
                sum += list.get(i);
            result = sum;
        } else {
            for (int i = 0; i < SIZE; i++)
                list.add(i);
            result = list.size();
        }

        total += System.nanoTime() - start;
    }

    double averageMs = total / (double) REPEATS / 1_000_000;
    System.out.printf("%-25s %.3f ms%n", name, averageMs);
}

}
