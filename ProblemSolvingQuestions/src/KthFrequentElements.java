import java.util.*;

public class KthFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        KthFrequentElements solution = new KthFrequentElements();
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public int[] topKFrequent(int[] nums, int k) {

        // counting the occurrence of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums
        ) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Comparator to compare values of the entries
        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                // Compare values of the entries
                return entry2.getValue().compareTo(entry1.getValue());
            }
        };
       Comparator<Map.Entry<Integer, Integer>> valueComparator2 = Map.Entry.comparingByValue(Collections.reverseOrder());
//            @Override
//            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
//                // Compare values of the entries
//                return entry2.getValue().compareTo(entry1.getValue());
//            }
//        };
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(valueComparator2);

        // Adding the Entry in the Priority queue
        for (Map.Entry entry : map.entrySet()
        ) {
            heap.add(entry);
        }

        // Formatting the output
        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = heap.poll().getKey();
        }
        return output;
    }
}
