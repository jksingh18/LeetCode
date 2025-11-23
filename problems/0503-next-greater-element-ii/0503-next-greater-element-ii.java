class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i= 2*n-1; i>=0; i--){
            int index = i%n;
            while(!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }

            if(i < n){
                result[index] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[index]);
        }

        return result;
    }
}