import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0, right = m;
            // Binary search for first potion that meets the requirement
            while (left < right) {
                int mid = (left + right) / 2;
                if ((long)spell * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            pairs[i] = m - left;
        }
        return pairs;
    }
}

/*
Approach:
Sort potions array.
For each spell, use binary search to find the smallest index l such that spell * potions[l] >= success.
All potions from that index to the end of the array will be successful with this spell.
pairs[i] = m - left gives the count.
*/