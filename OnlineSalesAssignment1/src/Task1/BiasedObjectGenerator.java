package Task1;

import java.util.List;
import java.util.Random;

/**
 * The constructor is taking List as input because it will be easier to take any number of input
 * Therefore the same call can be used for creating any biased object i.e. coin, custom side dice, etc
 * <p>
 * We are maintaining a table of size 100 representing each percent.This table is filled during the instation of the object.
 * This helps by reducing the time complexity of generation of outcome to constant time and space constant space.
 * <p>
 * Some of the basic validations are done before creating the object.
 */
public class BiasedObjectGenerator {
    private int[] lookupTable;
    private Random random;

    /**
     * Constructor to initialize the biased event generator with probabilities.
     *
     * @param probabilityList List of probabilities where each entry is a pair [outcome, probability].
     * @throws IllegalArgumentException If the probability list is empty, contains invalid values, or has an invalid format.
     */
    /* We are maintaining a table of size 100 representing each percent
     * This table is filled during the instation of the object.
     * This helps by reducing the time complexity of generation of outcome to constant time and space constant space */
    public BiasedObjectGenerator(List<List<Integer>> probabilityList) {
        // Validating the probability list
        if (probabilityList == null || probabilityList.isEmpty()) {
            throw new IllegalArgumentException("Probability list cannot be null or empty");
        }

        int totalProbability = probabilityList.stream().mapToInt(prob -> prob.get(1)).sum();
        if (totalProbability != 100) {
            throw new IllegalArgumentException("No valid probabilities provided");
        }

        lookupTable = new int[totalProbability];
        int index = 0;
        for (List<Integer> probability : probabilityList) {
            int outcome = probability.get(0);
            int probabilityValue = probability.get(1);
            for (int i = 0; i < probabilityValue; i++) {
                lookupTable[index++] = outcome;
            }
        }
        this.random = new Random();
    }


    /**
     * Generates a biased outcome based on the initialized probabilities.
     *
     * @return The generated outcome.
     */
    public Integer getOutcome() {
        int randomIndex = random.nextInt(lookupTable.length);
        return lookupTable[randomIndex];
    }
}