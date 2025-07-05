class Solution {
    public int findLucky(int[] arr) {
        // Step 1: Create a frequency map
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the largest lucky integer
        int largestLucky = -1;
        for (int key : frequencyMap.keySet()) {
            if (key == frequencyMap.get(key)) { // Check if the frequency equals the value
                largestLucky = Math.max(largestLucky, key); // Update the largest lucky integer
            }
        }

        return largestLucky; // Return the result
    }
}