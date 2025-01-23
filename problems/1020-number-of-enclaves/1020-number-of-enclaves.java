class Pair {
    int first;
    int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        Queue<Pair> queue = new LinkedList<Pair>();

        for(int row=0; row<n; row++) {
            for(int col=0; col<m; col++) {
                if(row==0 || col==0 || row==n-1 || col==m-1){
                    if(grid[row][col] == 1) {
                        queue.add(new Pair(row, col));
                        visited[row][col] = 1;
                    }
                }
            }
        }

        int[] directionRow = {+1, 0, -1, 0};
        int[] directionCol = {0, +1, 0, -1};

        while(!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for(int i=0; i<4; i++) {
                int currentRow = row + directionRow[i];
                int currentCol = col + directionCol[i];

                if(currentRow >= 0 && currentRow < n && currentCol >=0 && currentCol < m
                && visited[currentRow][currentCol] == 0 && grid[currentRow][currentCol] == 1) {
                    queue.add(new Pair(currentRow, currentCol));
                    visited[currentRow][currentCol] = 1;
                }
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    result++;
                }
            }
        }
        return result;
    }
}