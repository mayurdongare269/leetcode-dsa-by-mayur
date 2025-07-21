class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int start = 0, len = 0;

        for(int i = 0; i < nums.length; i++) { // i = end
             while (nums[i] - nums[start] > 1) {
                start++;
            }

            // Check if it's harmonious (diff == 1)
            if (nums[i] - nums[start] == 1) {
                len = Math.max(len, i - start + 1);
            }
        }

        return len;
    }
}