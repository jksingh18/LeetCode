import java.util.*;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] posArr = new int[n];
        int[] preSum = new int[n+1]; // prefix sum for amounts, 1-based indexing

        for (int i = 0; i < n; i++) {
            posArr[i] = fruits[i][0];
            preSum[i+1] = preSum[i] + fruits[i][1];
        }

        int maxFruits = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            // Try all windows from [l, r] where the cost is within k
            while (l <= r) {
                int left = posArr[l], right = posArr[r];
                // Two ways: left first, then sweep right; or right first, then sweep left
                int cost1 = Math.abs(startPos - left) + (right - left);   // left first
                int cost2 = Math.abs(startPos - right) + (right - left);  // right first

                if (cost1 <= k || cost2 <= k) {
                    break; // window is valid
                }
                l++; // Otherwise, move left up (window too big)
            }
            // [l, r] is valid window; sum fruits in [l, r]
            int sum = preSum[r+1] - preSum[l];
            maxFruits = Math.max(maxFruits, sum);
        }
        return maxFruits;
    }
}