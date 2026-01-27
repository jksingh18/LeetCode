class Solution {
    public int minCost(int n, int[][] edges) {
        // graph[u] -> list of {v, cost}
        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            long w = e[2];

            graph.get(u).add(new long[]{v, w});        // normal edge
            graph.get(v).add(new long[]{u, 2 * w});    // reversed edge
        }

        // Distance array
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        // Min-heap: {distance, node}
        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        // Dijkstra
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long curDist = cur[0];
            int node = (int) cur[1];

            if (curDist > dist[node]) continue;
            if (node == n - 1) return (int)curDist;

            for (long[] edge : graph.get(node)) {
                int next = (int) edge[0];
                long cost = edge[1];

                long newDist = curDist + cost;
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.offer(new long[]{newDist, next});
                }
            }
        }

        return -1;
    }
}