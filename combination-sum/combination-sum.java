class Solution {
     List<List<Integer>> answers = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       
        combi(candidates, 0, 0, target, new ArrayList<>());
        return answers;
    }
    
     private void combi(int[] candidates, int lastIndex, int sum, int target, List<Integer> combination) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            answers.add(new ArrayList<>(combination));
            return;
        }

        for (int i = lastIndex; i < candidates.length; i++) {
            combination.add(candidates[i]);
            combi(candidates, i, sum + candidates[i], target, combination);
            combination.remove(combination.size() - 1);
        }
    }
}