class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            // Count frequency of elements in current subarray
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Create list of (num, freq)
            List<int[]> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                pairs.add(new int[]{entry.getKey(), entry.getValue()});
            }

            // Sort: 1️⃣ by frequency desc, 2️⃣ by value desc
            pairs.sort((a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            // Sum top x frequent numbers (counting all occurrences)
            int sum = 0;
            int count = 0;
            for (int[] p : pairs) {
                if (count == x) break;
                sum += p[0] * p[1];
                count++;
            }

            ans[i] = sum;
        }

        return ans;
    }

}