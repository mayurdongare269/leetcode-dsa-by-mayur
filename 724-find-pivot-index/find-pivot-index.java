class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Iterate to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i; // Found pivot
            }
            leftSum += nums[i];
        }

        return -1; // No pivot found
    }
}
