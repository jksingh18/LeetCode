class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];  // Initialize maxSum with the first element
        int currentSum = nums[0];  // Start first subarray with the first element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];  // Extend the current subarray
            } else {
                currentSum = nums[i];  // Start a new subarray
            }
            maxSum = Math.max(maxSum, currentSum);  // Update maxSum if needed
        }

        return maxSum; // Return the maximum sum found
    }
}