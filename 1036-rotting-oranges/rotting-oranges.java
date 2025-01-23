import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Add all rotten oranges to the queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // Directions for up, down, left, right movement
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minutes = 0;

        // Process the queue
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir : directions) {
                    int newRow = rotten[0] + dir[0];
                    int newCol = rotten[1] + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                    && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Make it rotten
                        freshOranges--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++; // Increment minutes after processing each level
        }

        return freshOranges == 0 ? minutes : -1; // Return -1 if there are still fresh oranges left
    }
}