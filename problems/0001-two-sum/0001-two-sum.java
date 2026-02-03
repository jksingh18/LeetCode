class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (twoSumMap.containsKey(target - nums[i])){
                return new int[]{i, twoSumMap.get(target - nums[i])};
            }
            twoSumMap.put(nums[i], i);
        }

        return new int[]{};
    }
}