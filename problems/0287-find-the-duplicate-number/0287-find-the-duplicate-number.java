class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Detect cycle using Floyd's Tortoise and Hare
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];        // Move one step
            fast = nums[nums[fast]];  // Move two steps
        } while (slow != fast);

        // Step 2: Find the duplicate number
        slow = nums[0];  // Reset slow to the start
        while (slow != fast) {
            slow = nums[slow]; // Move one step
            fast = nums[fast]; // Move one step
        }
        
        return slow; // The duplicate number
    }
}