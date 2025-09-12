class Solution {
    public boolean doesAliceWin(String s) {
        // Set of vowels
        String vowels = "aeiou";

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) >= 0) {
                return true;  // Alice wins if any vowel exists
            }
        }
        return false;  // No vowel => Alice loses
    }
}