class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 1; // At least one element is a subarray
        int incLength = 1, decLength = 1; // Tracks lengths of increasing and decreasing subarrays

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLength++;
                decLength = 1; // Reset decreasing subarray length
            } else if (nums[i] < nums[i - 1]) {
                decLength++;
                incLength = 1; // Reset increasing subarray length
            } else {
                // Equal elements, reset both counters
                incLength = 1;
                decLength = 1;
            }
            // Update the maximum length found
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        return maxLength;
    }
}