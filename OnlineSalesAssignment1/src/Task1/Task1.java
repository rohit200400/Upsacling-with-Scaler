package Task1;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        // Test Case 1: Biased coin with 35% head and 65% tail
        System.out.println("Test Case 1: Biased coin with 35% head and 65% tail");
        testCoinBias(List.of(List.of(1, 35), List.of(2, 65)));

        // Test Case 2: Biased dice with different probabilities for each side
        System.out.println("\nTest Case 2: Biased dice with different probabilities for each side");
        testDiceBias(List.of(List.of(1, 10), List.of(2, 30), List.of(3, 15),
                List.of(4, 15), List.of(5, 30), List.of(6, 0)));

        // Test Case 3: Biased dice with zero probability for all sides (expecting IllegalArgumentException)
        System.out.println("\nTest Case 3: Biased dice with zero probability for all sides");
        try {
            testDiceBias(List.of(List.of(1, 0), List.of(2, 0), List.of(3, 0), List.of(4, 0), List.of(5, 0), List.of(6, 0)));
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 3 Result: " + e.getMessage());
        }

        // Test Case 4: Biased coin with 100% head
        System.out.println("\nTest Case 4: Biased coin with 100% head");
        testCoinBias(List.of(List.of(1, 100), List.of(2, 0)));

        // Test Case 5: Biased coin with 0% head (expecting IllegalArgumentException)
        System.out.println("\nTest Case 5: Biased coin with 0% head");
        try {
            testCoinBias(List.of(List.of(1, 0), List.of(2, 100)));
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 5 Result: " + e.getMessage());
        }

        // Test Case 6: Biased coin with 50% head and 50% tail
        System.out.println("Test Case 5: Biased coin with 50% head and 50% tail");
        testCoinBias(List.of(List.of(1, 50), List.of(2, 50)));

        // Test Case 7: Biased dice with equal probabilities for each side
        System.out.println("\nTest Case 7: Biased dice with equal probabilities for each side");
        testDiceBias(List.of(List.of(1, 20), List.of(2, 20), List.of(3, 20),
                List.of(4, 20), List.of(5, 20)));

        // Test Case 8: Biased dice with one side having 100% probability
        System.out.println("\nTest Case 8: Biased dice with one side having 100% probability");
        testDiceBias(List.of(List.of(1, 0), List.of(2, 0), List.of(3, 0),
                List.of(4, 0), List.of(5, 0), List.of(6, 100)));

        // Test Case 9: Biased dice with small probabilities
        System.out.println("\nTest Case 9: Biased dice with small probabilities");
        testDiceBias(List.of(List.of(1, 1), List.of(2, 2), List.of(3, 3),
                List.of(4, 4), List.of(5, 5), List.of(6, 85)));

        // Test Case 10: Biased dice with only one side (expecting IllegalArgumentException)
        System.out.println("\nTest Case 10: Biased dice with only one side");
        try {
            testDiceBias(List.of(List.of(1, 100)));
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 5 Result: " + e.getMessage());
        }
    }

    /**
     * Helper method to test biased coin scenarios.
     *
     * @param probabilities List of probabilities for a biased coin.
     */
    private static void testCoinBias(List<List<Integer>> probabilities) {
        BiasedObjectGenerator coin = new BiasedObjectGenerator(probabilities);
        int head = 0;
        int tail = 0;
        for (int i = 0; i < 1000; i++) {
            if (coin.getOutcome() != 1) {
                tail++;
            } else {
                head++;
            }
        }
        System.out.println("Total head count = " + head);
        System.out.println("Total tail count = " + tail);
    }

    /**
     * Helper method to test biased dice scenarios.
     *
     * @param probabilities List of probabilities for a biased dice.
     */
    private static void testDiceBias(List<List<Integer>> probabilities) {
        BiasedObjectGenerator biasedDice = new BiasedObjectGenerator(probabilities);
        int[] sideOccurrence = new int[probabilities.size()];
        for (int i = 0; i < 1000; i++) {
            sideOccurrence[biasedDice.getOutcome() - 1]++;
        }
        for (int i = 0; i < sideOccurrence.length; i++) {
            System.out.println("Total occurrence of " + (i + 1) + " side is " + sideOccurrence[i]);
        }
    }
}