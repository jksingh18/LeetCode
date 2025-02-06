import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<>();
        int count = 0;

        // Step 1: Compute all pairwise products and store in a HashMap
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }

        // Step 2: Count valid tuples using combinatorics
        for (int freq : productMap.values()) {
            if (freq > 1) {
                count += 8 * (freq * (freq - 1) / 2);
            }
        }

        return count;
    }
}