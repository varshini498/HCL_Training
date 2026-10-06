public class MonthlyUsageAnalyser {

    public static void main(String[] args) {

        final int MONTHS = 12;
        final int LOW_LIMIT = 150;
        final int HIGH_LIMIT = 250;

        int[] usage = {
            120, 150, 180, 200,
            220, 250, 280, 300,
            270, 230, 190, 160
        };

        long total = 0;
        int max = usage[0];
        int min = usage[0];

        for (int i = 0; i < MONTHS; i++) {

            total += usage[i];

            if (usage[i] > max) {
                max = usage[i];
            }

            if (usage[i] < min) {
                min = usage[i];
            }
        }

        double average = (double) total / MONTHS;

        char grade = average >= HIGH_LIMIT ? 'A'
                   : average >= LOW_LIMIT ? 'B'
                   : 'C';

        System.out.println("Total Usage: " + total);
        System.out.println("Average Usage: " + average);
        System.out.println("Maximum Usage: " + max);
        System.out.println("Minimum Usage: " + min);
        System.out.println("Grade: " + grade);
    }
}