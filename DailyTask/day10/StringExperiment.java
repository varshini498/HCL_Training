
public class StringExperiment {

    static final int COUNT = 20000;
    static volatile int result;

    public static void main(String[] args) {

        // String concatenation
        long start = System.nanoTime();
        String text = "";

        for (int i = 0; i < COUNT; i++) {
            text += "a";
        }

        long stringTime = System.nanoTime() - start;
        result = text.length();

        // StringBuilder
        start = System.nanoTime();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < COUNT; i++) {
            builder.append("a");
        }

        long builderTime = System.nanoTime() - start;
        result = builder.length();

        System.out.printf("String += : %.3f ms%n",
                stringTime / 1_000_000.0);

        System.out.printf("StringBuilder: %.3f ms%n",
                builderTime / 1_000_000.0);
    }
}
