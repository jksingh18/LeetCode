class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0; //start pointer
        int end = 0; //end pointer will move forward
        int max = 0; //will store maxLength of substring
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end)); //will add in set if it's unique
                end++; //move forward
                max = Math.max(set.size(), max); //check Max length for every distinct character
            } else {
                set.remove(s.charAt(start)); // will remove the character that is pointing by the start
                start++; //start pointer moves 1 step ahead mainting a window
            }
        }
        return max; //FinalAnswer.
    }
}