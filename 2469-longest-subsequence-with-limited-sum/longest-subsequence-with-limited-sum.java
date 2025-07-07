import java.util.*; // not solved yet .. 


class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Build prefix sums
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        int m = queries.length;
        int[] ans = new int[m];
        
        // Answer each query with binary search on prefix sums
        for (int i = 0; i < m; i++) {
            int q = queries[i];
            int idx = upperBound(prefix, q);
            ans[i] = idx; // idx gives count of elements ≤ q
        }
        return ans;
    }
    
    // Finds the first index i such that prefix[i] > target,
    // which is effectively the number of elements ≤ target.
    private int upperBound(int[] prefix, int target) {
        int lo = 0, hi = prefix.length; // hi is exclusive
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefix[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
