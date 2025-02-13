import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        // Create a Min Heap (PriorityQueue) to always extract the smallest elements
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        // Add all elements from the array into the min heap
        for (int num : nums) {
            pq.offer((long) num); // Convert to long to prevent overflow
        }
        
        int operations = 0; // Count the number of operations
        
        // Continue until all elements are at least 'k'
        while (pq.size() > 1 && pq.peek() < k) {
            // Extract the two smallest elements from the heap
            long smallest = pq.poll();  // Remove and get the smallest element
            long secondSmallest = pq.poll(); // Remove and get the second smallest element
            
            // Compute the new element using the formula: (smallest * 2) + secondSmallest
            long newElement = (smallest * 2) + secondSmallest;
            
            // Insert the new element back into the heap
            pq.offer(newElement);
            
            // Increment the operation count
            operations++;
        }
        
        // Return the minimum number of operations needed
        return operations;
    }
}

/*
We can use a priority queue (min heap) to simulate this process.

Specifically, we first add the elements in the array to the priority queue pq. Then we continuously take out the two smallest elements x and y from the priority queue, and put min(x, y) * 2 + max(x, y) back into the priority queue. After each operation, we increase the operation count by one. We stop the operation when the number of elements in the queue is less than 2 or the smallest element in the queue is greater than or equal to k.

The time complexity is O(nlogn), and the space complexity is O(n), where n is the length of the array.
*/