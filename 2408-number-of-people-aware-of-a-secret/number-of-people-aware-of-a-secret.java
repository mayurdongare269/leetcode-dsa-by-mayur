class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1]; // dp[i] = people who learn on day i
        dp[1] = 1; // Day 1 → 1 person learns

        long sharers = 0; // active sharers
        for (int day = 2; day <= n; day++) {
            // People who start sharing today (delay days ago)
            if (day - delay >= 1) {
                sharers = (sharers + dp[day - delay]) % MOD;
            }
            // People who forget today (forget days ago)
            if (day - forget >= 1) {
                sharers = (sharers - dp[day - forget] + MOD) % MOD;
            }
            // All sharers share with new people today
            dp[day] = sharers;
        }

        // Count people who still remember on day n
        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                ans = (ans + dp[day]) % MOD;
            }
        }
        return (int) ans;
    }
}
