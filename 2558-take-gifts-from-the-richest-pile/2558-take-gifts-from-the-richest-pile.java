import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        // Max-Heap to keep track of the largest pile of gifts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all gift piles to the max-heap
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break; // Safety check if the heap is empty

            // Remove the largest pile of gifts
            int largest = maxHeap.poll();

            // Calculate the remaining gifts after taking the floor of the square root
            int remainingGifts = (int) Math.floor(Math.sqrt(largest));

            // Add the remaining gifts back to the heap
            maxHeap.offer(remainingGifts);
        }

        // Calculate the total number of gifts remaining
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll(); // Sum up all the remaining gifts
        }
        
        return totalGifts;
    }
}
