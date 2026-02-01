class Solution {
    
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int minSecond = nums[1];
        int best = Integer.MAX_VALUE;

        for (int third = 2; third < n; third++) {
            best = Math.min(best, nums[0] + minSecond + nums[third]);
            minSecond = Math.min(minSecond, nums[third]); // for future thirds
        }
        return best;
    }


    /*
    public int minimumCost(int[] nums) {
        //score = firstElement + minimumElement + 2ndMinimumElement 
        int n = nums.length;
        int score = nums[0];

        int minimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] < minimum) {
                secondMinimum = minimum;
                minimum = nums[i];
            } else if (nums[i] < secondMinimum) {
                secondMinimum = nums[i];
            }
        }

        return score += (minimum + secondMinimum);

    }

    */
}