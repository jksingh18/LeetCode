import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Map<Integer, Integer> freq = new HashMap<>();

        // Initial window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i <= n - k; i++) {
            // Priority Queue: element with higher freq first, then higher value in tie
            PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> 
                b[1] != a[1] ? b[1] - a[1] : b[0] - a[0]
            );
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                heap.add(new int[]{e.getKey(), e.getValue()});
            }

            int cnt = 0, sum = 0;
            while (!heap.isEmpty() && cnt < x) {
                int[] curr = heap.poll();
                sum += curr[0] * curr[1];
                cnt++;
            }
            ans[i] = sum;

            // Prepare for next window
            if (i + k < n) {
                // Remove leftmost
                int left = nums[i];
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0) freq.remove(left);
                // Add new rightmost
                int right = nums[i + k];
                freq.put(right, freq.getOrDefault(right, 0) + 1);
            }
        }

        return ans;
    }
}