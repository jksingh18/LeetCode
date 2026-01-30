class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        dp[m - 1][n - 1] = 0;

        int maxVal = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxVal = Math.max(maxVal, val);
            }
        }

        int[] teleportCost = new int[maxVal + 1];
        Arrays.fill(teleportCost, Integer.MAX_VALUE);

        for (int t = 0; t <= k; t++) {

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    if (i + 1 < m && dp[i + 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], grid[i + 1][j] + dp[i + 1][j]);
                    }

                    if (j + 1 < n && dp[i][j + 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], grid[i][j + 1] + dp[i][j + 1]);
                    }

                    if (t > 0) {
                        dp[i][j] = Math.min(dp[i][j], teleportCost[grid[i][j]]);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int value = grid[i][j];
                    teleportCost[value] = Math.min(teleportCost[value], dp[i][j]);
                }
            }

            for (int i = 1; i < teleportCost.length; i++) {
                teleportCost[i] = Math.min(teleportCost[i], teleportCost[i - 1]);
            }
        }

        return dp[0][0];
    }
}