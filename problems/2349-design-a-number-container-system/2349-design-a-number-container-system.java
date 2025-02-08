import java.util.*;

class NumberContainers {
    // Maps each number to a PriorityQueue of indices where it appears
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;
    
    // Maps each index to the number stored at that index
    private Map<Integer, Integer> indexToNumber;

    public NumberContainers() {
        numberToIndices = new HashMap<>();
        indexToNumber = new HashMap<>();
    }
    
    public void change(int index, int number) {
        // If the index already has a number assigned
        if (indexToNumber.containsKey(index)) {
            int previousNumber = indexToNumber.get(index);

            // If the number at the index is already the same, return early
            if (previousNumber == number) return;
            
            // Remove the index from the PriorityQueue of the previous number
            numberToIndices.get(previousNumber).remove(index);
        }

        // Insert the index into the PriorityQueue for the new number
        numberToIndices
            .computeIfAbsent(number, key -> new PriorityQueue<>())
            .offer(index);
        
        // Update the index to reflect the new number
        indexToNumber.put(index, number);
    }
    
    public int find(int number) {
        // Get the PriorityQueue of indices for the given number (or an empty queue if not found)
        PriorityQueue<Integer> indices = numberToIndices.getOrDefault(number, new PriorityQueue<>());
        
        // Return the smallest index if available, otherwise return -1
        return indices.isEmpty() ? -1 : indices.peek();
    }
}