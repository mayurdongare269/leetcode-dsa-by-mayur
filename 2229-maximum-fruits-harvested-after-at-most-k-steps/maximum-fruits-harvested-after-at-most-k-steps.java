class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, total = 0, maxFruits = 0;

        // Slide window [left, right] to include valid fruits in reach
        for (int right = 0; right < fruits.length; ++right) {
            total += fruits[right][1];

            // Shrink window from left until steps > k
            while (left <= right && !isReachable(fruits[left][0], fruits[right][0], startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    // Helper: check if it's reachable within k steps (either left-first or right-first)
    private boolean isReachable(int leftPos, int rightPos, int startPos, int k) {
        int leftCost = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int rightCost = Math.abs(startPos - rightPos) + (rightPos - leftPos);
        return Math.min(leftCost, rightCost) <= k;
    }
}
