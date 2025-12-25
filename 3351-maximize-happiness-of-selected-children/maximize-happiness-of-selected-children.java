class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;

        for(int i = 0; i < k; i++) {
            int val = happiness[happiness.length - 1 - i] - i;
            if(val > 0) {
                ans += val;
            }
        }

        return ans;
    }
}