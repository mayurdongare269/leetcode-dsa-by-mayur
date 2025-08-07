class Solution {

    private int getMax(int nums[]) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }


    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = getMax(nums);

        // int sum = 0;
        int result = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0; // ✅ Reset sum for each divisor attempt

            for(int num : nums) {
                sum += (num + mid - 1)/mid;  // this is ceil(num / mid)
            }

            // sum += ceil(nums[mid] / mid);

            if(sum > threshold) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }
}