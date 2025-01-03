class Solution {

    public int waysToSplitArray(int[] nums) {
        // Keep track of sum of elements on left and right sides
        long leftSum = 0, rightSum = 0;

        // Initially all elements are on right side
        for (int num : nums) {
            rightSum += num;
        }

        int count = 0;
        // Try each possible split position
        for (int i = 0; i < nums.length - 1; i++) {
            // Move current element from right to left side
            leftSum += nums[i];
            rightSum -= nums[i];

            // Check if this creates a valid split
            if (leftSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}

/*
Algorithm:

* Initialize two variables leftSum and rightSum to 0 to track the sum of elements on the left and right sides of each split.
* Calculate the initial rightSum by iterating through the input array and adding all elements to it, as initially, all elements are on the right side.
* Initialize a variable count to 0 to track the number of valid splits.
* Iterate from index 0 to the length of nums minus 2:
- Add the current element to leftSum as it moves to the left side.
- Subtract the current element from rightSum as it leaves the right side.
- If leftSum is greater than or equal to rightSum, increment count.
* Return the final value of count as the result.

*/