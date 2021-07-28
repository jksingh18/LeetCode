class Solution {
    public boolean areOccurrencesEqual(String s) {
         int[] arr = new int[26];
        int lastCharFreq = 0;
        for (char ch: s.toCharArray()) {
            arr[ch - 'a']++;
            lastCharFreq = arr[ch - 'a'];            
        }
        
        for (int i = 0; i < 26; i++)
            if (arr[i] != 0 && arr[i] != lastCharFreq)
                return false;
        
        return true;
    }
}