class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] status = new int[m][n];
        
        for (int[] wall : walls) {
            status[wall[0]][wall[1]] = 2; // wall
        }
        for (int[] guard : guards) {
            status[guard[0]][guard[1]] = 1; // guard
        }
        
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        // mark guarded cells
        for (int[] guard : guards) {
            for (int[] d : dirs) {
                int x = guard[0] + d[0], y = guard[1] + d[1];
                while (x >= 0 && x < m && y >= 0 && y < n && status[x][y] != 2 && status[x][y] != 1) {
                    if (status[x][y] == 0) status[x][y] = -1; // mark as guarded
                    x += d[0];
                    y += d[1];
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // cell not wall, not guard, not guarded
                if (status[i][j] == 0) count++;
            }
        }
        
        return count;
    }
}