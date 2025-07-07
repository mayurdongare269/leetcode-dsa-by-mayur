class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Iterate to find the middle index
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i; // Found the leftmost middle index
            }
            leftSum += nums[i];
        }

        return -1; // No middle index found
    }
}
