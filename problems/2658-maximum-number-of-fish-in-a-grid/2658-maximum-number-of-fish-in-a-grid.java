class Solution {
    public int findMaxFish(int[][] grid) {
        int maxFish = 0; // To store the maximum fish caught
        int m = grid.length; // Number of rows
        int n = grid[0].length; // Number of columns

        // Iterate through all cells in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is a water cell (grid[i][j] > 0)
                if (grid[i][j] > 0) {
                    // Start a DFS from this cell and update the maximum fish
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Boundary conditions or if the cell is not a water cell
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        // Collect the fish in the current cell
        int fish = grid[r][c];

        // Mark the cell as visited by setting it to 0
        grid[r][c] = 0;

        // Perform DFS on all adjacent cells
        fish += dfs(grid, r + 1, c); // Down
        fish += dfs(grid, r - 1, c); // Up
        fish += dfs(grid, r, c + 1); // Right
        fish += dfs(grid, r, c - 1); // Left

        return fish;
    }
}