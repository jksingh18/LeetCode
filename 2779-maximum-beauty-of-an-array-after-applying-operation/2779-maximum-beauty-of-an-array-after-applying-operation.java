import java.util.Arrays;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array to enable efficient range checking
        Arrays.sort(nums);

        // Initialize pointers for the sliding window
        int left = 0; // Start of the window
        int maxBeauty = 0; // Store the maximum beauty

        // Iterate over the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            // Maintain the valid range [nums[left] - k, nums[right] + k]
            while (nums[right] - nums[left] > 2 * k) {
                left++; // Shrink the window from the left
            }

            // Update the maximum beauty as the current window size
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }
}
