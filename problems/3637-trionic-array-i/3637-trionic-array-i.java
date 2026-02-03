class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false; // need p and q with 0<p<q<n-1

        int i = 0;

        //strictly increasing
        int start = i;
        while(i + 1 < n && nums[i] < nums[i + 1])
            i++;
        if(i == start || i == n-1) return false; //no increase or reached end

        //strictly decreasing
        start = i;
        while(i + 1 < n && nums[i] > nums[i + 1])
            i++;
        if(i == start || i == n-1) return false; //no increase or reached end

        //strictly increasing
        start = i;
        while(i + 1 < n && nums[i] < nums[i + 1])
            i++;
        if(i == start) return false; //no increase

        return (i == n-1);
    }
}