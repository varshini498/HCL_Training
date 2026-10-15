
import java.util.ArrayList;
import java.util.List;

public class GCExperiment {

    public static void main(String[] args) {

        for (int round = 1; round <= 10; round++) {
            List<byte[]> data = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                data.add(new byte[1024 * 1024]);
            }

            System.out.println("Completed round " + round);

            // The local list becomes eligible for collection
            // after this iteration finishes.
        }

        System.out.println("Experiment completed.");
    }
}
