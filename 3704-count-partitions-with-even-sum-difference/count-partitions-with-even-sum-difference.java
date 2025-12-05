class Solution {// done ,.... 
    public int countPartitions(int[] nums) {
        // one pass solution(need some maths...)
        int n = nums.length;
        int sum = sumf(nums, 0, n-1);
        if(sum % 2 == 0) {
            return n - 1;
        }
        return 0;



        // // two pass solution ...
        // int count = 0;
        // int n = nums.length;
        
        // int totSum = 0;
        // for(int i = 0; i < n; i++) {
        //     totSum += nums[i];
        // }

        // for(int i = 0; i <= n-2; i++) {
        //     int prev = sumf(nums, 0, i);
        //     int next = totSum - prev;
        //     int ans = prev - next;
        //     if(ans % 2 == 0) {
        //         count++;
        //     }
        // }

        // return count;
    }

    public int sumf(int[] arr, int s, int e) {
        int sum = 0;
        for(int i = s; i <= e; i++) {
            sum += arr[i];
        }

        return sum;
    }
}