class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int[] cut = new int[n];

        for (int i = 0; i < n; i++) {
          cut[i] = i;
          for (int j = 0; j <= i; j++) {
            if (c[i] == c[j] && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
              dp[j][i] = true;
              if (j == 0) {
                cut[i] = 0;
              } else {
                cut[i] = (cut[i] < cut[j - 1] + 1) ? cut[i] : cut[j - 1] + 1;
              }
            }
          }
        }

        return cut[n - 1];
    }
}