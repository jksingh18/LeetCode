class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
            if (nums == null || nums.length == 0) {  // Base Case
                return result;
            }
            if (nums[0] > target) {                  // If target element is smaller than the first element in array 
                return result;
            }
            if (nums[nums.length - 1] < target) {    // If target element is greater than the last element in the array
                return result;
            } 
            int left = 0;                            // Binary Search
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {          // If target is at mid
                    while (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                        mid--;
                    }
                    result[0] = mid;
                    while (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    result[1] = mid;
                    return result;
                } else if (nums[mid] > target) {   // If target is greater than mid
                    right = mid - 1;
                } else {                           // If target is les than mid
                    left = mid + 1; 
                }
            }
            return result;
    }
}