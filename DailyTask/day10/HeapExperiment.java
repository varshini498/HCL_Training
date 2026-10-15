
import java.util.*;

public class HeapExperiment {

    public static void main(String[] args) {
        List<byte[]> memory = new ArrayList<>();
        long totalMB = 0;

        try {
            while (true) {
                byte[] block = new byte[1024 * 1024];
                memory.add(block);
                totalMB++;

                if (totalMB % 5 == 0) {
                    System.out.println(
                        "Allocated approximately "
                        + totalMB + " MB"
                    );
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError occurred!");
            System.out.println(
                "Retained blocks: " + memory.size()
            );
        }
    }
}
