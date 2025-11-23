class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        // Track smallest remainders
        int min1 = Integer.MAX_VALUE;       // smallest number % 3 == 1
        int min2 = Integer.MAX_VALUE;       // second smallest % 3 == 1
        int max1 = Integer.MAX_VALUE;       // smallest number % 3 == 2
        int max2 = Integer.MAX_VALUE;       // second smallest % 3 == 2

        for (int x : nums) {
            sum += x;

            if (x % 3 == 1) {
                if (x < min1) {
                    min2 = min1;
                    min1 = x;
                } else if (x < min2) {
                    min2 = x;
                }
            } else if (x % 3 == 2) {
                if (x < max1) {
                    max2 = max1;
                    max1 = x;
                } else if (x < max2) {
                    max2 = x;
                }
            }
        }

        int rem = sum % 3;

        if (rem == 0) return sum;

        if (rem == 1) {
            int opt1 = min1;                      // remove one %3==1
            int opt2 = (max1 == Integer.MAX_VALUE || max2 == Integer.MAX_VALUE)
                        ? Integer.MAX_VALUE
                        : max1 + max2;            // remove two %3==2
            return sum - Math.min(opt1, opt2);
        }

        if (rem == 2) {
            int opt1 = max1;                      // remove one %3==2
            int opt2 = (min1 == Integer.MAX_VALUE || min2 == Integer.MAX_VALUE)
                        ? Integer.MAX_VALUE
                        : min1 + min2;            // remove two %3==1
            return sum - Math.min(opt1, opt2);
        }

        return sum; // never reached
    }
}
