class Solution {
    public int scoreOfString(String s) {
        int score = 0;

        // Loop through the string and calculate absolute difference between adjacent characters
        for (int i = 0; i < s.length() - 1; i++) {
            int ascii1 = (int) s.charAt(i);     // ASCII of current character
            int ascii2 = (int) s.charAt(i + 1); // ASCII of next character

            score += Math.abs(ascii1 - ascii2); // Add the absolute difference to score
        }

        return score;
    }
}