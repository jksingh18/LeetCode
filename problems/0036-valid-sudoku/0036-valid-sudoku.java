class Solution {
    public boolean isValidSudoku(char[][] board) {
        // For digits 1-9 in each row, column, and box
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1'; // digits 1-9 mapped to 0-8
                    int box = (i / 3) * 3 + (j / 3);
                    
                    if (rows[i][num] || cols[j][num] || boxes[box][num]) {
                        return false;
                    }
                    
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[box][num] = true;
                }
            }
        }
        
        return true;
    }
}