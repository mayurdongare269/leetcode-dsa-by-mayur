class Solution {
    // Helper to compute F(n) = sum of f(x) for x=1..n
    private long F(long n) {
        if (n <= 0) return 0;
        long sum = 0;
        long base = 1;
        int k = 1;
        while (base <= n) {
            long next = base * 4;
            long high = Math.min(n, next - 1);
            long count = high - base + 1;
            sum += count * k;
            base = next;
            k++;
        }
        return sum;
    }

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long total = F(r) - F(l - 1);
            ans += (total + 1) / 2; // ceil(total/2)
        }
        return ans;
    }
}
