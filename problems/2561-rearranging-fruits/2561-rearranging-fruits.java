import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> freq = new HashMap<>();  // total freq for each cost
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();
        int minAll = Integer.MAX_VALUE;

        // Count frequencies and collect min fruit cost
        for (int x : basket1) {
            freq1.put(x, freq1.getOrDefault(x, 0) + 1);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            minAll = Math.min(minAll, x);
        }
        for (int x : basket2) {
            freq2.put(x, freq2.getOrDefault(x, 0) + 1);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            minAll = Math.min(minAll, x);
        }

        // Check if possible to make baskets equal
        for (int k : freq.keySet()) {
            if (freq.get(k) % 2 != 0) return -1;
        }

        // Collect all extra fruits from basket1 and basket2 that need to be swapped
        List<Integer> extraIn1 = new ArrayList<>();
        List<Integer> extraIn2 = new ArrayList<>();
        for (int k : freq.keySet()) {
            int total = freq.get(k);
            int targetEach = total / 2;
            int c1 = freq1.getOrDefault(k, 0);
            int c2 = freq2.getOrDefault(k, 0);
            // Surplus in basket1
            if (c1 > targetEach) {
                for (int i = 0; i < (c1 - targetEach); i++) {
                    extraIn1.add(k);
                }
            }
            // Surplus in basket2
            if (c2 > targetEach) {
                for (int i = 0; i < (c2 - targetEach); i++) {
                    extraIn2.add(k);
                }
            }
        }

        // The lengths must be the same, or logic error!
        if (extraIn1.size() != extraIn2.size()) return -1;

        // Sort both extra lists to pair cheapest swaps
        Collections.sort(extraIn1);
        Collections.sort(extraIn2, Collections.reverseOrder());

        long res = 0;
        int m = extraIn1.size();
        for (int i = 0; i < m; i++) {
            int a = extraIn1.get(i);
            int b = extraIn2.get(i);
            // We can always do the direct swap for cost min(a, b); or go via minAll*2
            res += Math.min(Math.min(a, b), minAll * 2);
        }
        return res;
    }
}