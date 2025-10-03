import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0; // No room to trap water
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));
        
        // Add all perimeter cells to the heap
        for (int i = 0; i < m; i++) {
            heap.add(new Cell(i, 0, heightMap[i][0]));
            heap.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            heap.add(new Cell(0, j, heightMap[0][j]));
            heap.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int water = 0;
        
        while (!heap.isEmpty()) {
            Cell cur = heap.poll();
            for (int[] d : dirs) {
                int nx = cur.x + d[0], ny = cur.y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                water += Math.max(0, cur.height - heightMap[nx][ny]);
                heap.add(new Cell(nx, ny, Math.max(cur.height, heightMap[nx][ny])));
            }
        }
        
        return water;
    }
    
    static class Cell {
        int x, y, height;
        Cell(int x, int y, int h) {
            this.x = x; this.y = y; this.height = h;
        }
    }
}

/*
Approach
Use a priority queue (min-heap) to process the lowest boundary cell first, and BFS to fill water "inwards":

Start from all perimeter cells (these cannot trap water).

Mark cells as visited.

Add all perimeter cells into the min-heap.

While the heap is not empty:
Pop the cell with the lowest height.
For each unvisited neighbor (up, down, left, right):
If the neighbor's height is less than the current boundary, water can be trapped: max(0, boundaryHeight - neighborHeight).
Add the neighbor into the heap with max(boundaryHeight, neighborHeight) as its effective boundary.
*/