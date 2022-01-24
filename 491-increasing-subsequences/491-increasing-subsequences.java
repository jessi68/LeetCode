class Solution {
    
     Set<List<Integer>> answers = new HashSet<>();
    int [] nums;
    
    private void backtracking(int curIndex, ArrayList<Integer> curAnswer) {
        
        if(curIndex == nums.length) {
            if(curAnswer.size() >= 2) {
             answers.add(new ArrayList<>(curAnswer));
            } 
            return;
        }
        
        if(curAnswer.size() >= 2) {
             answers.add(new ArrayList<>(curAnswer));
        } 
        
        for(int i = curIndex; i < nums.length; i++) {
            if(curAnswer.size() == 0 || nums[i] >= curAnswer.get(curAnswer.size() - 1)) {
                curAnswer.add(nums[i]);
                backtracking(i + 1, curAnswer);
                curAnswer.remove(curAnswer.size() - 1);
            } else{
                continue;
            }
        }        
     
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        
       ArrayList<Integer> newPossibleAnswer = new ArrayList<Integer>();
        backtracking(0, newPossibleAnswer);
         return new ArrayList<>(answers);
    }
}