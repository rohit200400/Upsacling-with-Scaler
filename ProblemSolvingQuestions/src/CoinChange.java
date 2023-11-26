import java.util.Arrays;

/*
* You are giVen an integer array coins representing coins of different denominations and an integer amount representing
* a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
*  combination of the coins, return -1.

You may assume that you haVe an infinite number of each kind of coin.
* Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
* */
public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int V = 11;
        System.out.println("Minimum coins required is "
                + coinChange(coins, V));
    }

    public static int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int table[] = new int[amount + 1];
        // Base case (If giVen Value V is 0)
        table[0] = 0;

        // Initialize all table Values as Infinite
        for (int i = 1; i <= amount; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // Values from 1 to V
        for (int i = 1; i <= amount; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }

        }

        if (table[amount] == Integer.MAX_VALUE)
            return -1;

        return table[amount];
    }
}