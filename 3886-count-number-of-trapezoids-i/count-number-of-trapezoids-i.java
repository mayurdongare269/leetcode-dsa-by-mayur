class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        // 1. Count number of points for each y-coordinate
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        long sumComb = 0;
        long sumCombSq = 0;

        // 2. For each y-group compute C(cnt,2)
        for (int cnt : map.values()) {
            if (cnt >= 2) {
                long comb = (long) cnt * (cnt - 1) / 2;
                comb %= MOD;

                sumComb = (sumComb + comb) % MOD;
                sumCombSq = (sumCombSq + comb * comb % MOD) % MOD;
            }
        }

        // 3. Using formula: (sum^2 - sumsq)/2
        long total = (sumComb * sumComb % MOD - sumCombSq + MOD) % MOD;
        total = total * pow2Inverse() % MOD; // divide by 2 mod
        return (int) total;
    }

    // Modular inverse of 2 under MOD
    private long pow2Inverse() {
        return (MOD + 1) / 2; // since MOD is prime
    }
}
