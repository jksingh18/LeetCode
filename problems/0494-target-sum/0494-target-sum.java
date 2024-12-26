class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Edge case: If the target is not achievable or totalSum is less than target
        if (totalSum < target || (totalSum - target) % 2 != 0) {
            return 0;
        }

        // Transform the problem into a subset sum problem
        int subsetSum = (totalSum - target) / 2;

        // Solve the subset sum problem
        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int subsetSum) {
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // There's 1 way to achieve a sum of 0 (using no elements)

        // Fill the dp array
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}