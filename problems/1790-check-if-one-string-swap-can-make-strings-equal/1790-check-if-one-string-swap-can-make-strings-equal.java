class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // Already equal, no swap needed

        int first = -1, second = -1; // To store indices of mismatched characters
        int count = 0; // Count of mismatched characters

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++; // Increment mismatch count
                if (count > 2) return false; // More than 2 mismatches, swap won't work
                if (first == -1) {
                    first = i; // Store first mismatch index
                } else {
                    second = i; // Store second mismatch index
                }
            }
        }

        // Exactly two mismatches and swapping these characters will fix it
        return count == 2 && 
               s1.charAt(first) == s2.charAt(second) && 
               s1.charAt(second) == s2.charAt(first);
    }
}

/*
Key Observations:

- If s1 and s2 are already equal, no swap is needed, so we return true.
- If s1 and s2 differ at more than two positions, it's impossible to fix them with one swap → return false.
- If s1 and s2 differ at exactly two positions, swapping these two mismatched characters should make them equal.
- If they differ at exactly one or more than two positions, it is impossible to fix with one swap → return false.
*/