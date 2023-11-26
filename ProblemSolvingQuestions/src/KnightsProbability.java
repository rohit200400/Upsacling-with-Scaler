import java.util.Arrays;

public class KnightsProbability {
    public static void main(String[] args) {
        System.out.println(knightProbability(10, 13, 5, 3));
        // Answer is : 0.11734
    }

    public static double knightProbabilityRec(int i, int j, int k, int n, double[][][] dp) {
        if (i < 0 || j < 0 || i >= n || j >= n) return 0;
        if (k == 0) return 1;
        if (dp[i][j][k] != -1) return dp[i][j][k];
        double one = 0.125 * knightProbabilityRec(i + 1, j - 2, k - 1, n, dp);
        double two = 0.125 * knightProbabilityRec(i - 1, j - 2, k - 1, n, dp);
        double three = 0.125 * knightProbabilityRec(i - 2, j - 1, k - 1, n, dp);
        double four = 0.125 * knightProbabilityRec(i - 2, j + 1, k - 1, n, dp);
        double five = 0.125 * knightProbabilityRec(i - 1, j + 2, k - 1, n, dp);
        double six = 0.125 * knightProbabilityRec(i + 1, j + 2, k - 1, n, dp);
        double seven = 0.125 * knightProbabilityRec(i + 2, j - 1, k - 1, n, dp);
        double eight = 0.125 * knightProbabilityRec(i + 2, j + 1, k - 1, n, dp);
        return dp[i][j][k] = one + two + three + four + five + six + seven + eight;
    }

    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n + 1][n + 1][k + 1];
        for (double[][] nums : dp) {
            for (double[] arr : nums) Arrays.fill(arr, -1.0);
        }
        return knightProbabilityRec(row, column, k, n, dp);
    }


//     static int[][] moves = new int[][]{
//             {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
//             {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
//     };

//     public double knightProbability(int n, int k, int row, int column) {
//         BigDecimal[][] curr = new BigDecimal[n][n];
//         BigDecimal[][] next = new BigDecimal[n][n];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 curr[i][j] = BigDecimal.ZERO;
//                 next[i][j] = BigDecimal.ZERO;
//             }
//         }

//         curr[row][column] = BigDecimal.ONE;

//         for (int m = 0; m < k; m++) {
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     if (!curr[i][j].equals(BigDecimal.ZERO)) {
//                         for (int[] move : moves) {
//                             int newRow = i + move[0];
//                             int newColumn = j + move[1];
//                             if (isValid(n, newRow, newColumn)) {
//                                 next[newRow][newColumn] = next[newRow][newColumn].add(curr[i][j].divide(BigDecimal.valueOf(8.0)));
//                             }
//                         }
//                     }
//                 }
//             }
//             curr = next;
//             next = new BigDecimal[n][n];
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     next[i][j] = BigDecimal.ZERO;
//                 }
//             }
//         }

//         BigDecimal ans = BigDecimal.ZERO;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 ans = ans.add(curr[i][j]);
//             }
//         }

//         return ans.doubleValue();
//     }

    //     public boolean isValid(int n, int row, int column) {
//         return row >= 0 && column >= 0 && row < n && column < n;
//     }
// }

}

