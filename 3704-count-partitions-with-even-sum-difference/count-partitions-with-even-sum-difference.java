class Solution {// done ,.... two pass solution ...
    public int countPartitions(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        int totSum = 0;
        for(int i = 0; i < n; i++) {
            totSum += nums[i];
        }

        for(int i = 0; i <= n-2; i++) {
            int prev = sumf(nums, 0, i);
            int next = totSum - prev;
            int ans = prev - next;
            if(ans % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public int sumf(int[] arr, int s, int e) {
        int sum = 0;
        for(int i = s; i <= e; i++) {
            sum += arr[i];
        }

        return sum;
    }
}