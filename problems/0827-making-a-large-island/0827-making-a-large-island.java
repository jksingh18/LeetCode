import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Map<Integer, Integer> islandSize = new HashMap<>();
        int index = 2; // Start from 2 (since 0 and 1 are already used)
        int maxIsland = 0;
        
        // Step 1: Label all islands with unique index & store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, index, directions);
                    islandSize.put(index, size);
                    maxIsland = Math.max(maxIsland, size);
                    index++;
                }
            }
        }

        // Step 2: Try flipping each 0 to 1 and check the largest island possible
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int newSize = 1; // Start with 1 (since we are converting this cell to 1)
                    
                    for (int[] dir : directions) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            int id = grid[ni][nj];
                            if (!seenIslands.contains(id)) {
                                newSize += islandSize.get(id);
                                seenIslands.add(id);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }

    // DFS to label islands and compute their size
    private int dfs(int[][] grid, int i, int j, int index, int[][] directions) {
        int n = grid.length;
        int size = 1;
        grid[i][j] = index; // Mark the cell with a unique island ID

        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                size += dfs(grid, ni, nj, index, directions);
            }
        }
        return size;
    }
}