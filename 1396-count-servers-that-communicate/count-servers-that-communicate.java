class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns

        // Arrays to count the number of servers in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Step 1: Count the number of servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // Check if there's a server
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Step 2: Count servers that can communicate
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // A server communicates if either its row or column has more than one server
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }
}
