import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> node = new HashMap<>();  // Maps each ball (node) to its color
        Map<Integer, Integer> color = new HashMap<>(); // Tracks the frequency of each color
        int ans[] = new int[queries.length];  // Stores the number of distinct colors after each query
        
        for (int i = 0; i < queries.length; i++) {
            int it[] = queries[i];  // Extract the query [x, y]
            int ball = it[0];        // x (ball index)
            int newColor = it[1];    // y (new color)

            // If the ball was previously colored
            if (node.containsKey(ball)) {
                int oldColor = node.get(ball);
                
                // If the ball already has the same color, no change needed
                if (oldColor == newColor) {
                    ans[i] = color.size();
                    continue;
                }

                // Reduce the count of the old color, and remove if its count becomes zero
                if (color.get(oldColor) <= 1) {
                    color.remove(oldColor);
                } else {
                    color.put(oldColor, color.get(oldColor) - 1);
                }
            }

            // Assign the new color to the ball
            node.put(ball, newColor);
            color.put(newColor, color.getOrDefault(newColor, 0) + 1);

            // Store the current number of distinct colors
            ans[i] = color.size();
        }

        return ans;
    }
}