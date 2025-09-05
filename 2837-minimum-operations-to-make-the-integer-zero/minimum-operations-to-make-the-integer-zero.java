class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long val = (long) num1 - (long) k * num2; // use long to avoid overflow
            if (val < k) continue; // must be >= k to split into k powers of 2
            if (Long.bitCount(val) <= k) return k; // valid representation
        }
        return -1;
    }
}
