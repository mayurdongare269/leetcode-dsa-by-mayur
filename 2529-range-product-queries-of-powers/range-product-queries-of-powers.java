class Solution { /// copoyyyyyyyyyes
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;
        
        // Step 1: Extract powers of 2 from n (binary representation)
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }
        
        // Step 2: Compute prefix product array
        int m = powers.size();
        long[] prefix = new long[m + 1];
        prefix[0] = 1;
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = (prefix[i] * powers.get(i)) % MOD;
        }
        
        // Step 3: Answer each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long num = prefix[r + 1];
            long den = prefix[l];
            // Modular inverse using Fermat's little theorem
            long inv = powMod(den, MOD - 2, MOD);
            result[i] = (int)((num * inv) % MOD);
        }
        
        return result;
    }
    
    private long powMod(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
