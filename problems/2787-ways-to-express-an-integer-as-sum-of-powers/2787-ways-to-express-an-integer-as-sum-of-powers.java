class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        // Step 1: Generate candidate powers <= n
        List<Integer> powers = new ArrayList<>();
        int base = 1;
        while (true) {
            long powVal = (long) Math.pow(base, x);
            if (powVal > n) break;
            powers.add((int) powVal);
            base++;
        }

        // Step 2: 1D DP array, dp[sum] = number of ways to reach sum
        int[] dp = new int[n + 1];
        dp[0] = 1; // base case: one way to reach 0 sum (choose nothing)

        // Step 3: Process each power, update dp in reverse
        for (int val : powers) {
            for (int sum = n; sum >= val; sum--) {
                dp[sum] = (dp[sum] + dp[sum - val]) % MOD;
            }
        }

        return dp[n];
    }
}