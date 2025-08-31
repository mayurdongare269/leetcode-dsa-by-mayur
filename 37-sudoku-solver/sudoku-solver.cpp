class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }
    
private:
    bool solve(vector<vector<char>>& board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, r, c, d)) {
                            board[r][c] = d;
                            if (solve(board)) return true; // solved
                            board[r][c] = '.'; // backtrack
                        }
                    }
                    return false; // no valid digit found
                }
            }
        }
        return true; // all cells filled
    }
    
    bool isValid(vector<vector<char>>& board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == val) return false;
            // check column
            if (board[i][col] == val) return false;
            // check 3x3 box
            int boxRow = (row / 3) * 3 + i / 3;
            int boxCol = (col / 3) * 3 + i % 3;
            if (board[boxRow][boxCol] == val) return false;
        }
        return true;
    }
};
