class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Initialize a matrix to store reachability information
        boolean[][] reachable = new boolean[numCourses][numCourses];
        
        // Step 2: Populate direct prerequisites in the matrix
        for (int[] prereq : prerequisites) {
            reachable[prereq[0]][prereq[1]] = true;
        }

        // Step 3: Use Floyd-Warshall Algorithm to calculate transitive closure
        for (int k = 0; k < numCourses; k++) { // Intermediate node
            for (int i = 0; i < numCourses; i++) { // Source node
                for (int j = 0; j < numCourses; j++) { // Destination node
                    // If there is a path from i -> k and k -> j, then there is a path from i -> j
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Step 4: Process queries based on the precomputed matrix
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}