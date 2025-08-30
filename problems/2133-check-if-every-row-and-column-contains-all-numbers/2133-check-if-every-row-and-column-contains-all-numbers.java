class Solution {

    /* -> Easy can also be explained in the interview:
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; ++r) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int c = 0; c < n; ++c) {
                if(!row.add(matrix[r][c])) return false;
                if(!col.add(matrix[c][r])) return false;
            }
        }
        return true;
    }
    */

    //But this explains the intuition and approach, which interviewer might be looking for
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n];
            boolean[] colCheck = new boolean[n];
            for (int j = 0; j < n; j++) {
                int rowVal = matrix[i][j];
                int colVal = matrix[j][i];

                // Check if rowVal is in range and not repeated in row
                if (rowVal < 1 || rowVal > n || rowCheck[rowVal - 1]) {
                    return false;
                }
                rowCheck[rowVal - 1] = true;

                // Check if colVal is in range and not repeated in column
                if (colVal < 1 || colVal > n || colCheck[colVal - 1]) {
                    return false;
                }
                colCheck[colVal - 1] = true;
            }
        }

        return true;
    }
}