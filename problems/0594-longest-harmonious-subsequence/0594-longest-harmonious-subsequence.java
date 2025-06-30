import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        // Step 1: Count frequencies using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check for harmonious pairs and calculate the maximum length
        int maxLength = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(key + 1)) { // Check if key + 1 exists
                int length = frequencyMap.get(key) + frequencyMap.get(key + 1);
                maxLength = Math.max(maxLength, length); // Update max length
            }
        }

        return maxLength;
    }
}