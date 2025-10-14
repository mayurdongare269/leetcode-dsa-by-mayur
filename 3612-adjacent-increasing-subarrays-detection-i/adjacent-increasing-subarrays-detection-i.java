class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for(int i = 0; i + 2*k <= n; i++) {
            if(isInc(nums, i, i+k) && isInc(nums, i+k, i+2*k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInc(List<Integer> nums, int start, int end) {
        for(int i = start; i <end - 1; i++) {
            if(nums.get(i) >= nums.get(i+1)) {
                return false;
            }
        }

        return true;
    }
}