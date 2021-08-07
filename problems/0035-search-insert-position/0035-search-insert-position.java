class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i =0; i< nums.length; i++){
            if(target <= nums[i]){  //If target is present at or smaller than the current index element
                return i;
            }
        }
        return nums.length;   //If the element is greater than the elements in the array it would add at the end.
    }
}