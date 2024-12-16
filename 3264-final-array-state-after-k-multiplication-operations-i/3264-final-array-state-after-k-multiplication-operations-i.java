import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Min-heap to efficiently find the minimum value and its index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt((int[] pair) -> pair[0]) // Sort by value first
                      .thenComparingInt(pair -> pair[1])     // If tie, sort by index
        );

        // Populate the heap with initial values and their indices
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i}); // {value, index}
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the smallest element
            int[] smallest = minHeap.poll();
            int value = smallest[0];
            int index = smallest[1];

            // Multiply the smallest value by the multiplier and update the array
            nums[index] = value * multiplier;

            // Add the updated value back into the heap with the same index
            minHeap.offer(new int[]{nums[index], index});
        }

        return nums; // Return the modified array
    }
}
