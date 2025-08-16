class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // int count = 0;

        // for (int num : nums) {
        //     if (map.containsKey(num)) {
        //         count += map.get(num); // All previous occurrences are valid good pairs
        //     }
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // return count;

        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }

        return count;
    }
}
