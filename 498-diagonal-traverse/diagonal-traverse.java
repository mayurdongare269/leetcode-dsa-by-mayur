class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, dir = 1; // dir = 1 → up-right, dir = -1 → down-left
        int idx = 0;

        while (idx < m * n) {
            result[idx++] = mat[row][col];

            // Moving up-right
            if (dir == 1) {
                if (col == n - 1) { // last column
                    row++;
                    dir = -1;
                } else if (row == 0) { // first row
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            }
            // Moving down-left
            else {
                if (row == m - 1) { // last row
                    col++;
                    dir = 1;
                } else if (col == 0) { // first column
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
