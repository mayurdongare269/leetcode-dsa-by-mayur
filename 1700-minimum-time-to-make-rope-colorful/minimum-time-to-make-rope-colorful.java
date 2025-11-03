class Solution {//done
    public int minCost(String colors, int[] neededTime) {
        int totTime = 0;
        int n = colors.length();

        for(int i = 1; i < n; i++) {
            if(colors.charAt(i) == colors.charAt(i - 1)) {
                // to return min time
                totTime += Math.min(neededTime[i], neededTime[i - 1]);

                // to remove prev small val and keep big one for next comparisions
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }

        return totTime;


    }
}