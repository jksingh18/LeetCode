class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n]; // Create new array of size 2n

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];       // First half is original array
            ans[i + n] = nums[i];   // Second half is also original array
        }

        return ans;
    }
}