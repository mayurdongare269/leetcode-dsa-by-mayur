class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than the rightmost, min is in right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // Else, the min is at mid or in the left half
            else {
                high = mid;
            }
        }

        // At the end of loop, low == high and pointing to the smallest element
        return nums[low];
    }
}
