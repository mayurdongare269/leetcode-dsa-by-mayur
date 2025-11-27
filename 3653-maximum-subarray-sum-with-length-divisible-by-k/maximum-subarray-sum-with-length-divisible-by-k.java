class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        // prefix sum
        long[] pref = new long[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }

        long result = Long.MIN_VALUE;

        // Try each possible starting offset from 0..k-1
        for (int start = 0; start < k; start++) {
            long currSum = 0;
            int i = start;

            // Move in steps of size k
            while (i + k - 1 < n) {
                int j = i + k - 1;

                long subSum = pref[j] - (i > 0 ? pref[i - 1] : 0);

                // Standard Kadane for block sums
                currSum = Math.max(subSum, currSum + subSum);
                result = Math.max(result, currSum);

                i += k;
            }
        }

        return result;
    }
}
