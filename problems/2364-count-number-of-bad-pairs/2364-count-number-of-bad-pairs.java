import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        long totalPairs = (long) nums.length * (nums.length - 1) / 2;  // Total possible pairs
        Map<Integer, Long> countMap = new HashMap<>();  // Stores occurrences of (nums[i] - i)
        long goodPairs = 0;  // Count of valid (i, j) pairs

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;  // Compute transformed value
            
            // If this key has been seen before, all previous occurrences form good pairs
            goodPairs += countMap.getOrDefault(key, 0L);
            
            // Update count of this key
            countMap.put(key, countMap.getOrDefault(key, 0L) + 1);
        }
        
        return totalPairs - goodPairs;  // Bad pairs = Total pairs - Good pairs
    }
}


/*
- The total number of (i, j) pairs is given by the formula: n(n−1)/2
- We store the frequency of the transformed values (nums[i] - i)
- If the same key appeared before, all those indices form good pairs with i, so we increment goodPairs.
- We then update the count of this key in the HashMap.
- Bad pairs = Total pairs - Good pairs.
*/