class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = colors.length();
        int i = 0;
        while (i < n) {
            char currColor = colors.charAt(i);
            int maxTime = neededTime[i];
            int sumTime = neededTime[i];
            int j = i + 1;
            while (j < n && colors.charAt(j) == currColor) {
                // Same color group, consider for removal
                sumTime += neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            // Remove all except the max time one
            ans += (sumTime - maxTime);
            i = j; // move to next group
        }
        return ans;
    }
}