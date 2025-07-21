class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = i;
            // Count consecutive same characters
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            // Add at most 2 of the same character
            int count = Math.min(2, j - i);
            while (count-- > 0) {
                sb.append(s.charAt(i));
            }
            i = j;
        }
        return sb.toString();
    }
}