import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();      // All ORs seen so far
        Set<Integer> prev = new HashSet<>();        // ORs for subarrays ending at prev position

        for (int num : arr) {
            Set<Integer> cur = new HashSet<>();
            cur.add(num); // Start new subarray at current number

            // Extend previous subarrays to include num
            for (int x : prev) {
                cur.add(x | num);
            }

            // Add all ORs for this position to result set
            result.addAll(cur);
            // cur is now prev for next step
            prev = cur;
        }
        return result.size();
    }
}