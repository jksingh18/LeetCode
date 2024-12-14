import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long totalSubarrays = 0;

        // TreeMap to maintain frequency of elements in the current sliding window
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        int left = 0; // Left pointer of the sliding window

        // Iterate through the array with the right pointer
        for (int right = 0; right < n; right++) {
            // Add the current element to the frequency map
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Check if the current window is valid
            while (freqMap.lastKey() - freqMap.firstKey() > 2) {
                // Shrink the window from the left until it becomes valid
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            // All subarrays ending at 'right' and starting from 'left' are valid
            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }
}
