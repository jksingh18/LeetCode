import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return; // Stop if the number exceeds n
        }
        result.add(current); // Add the current number to the result
        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i; // Generate the next number
            if (next > n) {
                break; // Stop if the next number exceeds n
            }
            dfs(next, n, result); // Recursively explore the next number
        }
    }
}