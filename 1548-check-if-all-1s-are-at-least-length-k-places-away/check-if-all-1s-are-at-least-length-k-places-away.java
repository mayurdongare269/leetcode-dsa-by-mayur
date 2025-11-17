class Solution { // done 6 min
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;  // no previous 1 yet

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i;
            }
        }

        return true;
    }
}