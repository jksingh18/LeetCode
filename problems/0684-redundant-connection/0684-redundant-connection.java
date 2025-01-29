class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; // Number of edges (same as number of nodes)
        int[] parent = new int[n + 1]; // Parent array for Union-Find
        int[] rank = new int[n + 1]; // Rank array to optimize union operation

        // Initialize each node as its own parent (self-loop)
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1; // Initially, each node is its own tree of size 1
        }

        // Process each edge
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1]; // Nodes in the edge

            if (!union(u, v, parent, rank)) {
                return edge; // If union returns false, this edge forms a cycle
            }
        }
        return new int[]{-1, -1}; // Should never reach here
    }

    private int find(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent); // Path Compression
        }
        return parent[node];
    }

    private boolean union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if (rootU == rootV) {
            return false; // Cycle detected, nodes u and v are already connected
        }

        // Union by Rank: Attach the smaller tree under the larger one
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++; // Increase rank when merging equal rank trees
        }

        return true;
    }
}