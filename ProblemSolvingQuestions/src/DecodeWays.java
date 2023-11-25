public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("11106"));
        // answer is 2
    }
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            int one = Integer.valueOf(s.substring(i, i + 1));
            int two = Integer.valueOf(s.substring(i - 1, i + 1));

            if (one > 0) {
                dp[i] += dp[i - 1];
            }

            if (two >= 10 && two <= 26) {
                dp[i] += (i >= 2 ? dp[i - 2] : 1);
            }
        }

        return dp[s.length() - 1];
    }
}
