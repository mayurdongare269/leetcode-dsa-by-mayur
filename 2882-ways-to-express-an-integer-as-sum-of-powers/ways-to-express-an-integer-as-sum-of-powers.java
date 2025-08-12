class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new Integer[n + 1][n + 1];
        return dfs(n, 1, x);
    }

    private int dfs(int n, int curr, int x) {
        if (n == 0) return 1; // found valid combination
        if (curr > n) return 0; // can't use larger numbers
        if (dp[n][curr] != null) return dp[n][curr];

        int pow = (int) Math.pow(curr, x);
        if (pow > n) {
            return dp[n][curr] = 0; // no more candidates
        }

        // choose curr or skip curr
        int take = dfs(n - pow, curr + 1, x) % MOD;
        int skip = dfs(n, curr + 1, x) % MOD;

        dp[n][curr] = (take + skip) % MOD;
        return dp[n][curr];
    }
}
