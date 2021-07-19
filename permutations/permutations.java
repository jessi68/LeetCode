class Solution {
    
    static private List<List<Integer>> permutations;
    static private int length;
    private int[] nums;
    
    private void myPermute(Map<Integer, Boolean> nums, Integer size) {
        
        System.out.println(size);
        if(size == length) {
            
            permutations.add(new ArrayList<Integer>(nums.keySet()));
            return;
        } 
        
        for(int j = 0; j < length; j++) {
            int i = this.nums[j];
            if(!nums.containsKey(i)) {
               
                nums.put(i, false);
                myPermute(nums, size + 1);
                nums.remove(i);
               
            }
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        this.permutations = new ArrayList<>();
        
        
        
        myPermute(new LinkedHashMap<Integer, Boolean>(), 0);
        System.out.println(permutations);
        return permutations;
    }
}