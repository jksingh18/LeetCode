class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int maxSum = 0, windowSum = 0;

        for (int right = 0; right < nums.length; right++) {
            // Shrink window from left until nums[right] is unique
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
            // Add the new number
            set.add(nums[right]);
            windowSum += nums[right];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}

/*
Intuition:

1. Maintain a sliding window: [left, right]
2. Keep track of current unique elements using a HashSet (set), and current window sum (windowSum).
3. As you expand right, check:
4. If nums[right] is not in the set, add it to the set and sum, expand window.
5. If nums[right] IS in the set, keep removing from the left (set and sum) until you can add nums[right] again
6. At every step, update max sum.
7. At the end, return the max sum found.
*/