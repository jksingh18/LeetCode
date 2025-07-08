/*
This is similar to combinationSum but here, we need to select the candidate only once and also unique, so we have to handle uniqueness and include the candidate only once
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); //helps in handling duplications and stopping
        backtrackUniqueCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrackUniqueCombinations(int[] candidates, int target, int index, 
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
            //handles duplicate entries
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }

            // we can stop further exploration of this path
            if(candidates[i] > target){ break; }

            current.add(candidates[i]);
            backtrackUniqueCombinations(candidates, target-candidates[i], i+1, current, result);
            current.remove(current.size()-1);
        }
    }
}