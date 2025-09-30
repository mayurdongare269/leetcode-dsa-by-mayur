class Solution {
    public int triangularSum(int[] nums) { // brute n2
        int n = nums.length;

        while(n > 1) {
            int[] newNum = new int[n-1];
            for(int i = 0; i < n - 1; i++) {
                newNum[i] = (nums[i] + nums[i+1]) % 10;

            }
            nums = newNum;
            n--;
        }

        return nums[0];
    }
}