class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] lastSeen = new int[32]; // To track the last seen position of each bit

        // Initialize with -1 so we can take max correctly
        Arrays.fill(lastSeen, -1);

        for (int i = n - 1; i >= 0; i--) {
            // Update the last seen positions for the bits set in nums[i]
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    lastSeen[b] = i;
                }
            }

            // Find farthest position needed to cover all bits
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                if (lastSeen[b] != -1) {
                    maxReach = Math.max(maxReach, lastSeen[b]);
                }
            }

            result[i] = maxReach - i + 1; // Length = (end - start + 1)
        }

        return result;
    }
}
