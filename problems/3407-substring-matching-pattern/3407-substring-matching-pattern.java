class Solution {
    public boolean hasMatch(String s, String p) {

        String[] parts =  p.split("\\*", -1); //Split the pattern into two parts using '*'

        String prefix = parts[0];
        String suffix = parts[1];

        if(prefix.isEmpty()) {
            return s.contains(suffix);
        }

        if(suffix.isEmpty()) {
            return s.contains(prefix);
        }

        int prefixIndex = s.indexOf(prefix);
        // if(prefixIndex == -1) {
        //     return false;
        // }

        // return startOfRemaining <= s.length() && s.substring(startOfRemaining).endsWith(suffix);

        while(prefixIndex != -1) {
            int startOfRemaining = prefixIndex + prefix.length();
            if (startOfRemaining <= s.length() && s.substring(startOfRemaining).contains(suffix)) {
                return true;
            }
            // Continue searching for the next occurrence of the prefix
            prefixIndex = s.indexOf(prefix, prefixIndex + 1);
        }
        return false;
    }
}