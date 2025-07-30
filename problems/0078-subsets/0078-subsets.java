class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        calculateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void calculateSubsets(int[] nums, int index, 
                    List<Integer> currentSubset, List<List<Integer>> result){

        result.add(new ArrayList<>(currentSubset));
        for(int i=index; i<nums.length; i++){
            //choose
            currentSubset.add(nums[i]);
            calculateSubsets(nums, i+1, currentSubset, result);
            //backtrack
            currentSubset.remove(currentSubset.size()-1);
        }
    }
}