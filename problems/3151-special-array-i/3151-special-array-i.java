class Solution {
    public boolean isArraySpecial(int[] nums) {
        // If there's only one element, it's always special
        if (nums.length == 1) return true;

        // Iterate through the array and check adjacent pairs
        for (int i = 0; i < nums.length - 1; i++) {
            // If both numbers are even or both are odd, return false
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }
        // If all pairs have different parity, return true
        return true;
    }
}