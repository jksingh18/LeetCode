class Solution {
    public double soupServings(int n) {
        if (n > 4800) return 1.0; // For large n, probability approaches 1

        // Scale down n to units of 25 mL, rounding up for partial servings
        int m = (n + 24) / 25;
        // Memoization table; Java supports less elegant syntax than Python, so use a Map or a 2D array
        double[][] dp = new double[m + 1][m + 1];

        // Fill dp with -1 (uncomputed)
        for (int i = 0; i <= m; ++i)
            java.util.Arrays.fill(dp[i], -1.0);

        return helper(m, m, dp);
    }

    // Recursive helper
    private double helper(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (dp[a][b] != -1.0) return dp[a][b];

        // Serving amounts converted to units (4,0), (3,1), (2,2), (1,3)
        dp[a][b] = 0.25 * (
            helper(a - 4, b, dp)
            + helper(a - 3, b - 1, dp)
            + helper(a - 2, b - 2, dp)
            + helper(a - 1, b - 3, dp)
        );

        return dp[a][b];
    }
}