class Solution {

    private void dfs(int row, int column, int[][] visited, char[][] board) {
        visited[row][column] = 1;

        int[] directionRow = { -1, 0, +1, 0 };
        int[] directionCol = { 0, -1, 0, +1 };
        for (int i = 0; i < 4; i++) {
            int currentRow = row + directionRow[i];
            int currentCol = column + directionCol[i];

            if (currentRow >= 0 && currentRow < board.length
                    && currentCol >= 0 && currentCol < board[0].length
                    && visited[currentRow][currentCol] == 0
                    && board[currentRow][currentCol] == 'O') {
                dfs(currentRow, currentCol, visited, board);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];

        // Traverse the first and last rows
        for (int j = 0; j < m; j++) {
            // first row
            if (visited[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, visited, board);
            }

            // last row
            if (visited[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, visited, board);
            }
        }

        // Traverse the first and last column
        for (int i = 0; i < n; i++) {
            // first column
            if (visited[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, visited, board);
            }

            // last column
            if (visited[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, visited, board);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}