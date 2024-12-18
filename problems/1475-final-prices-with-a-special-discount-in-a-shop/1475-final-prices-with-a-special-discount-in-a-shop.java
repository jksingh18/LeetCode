class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; // Array to store the final prices
        java.util.Stack<Integer> stack = new java.util.Stack<>(); // Stack to track indices of prices

        // Traverse the prices array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current price is less than or equal to the price at the index in the stack
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop(); // Get the top index from the stack
                answer[index] = prices[index] - prices[i]; // Apply the discount
            }
            stack.push(i); // Push the current index to the stack
        }

        // Process any remaining indices in the stack (no discount applicable)
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices[index]; // Final price is the original price
        }

        return answer; // Return the final prices array
    }
}