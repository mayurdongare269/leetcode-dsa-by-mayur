class Solution {
    public long maximumProfit(int[] prices, int k) {
        long NEG = Long.MIN_VALUE / 4;

        long[][] dp = new long[k + 1][3];

        for (int t = 0; t <= k; t++) {
            dp[t][0] = 0;      // free
            dp[t][1] = NEG;   // holding
            dp[t][2] = NEG;   // short
        }

        for (int price : prices) {
            long[][] next = new long[k + 1][3];

            for (int t = 0; t <= k; t++) {
                // stay free
                next[t][0] = dp[t][0];

                // buy (free -> holding)
                next[t][1] = Math.max(dp[t][1], dp[t][0] - price);

                // short sell (free -> short)
                next[t][2] = Math.max(dp[t][2], dp[t][0] + price);

                // sell (holding -> free, completes transaction)
                if (t > 0 && dp[t - 1][1] != NEG) {
                    next[t][0] = Math.max(next[t][0], dp[t - 1][1] + price);
                }

                // buy back (short -> free, completes transaction)
                if (t > 0 && dp[t - 1][2] != NEG) {
                    next[t][0] = Math.max(next[t][0], dp[t - 1][2] - price);
                }
            }
            dp = next;
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]);
        }
        return ans;
    }
}
