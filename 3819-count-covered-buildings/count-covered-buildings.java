class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;

        int[] minY = new int[n + 1];
        int[] maxY = new int[n + 1];
        int[] minX = new int[n + 1];
        int[] maxX = new int[n + 1];

        // Initialize bounds
        for (int i = 1; i <= n; i++) {
            minY[i] = minX[i] = Integer.MAX_VALUE;
            maxY[i] = maxX[i] = Integer.MIN_VALUE;
        }

        // Fill bounds for rows and columns
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            minY[x] = Math.min(minY[x], y);
            maxY[x] = Math.max(maxY[x], y);

            minX[y] = Math.min(minX[y], x);
            maxX[y] = Math.max(maxX[y], x);
        }

        int ans = 0;

        // Check each building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            if (minY[x] < y && y < maxY[x] && minX[y] < x && x < maxX[y]) {
                ans++;
            }
        }

        return ans;
    }
}
