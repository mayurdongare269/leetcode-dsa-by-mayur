class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // You're on a descending slope, so the peak is on the left
                right = mid;
            } else {
                // You're on an ascending slope, so the peak is on the right
                left = mid + 1;
            }
        }

        // left == right is the index of a peak
        return left;
    }
}
