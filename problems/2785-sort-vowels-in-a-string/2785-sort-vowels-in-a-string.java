import java.util.*;

class Solution {
    public String sortVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        // Step 1: Collect vowels from s
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                vowels.add(c);
            }
        }
        
        // Step 2: Sort vowels by ASCII (natural char order)
        Collections.sort(vowels);
        
        // Step 3: Reconstruct the string with vowels sorted, consonants at original places
        StringBuilder result = new StringBuilder();
        int vowelsIndex = 0;
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                result.append(vowels.get(vowelsIndex++));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}