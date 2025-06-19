import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        // Step 1: Find the maximum value in the array
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Step 2: Create a frequency array to count occurrences of each number
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // Step 3: Initialize variables
        int min = -100001; // Tracks the minimum value of the current subsequence
        int ans = 0;       // Tracks the number of subsequences

        // Step 4: Iterate through the frequency array
        for (int i = 0; i <= max; i++) {
            if (freq[i] > 0 && i - min > k) {
                // Start a new subsequence if the difference exceeds k
                min = i; // Update the minimum value for the new subsequence
                ans++;   // Increment the subsequence count
            }
        }

        // Step 5: Return the total number of subsequences
        return ans;
    }
}

/*
class Solution {
    public int partitionArray(int[] nums, int k) {
        // Sort the array
        Arrays.sort(nums);

        int subsequences = 0;
        int n = nums.length;
        int i = 0;

        while (i < n) {
            // Start a new subsequence
            subsequences++;
            int start = nums[i];

            // Move the pointer until the difference exceeds k
            while (i < n && nums[i] - start <= k) {
                i++;
            }
        }

        return subsequences;
    }
}
*/

/*
Approach:

Sort the Array:  
- Sort the array nums in ascending order. This ensures that elements close in value are grouped together.

Iterate Through the Array:  
- Use a greedy approach to form subsequences. Start a new subsequence whenever the difference between the current element and the smallest element in the current subsequence exceeds k.

Count Subsequences:  
- Maintain a count of subsequences. Increment the count each time a new subsequence is started.

Optimized Time Complexity:
- Sorting the array takes O(n log n).
- Iterating through the array takes O(n).
- Overall time complexity is O(n log n).
*/