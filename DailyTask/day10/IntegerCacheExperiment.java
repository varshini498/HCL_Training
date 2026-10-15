
public class IntegerCacheExperiment {

    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;

        Integer x = 200;
        Integer y = 200;

        System.out.println("100 using == : " + (a == b));
        System.out.println("200 using == : " + (x == y));

        System.out.println("100 using equals(): " + a.equals(b));
        System.out.println("200 using equals(): " + x.equals(y));
    }
}
