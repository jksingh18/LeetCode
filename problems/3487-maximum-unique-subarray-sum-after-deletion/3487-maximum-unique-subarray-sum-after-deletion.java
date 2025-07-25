import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> uniquePositives = new HashSet<>();
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) uniquePositives.add(num);
            maxElement = Math.max(maxElement, num);
        }
        if (!uniquePositives.isEmpty()) {
            // Sum all unique positives
            int sum = 0;
            for (int x : uniquePositives) sum += x;
            return sum;
        }
        // All numbers negative or zero: pick the least negative
        return maxElement;
    }
}