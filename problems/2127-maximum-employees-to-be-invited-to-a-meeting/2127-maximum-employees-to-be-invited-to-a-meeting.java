class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        for (int f : favorite) {
            indegree[f]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] depth = new int[n];
        
        // Step 1: Process nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            int next = favorite[curr];
            depth[next] = Math.max(depth[next], depth[curr] + 1);
            if (--indegree[next] == 0) {
                queue.offer(next);
            }
        }

        // Step 2: Detect cycles and calculate max employees
        int maxCycleSize = 0;
        int chainSum = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleLength = 0;
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = favorite[curr];
                    cycleLength++;
                }
                if (cycleLength == 2) {
                    // Mutual pairs can include chains
                    chainSum += 2 + depth[i] + depth[favorite[i]];
                } else {
                    maxCycleSize = Math.max(maxCycleSize, cycleLength);
                }
            }
        }

        // The answer is the maximum between large cycles or mutual pairs + chains
        return Math.max(maxCycleSize, chainSum);
    }
}