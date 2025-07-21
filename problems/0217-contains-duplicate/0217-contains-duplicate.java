class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> containsDuplicateSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(containsDuplicateSet.contains(nums[i])){
                return true;
            }
            containsDuplicateSet.add(nums[i]);
        }
        return false;
    }
}