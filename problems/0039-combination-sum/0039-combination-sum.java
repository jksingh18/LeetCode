/*
The problem can be solved using backtracking. The idea is to explore all possible combinations of the given candidate that sum up to the target. Since the seleted candidate can be selected infinite times, we recursively include the same candidate until the sum exceeds the target or we find a valid combination.
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        calculateCombinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void calculateCombinationSum(int[] candidates, int target, int index, 
                        List<Integer> current, List<List<Integer>> result)
    {
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i=index; i<candidates.length; i++){
            current.add(candidates[i]);
            calculateCombinationSum(candidates, target-candidates[i], i, current, result);
            current.remove(current.size()-1);
        }
    }
}