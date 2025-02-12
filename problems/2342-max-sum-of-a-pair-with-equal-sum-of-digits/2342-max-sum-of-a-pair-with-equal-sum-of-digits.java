import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> digitSumToMaxNums = new HashMap<>(); // Map: sum of digits → top 2 largest numbers
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);

            // Store the two largest numbers for each digit sum group
            if (!digitSumToMaxNums.containsKey(digitSum)) {
                digitSumToMaxNums.put(digitSum, new int[]{num, -1});
            } else {
                int[] maxNums = digitSumToMaxNums.get(digitSum);
                if (num > maxNums[0]) {
                    maxNums[1] = maxNums[0]; // Shift the largest to second largest
                    maxNums[0] = num; // New largest
                } else if (num > maxNums[1]) {
                    maxNums[1] = num; // Update second largest if applicable
                }
            }
        }

        // Find the maximum sum among pairs
        for (int[] maxNums : digitSumToMaxNums.values()) {
            if (maxNums[1] != -1) { // Ensure we have at least 2 numbers in this group
                maxSum = Math.max(maxSum, maxNums[0] + maxNums[1]);
            }
        }

        return maxSum;
    }

    // Helper function to calculate sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; // Extract last digit and add to sum
            num /= 10; // Remove last digit
        }
        return sum;
    }
}