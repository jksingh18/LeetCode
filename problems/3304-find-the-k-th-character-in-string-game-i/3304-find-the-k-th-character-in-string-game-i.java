class Solution {
    public char kthCharacter(int k) {
        // Initialize the starting character
        char currentChar = 'a';

        // Reverse engineer the position of k
        while (k > 1) {
            // Determine if k is in the second half
            if (k % 2 == 0) {
                // Move to the "next character" transformation
                currentChar = nextChar(currentChar);
            }
            // Halve k to find its position in the previous iteration
            k = (k + 1) / 2;
        }

        return currentChar;
    }

    // Helper method to get the next character in the alphabet
    private char nextChar(char c) {
        return c == 'z' ? 'a' : (char) (c + 1);
    }
}