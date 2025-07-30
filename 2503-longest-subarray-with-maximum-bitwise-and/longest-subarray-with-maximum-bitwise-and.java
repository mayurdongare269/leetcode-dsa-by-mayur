class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for(int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int currLen = 0, maxLen = 0;

        for(int num : nums) {
            if(num == maxVal) {
                currLen++;
                maxLen = Math.max(currLen, maxLen);
            } else {
                currLen = 0;
            }
        }

        return maxLen;
    }
}