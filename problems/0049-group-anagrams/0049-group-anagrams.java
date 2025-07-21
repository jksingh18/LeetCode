class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: key = sorted string, value = list of words that are anagrams
        Map<String, List<String>> groupAnagramsMap = new HashMap<>();

        for(String str : strs){
            // 1. Sort the string's chars
            char[] characterArray = str.toCharArray();
            Arrays.sort(characterArray);
            String sortedStringKey = new String(characterArray);

            // 2. Add to the correct group in map
            if(!groupAnagramsMap.containsKey(sortedStringKey)){
                groupAnagramsMap.put(sortedStringKey, new ArrayList<>());
            }
            groupAnagramsMap.get(sortedStringKey).add(str);
        }

        // 3. Return the map's grouped values
        return new ArrayList<>(groupAnagramsMap.values());
    }
}