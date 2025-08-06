class Solution {
    public static boolean possible(int bloomDay[], int day, int m, int k) {
        int n = bloomDay.length;
        int cnt = 0;
        int noB = 0;

        for(int i = 0; i < n; i++) {
            if(bloomDay[i] <= day) {
                cnt++;
            } else {
                noB += (cnt / k);
                cnt = 0;
            }
        }

        noB += (cnt / k);
        return noB >= m;
    }


    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < (long) m * k) {
            return -1;
        }

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }


        int low = mini;
        int high = maxi;
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans; // or u can simply return low no need to store in ans
    }
}