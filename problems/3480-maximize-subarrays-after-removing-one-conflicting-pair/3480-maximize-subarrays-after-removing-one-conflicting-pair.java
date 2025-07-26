class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // Step 1: Build adjacency list 'g' where g[a] contains all b such that (a,b) is a conflicting pair
        List<Integer>[] g = new List[n + 2]; // size n+2 for safe indexing
        Arrays.setAll(g, k -> new ArrayList<>());

        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            if (a > b) { // ensure a < b for consistency
                int temp = a;
                a = b;
                b = temp;
            }
            g[a].add(b);
        }

        // Step 2: Initialize helper variables
        long[] cnt = new long[n + 2]; // stores increments used for interval counting corrections
        long ans = 0;  // Accumulates count of valid subarrays so far
        long add = 0;  // Tracks max additional valid subarrays by removing one pair
        int b1 = n + 1; // The smallest conflict endpoint b for current a
        int b2 = n + 1; // The second smallest conflict endpoint b for current a

        // Step 3: Iterate from right to left over 'a' values
        for (int a = n; a > 0; --a) {
            // For all conflict 'b' that go with current 'a'
            for (int b : g[a]) {
                if (b < b1) {
                    // Update b1 to be smallest b, and b2 second smallest
                    b2 = b1;
                    b1 = b;
                } else if (b < b2) {
                    b2 = b;
                }
            }

            // Step 4: Count subarrays start at 'a' but end before b1
            ans += b1 - a;

            // Step 5: Update count for b1, tracking gaps between b1 and b2
            cnt[b1] += b2 - b1;

            // Step 6: Update max additional valid subarrays 
            // achievable if removing the pair responsible for cnt[b1]
            add = Math.max(add, cnt[b1]);
        }

        // Step 7: Final answer includes the correction for best pair removal
        ans += add;

        return ans;
    }
}