class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> st = new HashSet<>();

        int i = 0, j = 0;
        int sum = 0;
        int result = 0;
        int n = nums.length;

        while(j < n) {
            if(!st.contains(nums[j])) {
                sum += nums[j];
                result = Math.max(sum, result);
                st.add(nums[j]);
                j++;
            } else {
                while(i < n && st.contains(nums[j])) {
                    sum -= nums[i];
                    st.remove(nums[i]);
                    i++;
                }
            }
        }

        return result;
    }
}