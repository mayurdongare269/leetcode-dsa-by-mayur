class Solution {//done 

///
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        int max = 200000;  // max possible value after doubling
        long[] before = new long[max + 1];
        long[] after = new long[max + 1];

        for (int x : nums) {
            after[x]++;
        }

        long ans = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            after[val]--;  // remove current j from "after"

            int target = val * 2;
            if (target <= max) {
                ans = (ans + (before[target] * after[target]) % MOD) % MOD;
            }

            before[val]++; // add current to "before"
        }

        return (int) ans;
    }
}
