class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;

        int delete = 0;
        int maxCount = 0;

        for(int j = 0; j < n; j++) {
            if(nums[j] == 0) {
                delete++;
            }

            while(delete > 1) {
                if(nums[i] == 0 ) {
                    delete--;
                }
                i++;
            }

            maxCount = Math.max(maxCount, j - i);
        }

        return maxCount;

        
    }
}