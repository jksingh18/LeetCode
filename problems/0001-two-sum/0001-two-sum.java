class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> twoSumMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(twoSumMap.containsKey(target - nums[i])){
                return new int[]{twoSumMap.get(target - nums[i]), i};
            }
            twoSumMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}