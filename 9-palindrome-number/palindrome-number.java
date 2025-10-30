class Solution {
    public boolean isPalindrome(int x) {
        int rem = 0;
        int n = x;
        int rev = 0;

        if(n < 0) {
            return false;
        }

        while(x != 0) {
            rem = x % 10;

            

            rev = rev*10 + rem;
            x/=10;
        }

        if(rev == n) {
            return true;
        }

        return false;
    }
}