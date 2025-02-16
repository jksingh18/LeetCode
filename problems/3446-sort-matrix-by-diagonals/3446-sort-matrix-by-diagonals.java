import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Step 1: Sort bottom-left diagonals (including middle) in non-increasing (descending) order
        for (int row = n - 2; row >= 0; row--) { 
            sortDiagonal(grid, row, 0, false);  // Start from (row, 0), sort in descending order
        }

        // Step 2: Sort top-right diagonals in non-decreasing (ascending) order
        for (int col = 1; col < n; col++) { 
            sortDiagonal(grid, 0, col, true);  // Start from (0, col), sort in ascending order
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> diagonalElements = new ArrayList<>();

        // Extract the diagonal elements
        int i = row, j = col;
        while (i < n && j < n) {
            diagonalElements.add(grid[i][j]);
            i++;
            j++;
        }

        // Sort the extracted diagonal
        if (ascending) {
            Collections.sort(diagonalElements);  // Sort in increasing order
        } else {
            diagonalElements.sort(Collections.reverseOrder());  // Sort in decreasing order
        }

        // Put the sorted elements back into the grid
        i = row;
        j = col;
        for (int value : diagonalElements) {
            grid[i][j] = value;
            i++;
            j++;
        }
    }
}