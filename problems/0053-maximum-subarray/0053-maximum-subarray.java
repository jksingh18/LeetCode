class Solution {
    public int maxSubArray(int[] nums) {
            
            int max = nums[0];
            int currMax = nums[0];
            
            for(int i = 1; i < nums.length; i++){
                    currMax = Math.max(nums[i], currMax + nums[i]);
                    max = Math.max(max, currMax);
            }
        return max;
    }
}