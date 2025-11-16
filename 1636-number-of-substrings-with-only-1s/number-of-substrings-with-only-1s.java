class Solution {
    public int numSub(String s) {
        long count = 0;
        long curr = 0;
        long mod = 1000000007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                curr++;                // extend run of 1s
                count = (count + curr) % mod;
            } else {
                curr = 0;             // reset on zero
            }
        }

        return (int) count;
    }
}
