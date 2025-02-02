class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0; // To count the number of break points

        // Traverse the array to check for break points
        for (int i = 0; i < n; i++) {

            // The tricky part is that the last element wraps around to the first element ((i + 1) % n).
            if (nums[i] > nums[(i + 1) % n]) { 
                count++; // Found a break point
            }
            
            // If more than one break point, return false early
            if (count > 1) return false;
        }

        // The array is rotated sorted if we have at most one break point
        return true;
    }
}

/*
Approach:

- A sorted, then rotated array will have at most one "break point" where nums[i] > nums[i+1] (i.e., where order is violated).
- If there is more than one such break point, then the array cannot be a rotated version of a sorted array.
- If there is zero or one "break point", then it is a rotated sorted array.
*/