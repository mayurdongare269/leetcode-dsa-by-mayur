import java.util.*;
// coppyyyyyyyyy
class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double)c);
        return backtrack(nums);
    }

    private boolean backtrack(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        int n = nums.size();
        // Try every pair
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                List<Double> next = new ArrayList<>();
                // keep remaining numbers
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                // Try all 6 operations (order matters for - and /)
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (backtrack(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > 1e-6) results.add(a / b);
        if (Math.abs(a) > 1e-6) results.add(b / a);
        return results;
    }
}
