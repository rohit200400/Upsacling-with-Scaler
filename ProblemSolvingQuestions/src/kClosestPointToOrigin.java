import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class kClosestPointToOrigin {
    public static void main(String[] args) {
        kClosestPointToOrigin solution = new kClosestPointToOrigin();

        // Example points
        int[][] points = {{1, 3}, {-2, 2}, {5, -1}};
        int k = 2;

        // Call the kClosest method
        int[][] result = solution.kClosest(points, k);

        // Print the result
        System.out.println("Top " + k + " closest points to the origin:");
        for (int[] point : result) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        TreeMap<int[], Double> map = new TreeMap<>(Comparator
                .comparingDouble(point -> Math.sqrt(Math.pow((double) point[0], 2) + Math.pow((double) point[1], 2))));

        for (int[] point : points) {
            Double distance = Math.sqrt(Math.pow((double) point[0], 2) + Math.pow((double) point[1], 2));
            map.put(point, distance);
        }

        // Retrieve the top k entries from the TreeMap
        int[][] result = new int[k][2];
        int count = 0;

        for (Map.Entry<int[], Double> entry : map.entrySet()) {
            if (count == k) {
                break;
            }
            result[count++] = entry.getKey();
        }
        return result;
    }
}
