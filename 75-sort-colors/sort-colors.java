class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, m = 0, h = n - 1;

        while(m <= h) {
            if(nums[m] == 0) {
                swap(nums, m, l);
                m++;
                l++;
            } else if(nums[m] == 2) {
                swap(nums, m, h);
                // m++; // // DO NOT increment m here, because the swapped element from h might need recheck
                h--;
            } else {
                m++;
            }
        }

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
}