class Solution {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        boolean[] results = new boolean[queries.length];

        // Step 1: Build the "alternation" prefix sum array
        for (int i = 0; i < n - 1; i++) {
            // Check if nums[i] and nums[i+1] have different parity
            if ((nums[i] % 2) != (nums[i + 1] % 2)) {
                prefixSum[i + 1] = 1; // Mark as alternating
            }
            // Accumulate the prefix sum
            prefixSum[i + 1] += prefixSum[i];
        }

        // Step 2: Process each query using the prefix sum array
        for (int k = 0; k < queries.length; k++) {
            int from = queries[k][0];
            int to = queries[k][1];
        
            // Check if all pairs in nums[from..to] are alternating
            int alternatingCount = prefixSum[to] - prefixSum[from];
            if (to > from) { // Avoid underflow for single-element ranges
                results[k] = (alternatingCount == (to - from));
            } else {
                results[k] = true; // Single-element subarrays are always special
            }
        }
        return results;
    }
}
