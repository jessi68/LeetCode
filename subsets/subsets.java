class Solution {
     private final List<List<Integer>> results = new ArrayList<>();
    
    public void makeSubset(List<Integer> subset, int cur_number, int[] nums) {
         results.add(new ArrayList<>(subset));

        for (int i = cur_number; i < nums.length; i++) {
            subset.add(nums[i]);
            makeSubset(subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
        return;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        makeSubset(new ArrayList<>(), 0, nums);
        return results;
    }
}