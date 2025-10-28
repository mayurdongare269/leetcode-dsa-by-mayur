class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        // 
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                if(simulate(nums, i, -1)) count++;
                if(simulate(nums, i, 1)) count++;
            }
        }

        return count;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        int curr = start;

        while(curr >= 0 && curr < n) {
            if(temp[curr] == 0) {
                curr += dir;
            } else {
                temp[curr]--;
                dir *= -1;
                curr += dir;
            }
        }

        // for(int num : temp) {
        //     if(num != 0) return false;
        // }

        for(int i = 0; i < temp.length; i++) {
            if(temp[i] != 0) return false;
        }

        return true;
    }
}