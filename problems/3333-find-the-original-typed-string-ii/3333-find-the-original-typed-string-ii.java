import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int possibleStringCount(String word, int k) {
        if (word.isEmpty()) {
            return 0;
        }

        // Step 1: Group consecutive characters and count their occurrences
        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);

        // Step 2: Calculate the total number of combinations
        long totalCombinations = 1;
        for (int groupSize : groups) {
            totalCombinations = (totalCombinations * groupSize) % MOD;
        }

        // If k is less than or equal to the number of groups, return total combinations
        if (k <= groups.size()) {
            return (int) totalCombinations;
        }

        // Step 3: Use dynamic programming to calculate invalid combinations
        int[] dp = new int[k];
        dp[0] = 1;

        for (int groupSize : groups) {
            int[] newDp = new int[k];
            long cumulativeSum = 0;

            for (int s = 0; s < k; s++) {
                if (s > 0) {
                    cumulativeSum = (cumulativeSum + dp[s - 1]) % MOD;
                }
                if (s > groupSize) {
                    cumulativeSum = (cumulativeSum - dp[s - groupSize - 1] + MOD) % MOD;
                }
                newDp[s] = (int) cumulativeSum;
            }

            dp = newDp;
        }

        // Step 4: Calculate the number of invalid combinations
        long invalidCombinations = 0;
        for (int s = groups.size(); s < k; s++) {
            invalidCombinations = (invalidCombinations + dp[s]) % MOD;
        }

        // Step 5: Return the valid combinations modulo MOD
        return (int) ((totalCombinations - invalidCombinations + MOD) % MOD);
    }
}