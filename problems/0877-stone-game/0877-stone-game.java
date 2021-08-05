class Solution {
       public boolean stoneGame(int[] piles) {
            int len = piles.length;
            int[][][] dp = new int[len + 1][len + 1][2];
            for (int[][] arr : dp) {
                for (int[] num : arr) {
                    Arrays.fill(num, -1);
                }
            }
            return recursion(dp, 0, len - 1, 1, piles) > 0;
        }

        private int recursion(int[][][] dp, int left, int right, int identifier, int[] piles) {
            if (left > right) {
                return 0;
            }
            if (dp[left][right][identifier] != -1) {
                return dp[left][right][identifier];
            }
            int next = Math.abs(identifier - 1);
            if (identifier == 1) {
                dp[left][right][identifier] = Math.max(piles[left] + recursion(dp, left + 1, right, next, piles),                 piles[right] + recursion(dp, left, right - 1, next, piles));
            } else {
                dp[left][right][identifier] = Math.min(-piles[left] + recursion(dp, left + 1, right, next,                       piles), -piles[right] + recursion(dp, left, right - 1, next, piles));
            }
            return dp[left][right][identifier];
        }
}