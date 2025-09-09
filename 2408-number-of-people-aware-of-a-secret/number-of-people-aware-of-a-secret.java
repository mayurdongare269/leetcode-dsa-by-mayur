


// class Solution { //TLE.......(●'◡'●)
//     private static final int MOD = 1_000_000_007;

//     // Recursive function: number of people who learn the secret on "day"
//     private int solve(int day, int delay, int forget) {
//         if (day == 1) return 1; // first person learns on day 1

//         long result = 0;
//         for (int prev = day - forget + 1; prev <= day - delay; prev++) {
//             if (prev > 0) {
//                 result = (result + solve(prev, delay, forget)) % MOD;
//             }
//         }
//         return (int) result;
//     }

//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         long total = 0;
//         for (int day = n - forget + 1; day <= n; day++) {
//             if (day > 0) {
//                 total = (total + solve(day, delay, forget)) % MOD;
//             }
//         }
//         return (int) total;
//     }
// }



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


