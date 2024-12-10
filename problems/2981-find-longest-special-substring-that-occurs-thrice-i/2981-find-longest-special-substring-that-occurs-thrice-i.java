/* 
- Requirement: To find the longest substring made up of a single character ("special") that occurs at least thrice in the input string.
- Approach:
1. Using a HashMap, we efficiently count the occurrences of substrings of a specific length.
2. Substring checking is limited to "special" substrings, reducing unnecessary computations.

*/


import java.util.HashMap;

class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int result = -1;

        // HashMap to store frequency of substrings
        HashMap<String, Integer> substringCount = new HashMap<>();

        // Iterate over possible lengths of substrings
        for (int len = 1; len <= n; len++) {
            substringCount.clear(); // Clear map for the current length

            // Check all substrings of length 'len'
            for (int i = 0; i <= n - len; i++) {
                String substring = s.substring(i, i + len);

                // Check if the substring is "special" (all characters are the same)
                if (isSpecial(substring)) {
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);

                    // If a substring occurs at least 3 times, update the result
                    if (substringCount.get(substring) >= 3) {
                        result = len; // Update result with the current length
                    }
                }
            }
        }

        return result; // Return the longest valid length, or -1 if no valid substring
    }

    // Helper method to check if a substring is "special"
    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) {
                return false; // Not special if any character is different
            }
        }
        return true;
    }
}