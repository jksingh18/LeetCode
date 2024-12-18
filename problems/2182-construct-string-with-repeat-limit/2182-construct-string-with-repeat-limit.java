import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Frequency array to count occurrences of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max-Heap to prioritize the lexicographically largest character
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Populate the heap with characters and their frequencies
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]}); // {character index, frequency}
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            // Get the largest character from the heap
            int[] current = maxHeap.poll();
            int charIndex = current[0];
            int charFreq = current[1];

            // Determine how many times we can use this character
            int useCount = Math.min(charFreq, repeatLimit);

            // Append the character up to useCount times
            for (int i = 0; i < useCount; i++) {
                result.append((char) (charIndex + 'a'));
            }

            // If there are leftover characters of the current character
            if (charFreq > useCount) {
                if (maxHeap.isEmpty()) {
                    // If no other characters are available, stop
                    break;
                }

                // Get the next largest character to break the repetition
                int[] next = maxHeap.poll();
                result.append((char) (next[0] + 'a'));

                // Decrement the frequency of the next character
                next[1]--;

                // Reinsert the next character back if it still has remaining frequency
                if (next[1] > 0) {
                    maxHeap.offer(next);
                }

                // Reinsert the current character back with remaining frequency
                current[1] -= useCount;
                maxHeap.offer(current);
            }
        }

        return result.toString();
    }
}