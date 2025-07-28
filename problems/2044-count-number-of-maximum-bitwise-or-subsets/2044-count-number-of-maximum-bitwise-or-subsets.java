class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Find the overall maximum possible OR
        for (int x : nums) {
            maxOr |= x;
        }
        // Step 2: Run backtracking to count all subsets reaching maxOr
        dfs(nums, 0, 0);
        return count;
    }

    // Backtracking: try including or excluding each value
    private void dfs(int[] nums, int idx, int currOr) {
        if (idx == nums.length) {
            // If non-empty AND the or matches maxOr, count it
            if (currOr == maxOr && idx != 0) count++;
            return;
        }
        // Include nums[idx]
        dfs(nums, idx + 1, currOr | nums[idx]);
        // Exclude nums[idx]
        dfs(nums, idx + 1, currOr);
    }
}