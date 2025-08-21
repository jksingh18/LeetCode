class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        int result = 0;

        // Step 1: Compute consecutive ones in rows
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = count;
            }
        }

        // Step 2: For each element, move upwards and count submatrices
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int minWidth = dp[i][j];
                for (int k = i; k >= 0 && minWidth > 0; k--) {
                    minWidth = Math.min(minWidth, dp[k][j]);
                    result += minWidth;
                }
            }
        }

        return result;
    }
}