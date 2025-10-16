class Solution {///ss
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];  

        // Count occurrences of each remainder (handle negatives safely)
        for (int num : nums) {
            int r = ((num % value) + value) % value;
            count[r]++;
        }

        int mex = 0;
        while (true) {
            int r = mex % value;
            if (count[r] == 0) break;  
            count[r]--;  
            mex++;
        }
        return mex;
    }
}
