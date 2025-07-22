class Solution {
    // Use two-pointer, as the array is sorted, and the problem suggest to use O(1) Space Constraint
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            } else if(sum < target){
                left++;
            } else{
                right--;
            }
        }

        //this will never be reached, as the problem states that there will be 1 solution for sure.
        return new int[]{-1, -1};
    }
}