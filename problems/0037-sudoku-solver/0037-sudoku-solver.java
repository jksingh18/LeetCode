class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){ //loop through 1->9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put current charthat fits for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //backTrack and check through other
                        }
                    }
                    
                    return false; //go back 
                }
            }
        }
        return true; //answer will be found here
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) //check row
                return false; 
            if(board[row][i] != '.' && board[row][i] == c) //check column
                return false; 
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
               board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)      //check 3*3 block sub-matrix
                return false; 
        }
        return true;
    }
}