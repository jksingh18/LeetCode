import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        long maxSum = 0, currentSum = 0;
        int left = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            currentSum += nums[right];

            // Shrink window if size exceeds k
            if (right - left + 1 > k) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) freqMap.remove(leftNum);
                currentSum -= leftNum;
                left++;
            }

            // Check if all elements are distinct in current window
            if (right - left + 1 == k && freqMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}