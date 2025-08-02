class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even so we can compare pairs (mid, mid+1)
            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                // Single element is on the right
                low = mid + 2;
            } else {
                // Single element is on the left or at mid
                high = mid;
            }
        }

        // When low == high, it's the single element
        return nums[low];
    }
}
