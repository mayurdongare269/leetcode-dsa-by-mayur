class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        
        // Step 1: Find the maximum OR possible
        for (int num : nums) {
            maxOR |= num;
        }

        // Step 2: Count subsets with OR == maxOR using recursion
        return countSubsets(nums, 0, 0, maxOR);
    }

    private int countSubsets(int[] nums, int index, int currentOR, int maxOR) {
        if (index == nums.length) {
            return currentOR == maxOR ? 1 : 0;
        }

        // Include nums[index]
        int include = countSubsets(nums, index + 1, currentOR | nums[index], maxOR);

        // Exclude nums[index]
        int exclude = countSubsets(nums, index + 1, currentOR, maxOR);

        return include + exclude;
    }
}
