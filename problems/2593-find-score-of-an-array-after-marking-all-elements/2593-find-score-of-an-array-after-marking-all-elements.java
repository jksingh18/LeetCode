import java.util.PriorityQueue;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;

        // Boolean array to track marked elements
        boolean[] marked = new boolean[n];

        // PriorityQueue to always fetch the smallest unmarked integer
        // Elements in the queue are stored as {value, index} pairs
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sort by value
            }
            return Integer.compare(a[1], b[1]); // If tied, sort by index
        });

        // Add all elements to the priority queue with their indices
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        // Process the elements in the priority queue
        while (!minHeap.isEmpty()) {
            // Get the smallest unmarked element
            int[] current = minHeap.poll();
            int value = current[0];
            int index = current[1];

            // Skip if already marked
            if (marked[index]) {
                continue;
            }

            // Add the value to the score
            score += value;

            // Mark the current element and its adjacent elements
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true; // Mark left neighbor if exists
            }
            if (index < n - 1) {
                marked[index + 1] = true; // Mark right neighbor if exists
            }
        }

        return score;
    }
}