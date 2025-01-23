class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    // Helper method to perform BFS and mark the island as visited
    private void bfs(char[][] grid, int ro, int co, int[][] vis) {
        vis[ro][co] = 1;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        // Directions for North, South, East, and West
        int[] dRow = {-1, 1, 0, 0}; // Row changes for the 4 directions
        int[] dCol = {0, 0, -1, 1}; // Column changes for the 4 directions

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            // Traverse in the 4 cardinal directions
            for (int i = 0; i < 4; i++) {
                int currentRow = row + dRow[i];
                int currentCol = col + dCol[i];

                if (currentRow >= 0 && currentRow < n
                        && currentCol >= 0 && currentCol < m
                        && grid[currentRow][currentCol] == '1'
                        && vis[currentRow][currentCol] == 0) {
                    vis[currentRow][currentCol] = 1;
                    queue.add(new Pair(currentRow, currentCol));
                }
            }
        }
    }

    // Main method to count the number of islands
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        // Traverse every cell in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    numIslands++;  // Increment island count
                    bfs(grid, row, col, visited);  // Sink the island using BFS
                }
            }
        }

        return numIslands;
    }
}