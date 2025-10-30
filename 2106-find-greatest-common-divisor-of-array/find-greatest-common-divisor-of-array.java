class Solution {
    public int findGCD(int[] nums) {
        // Arrays.sort(nums);

        // int a = nums[0];
        // int b = nums[nums.length - 1];

        // manually find min and max without sorting
        int min = nums[0];
        int max = nums[0];

        for(int num : nums) {
            if(num < min) min = num;
            if(num > max) max = num;
        }

        int ans = gcd(min, max);
        return ans;
    }

    //// Euclidean Algorithm
    private int gcd(int a, int b) {
        // if(b == 0) return a;
        // return gcd(b, a % b);
        while(b!=0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}