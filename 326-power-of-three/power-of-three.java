class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;

        while(n % 3 == 0) {
            n /= 3;
        }
        return n == 1;

        // 1162261467 is 3^19, the largest power of 3 in 32-bit int
        // return n > 0 && 1162261467 % n == 0;
    }
}