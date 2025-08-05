class Solution {

    private int findmax(int piles[]) {
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;

        for(int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }

        return maxi;
    }

    private int calculateTotalHours(int[] piles, int hourly) {
        int n = piles.length;
        int totalH = 0;

        for(int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findmax(piles); 
        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int totalH = calculateTotalHours(piles, mid);
            if(totalH <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}