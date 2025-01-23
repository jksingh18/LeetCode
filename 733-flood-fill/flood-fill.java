class Solution {

    private void dfs(int row, int col, int[][] result, int[][] image, int newColor,
                     int[] directionRow, int[] directionCol, int initialColor) {
        result[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i=0; i<4; i++) {
            int currentRow = row + directionRow[i];
            int currentCol = col + directionCol[i];
            if(currentRow >=0 && currentRow < n && currentCol >=0 && currentCol < m
            && image[currentRow][currentCol] == initialColor
            && result[currentRow][currentCol] != newColor) {
                dfs(currentRow, currentCol, result, image, newColor, directionRow, directionCol, initialColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] result = image;

        int[] directionRow = {+1, 0, -1, 0};
        int[] directionCol = {0, +1, 0, -1};

        dfs(sr, sc, result, image, color, directionRow, directionCol, initialColor);
        return result;
    }
}