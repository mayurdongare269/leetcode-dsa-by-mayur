class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Traverse all cells
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If empty cell found
                if (board[row][col] == '.') {
                    // Try digits from 1 to 9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number

                            // Recurse
                            if (solve(board)) return true;

                            // Backtrack if not valid
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid number found, must backtrack
                }
            }
        }
        return true; // Puzzle is solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        // Check 3x3 grid
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == num)
                    return false;
            }
        }

        return true;
    }
}
