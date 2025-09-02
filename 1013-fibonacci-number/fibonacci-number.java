class Solution {
    public int fib(int n) {
        if (n == 0) return 0;  // base case
        if (n == 1) return 1;  // base case

        return fib(n - 1) + fib(n - 2);
    }
}