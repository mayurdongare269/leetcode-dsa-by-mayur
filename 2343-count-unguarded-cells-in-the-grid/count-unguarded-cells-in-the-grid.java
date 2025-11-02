class Solution { // notsssslvd
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // 1 → guard, 2 → wall
        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = 2;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // down, up, right, left

        for (int[] g : guards) {
            int r = g[0], c = g[1];

            // For all 4 directions
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                while (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 1 && grid[nr][nc] != 2) {
                    // Only mark empty cells (0) as guarded (3)
                    if (grid[nr][nc] == 0) grid[nr][nc] = 3;
                    nr += d[0];
                    nc += d[1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        return count;
    }
}
