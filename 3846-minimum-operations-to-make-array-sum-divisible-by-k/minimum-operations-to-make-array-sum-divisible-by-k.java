class Solution {
    public int minOperations(int[] nums, int k) {
        //here the reminer is ans
        int sum = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int rem = sum % k;
        return rem == 0 ? 0 : rem;

        
    }
}