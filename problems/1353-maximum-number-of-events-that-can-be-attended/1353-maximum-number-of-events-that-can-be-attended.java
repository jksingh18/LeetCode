import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by start day
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to store end days of events
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int maxEvents = 0; // Count of events attended
        int day = 0; // Current day
        int i = 0; // Index for events array

        while (!minHeap.isEmpty() || i < events.length) {
            // Move to the next day if the heap is empty
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            // Add all events starting on the current day to the heap
            while (i < events.length && events[i][0] <= day) {
                minHeap.add(events[i][1]); // Add end day to the heap
                i++;
            }

            // Remove events from the heap that are no longer valid
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event with the earliest end day
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                maxEvents++;
            }

            // Move to the next day
            day++;
        }

        return maxEvents;
    }
}