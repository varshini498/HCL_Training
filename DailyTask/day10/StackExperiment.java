
public class StackExperiment {

    static long calls = 0;

    static void recurse() {
        calls++;
        recurse();
    }

    public static void main(String[] args) {
        try {
            recurse();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError occurred.");
            System.out.println("Calls before error: " + calls);
        }
    }
}
