class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s); // Mutable string to allow efficient modifications

        while (true) {
            int index = sb.indexOf(part); // Find leftmost occurrence of 'part'
            if (index == -1) break; // If 'part' is not found, exit loop

            sb.delete(index, index + part.length()); // Remove 'part' from 'sb'
        }

        return sb.toString(); // Return the modified string
    }
}