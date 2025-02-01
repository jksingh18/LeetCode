class Solution {
    public String findValidPair(String s) {
        
        int[] freq = new int[10];
        for(char c: s.toCharArray()) {
            freq[c - '0']++;
        }

        for(int i=0; i < s.length()-1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i+1);

            if(first!=second) {
                int num1 = first - '0';
                int num2 = second - '0';

                if(freq[num1] == num1 && freq[num2] == num2) {
                    return "" + first + second;
                }
            }
        }
        return "";
    }
}