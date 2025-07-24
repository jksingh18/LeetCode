import java.util.*;

class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        // Build the tree as adjacency list
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] xorSubtree = new int[n];
        int[] tin = new int[n], tout = new int[n];
        int[] parent = new int[n];
        int[] time = new int[]{0};

        // Step 1: DFS to compute subtree xors, timestamps, and parents
        dfs(0, -1, nums, g, xorSubtree, tin, tout, parent, time);

        int totalXor = xorSubtree[0];
        int minScore = Integer.MAX_VALUE;

        // Step 2: For each pair of non-root nodes (u, v), compute score
        // Each node corresponds to cutting its connection with its parent
        for (int u = 1; u < n; u++) {
            for (int v = 1; v < n; v++) if (u != v) {
                // Helper: is node a in subtree of node b?
                boolean uInV = isAncestor(v, u, tin, tout);
                boolean vInU = isAncestor(u, v, tin, tout);

                int x1, x2, x3;
                if (uInV) {
                    // u is in v's subtree
                    // Components: [u], [v minus u], [rest]
                    x1 = xorSubtree[u];
                    x2 = xorSubtree[v] ^ xorSubtree[u];
                    x3 = totalXor ^ xorSubtree[v];
                } else if (vInU) {
                    // v is in u's subtree
                    x1 = xorSubtree[v];
                    x2 = xorSubtree[u] ^ xorSubtree[v];
                    x3 = totalXor ^ xorSubtree[u];
                } else {
                    // Disjoint subtrees
                    x1 = xorSubtree[u];
                    x2 = xorSubtree[v];
                    x3 = totalXor ^ xorSubtree[u] ^ xorSubtree[v];
                }

                int maxVal = Math.max(x1, Math.max(x2, x3));
                int minVal = Math.min(x1, Math.min(x2, x3));
                minScore = Math.min(minScore, maxVal - minVal);
            }
        }
        return minScore;
    }

    // DFS to fill subtree XOR, parent, and entry/exit times for Euler tour
    private void dfs(int u, int p, int[] nums, List<Integer>[] g,
                     int[] xorSubtree, int[] tin, int[] tout, int[] parent, int[] time) {
        tin[u] = time[0]++;
        xorSubtree[u] = nums[u];
        parent[u] = p;
        for (int v : g[u]) {
            if (v == p) continue;
            dfs(v, u, nums, g, xorSubtree, tin, tout, parent, time);
            xorSubtree[u] ^= xorSubtree[v];
        }
        tout[u] = time[0]++;
    }

    // Helper: is u in v's subtree? (tin[v] <= tin[u] <= tout[v])
    private boolean isAncestor(int v, int u, int[] tin, int[] tout) {
        return tin[v] <= tin[u] && tout[u] <= tout[v];
    }
}